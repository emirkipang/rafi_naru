package rafi_naru.qsr.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.flink.api.common.operators.base.JoinOperatorBase.JoinHint;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.core.fs.FileSystem.WriteMode;

import rafi_naru.qsr.agg.OutputAggDistinctMsisdnGroupReducer;
import rafi_naru.qsr.agg.OutputAggGroupReducer;
import rafi_naru.qsr.join.ChgDataUserInnerJoinVasCodeBroadband;
import rafi_naru.qsr.join.RcgDataUserInnerJoinSplitCodeBroadband;
import rafi_naru.qsr.join.SourceInnerJoinLaccima;
import rafi_naru.qsr.join.SourceLeftJoinLaccimaNULL;
import rafi_naru.qsr.join.SourceLeftJoinMostDominantWithMsisdn;
import rafi_naru.qsr.map.ChgDataUserFlatMap;
import rafi_naru.qsr.map.LaccimaFlatMap;
import rafi_naru.qsr.map.MostDominantFlatMap;
import rafi_naru.qsr.map.OutputFlatMap;
import rafi_naru.qsr.map.RcgDataUserFlatMap;
import rafi_naru.qsr.map.SplitCodeBroadbandFlatMap;
import rafi_naru.qsr.map.UpccDataUserFlatMap;
import rafi_naru.qsr.map.VasCodeBroadbandFlatMap;
import rafi_naru.qsr.model.Chg;
import rafi_naru.qsr.model.Laccima;
import rafi_naru.qsr.model.MostDominant;
import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.OutputTuple;
import rafi_naru.qsr.model.Rcg;
import rafi_naru.qsr.model.Source;
import rafi_naru.qsr.model.SplitCodeBroadband;
import rafi_naru.qsr.model.VasCodeBroadband;
import rafi_naru.qsr.util.Constant;

/**
 * Hello world!
 *
 */
public class MainDataUser {
	private HashMap<String, DataSet<String>> dataset_inputs = new HashMap<String, DataSet<String>>();
	private ExecutionEnvironment env;
	private int proses_paralel;
	private int sink_paralel;
	private Configuration parameter;
	private String outputPath;

	private DataSet<Chg> src_tuples_chg;
	private DataSet<Rcg> src_tuples_rcg;

	private DataSet<Source> source_chg;
	private DataSet<Source> source_rcg;
	private DataSet<Source> source_upcc;
	private DataSet<Source> source_all;

	private DataSet<Source> source_laccima_unknown;

	private DataSet<Laccima> laccima_tuples;
	private DataSet<Laccima> laccima_tuples_3g;
	private DataSet<Laccima> laccima_tuples_4g;

	private DataSet<SplitCodeBroadband> splitcodebroadband_tuples;
	private DataSet<VasCodeBroadband> vascodebroadband_tuples;
	private DataSet<MostDominant> most_dominant_tuples;

	private DataSet<OutputAgg> outputAgg_source_laccima;
	private DataSet<OutputAgg> outputAgg_source_mostdom;
	private DataSet<OutputAgg> outputAgg_all_distinct;
	private DataSet<OutputAgg> outputAgg_all;
	private DataSet<OutputTuple> output;

	public MainDataUser(int proses_paralel, int sink_paralel, String outputPath) {
		this.env = ExecutionEnvironment.getExecutionEnvironment();
		this.parameter = new Configuration();
		this.outputPath = outputPath;

		this.proses_paralel = proses_paralel;
		this.sink_paralel = sink_paralel;
		this.env.setParallelism(this.proses_paralel);
		this.parameter.setBoolean("recursive.file.enumeration", true);

		// BasicConfigurator.configure(); //remove log warn

	}

	private String getOutputPath() {
		return this.outputPath;
	}

	private Configuration getParameter() {
		return this.parameter;
	}

	private ExecutionEnvironment getEnv() {
		return this.env;
	}

	public int getSink_paralel() {
		return this.sink_paralel;
	}

	private void setInput(HashMap<String, String> files) {

		for (Map.Entry<String, String> file : files.entrySet()) {
			dataset_inputs.put(file.getKey(), getEnv().readTextFile(file.getValue()).withParameters(getParameter()));
		}

	}

	public void processInput() {
		// source
		src_tuples_chg = dataset_inputs.get("source").flatMap(new ChgDataUserFlatMap())
				.union(dataset_inputs.get("source4").flatMap(new ChgDataUserFlatMap()));
		src_tuples_rcg = dataset_inputs.get("source2").flatMap(new RcgDataUserFlatMap())
				.union(dataset_inputs.get("source5").flatMap(new RcgDataUserFlatMap()));

		// upcc to Source directly
		source_upcc = dataset_inputs.get("source3").flatMap(new UpccDataUserFlatMap());

		// ref
		laccima_tuples_3g = dataset_inputs.get("ref_lacima").flatMap(new LaccimaFlatMap("3G", false));
		laccima_tuples_4g = dataset_inputs.get("ref_lacima_4g").flatMap(new LaccimaFlatMap("4G", false))
				.union(dataset_inputs.get("ref_lacima_4g").flatMap(new LaccimaFlatMap("4G", true)));
		
		splitcodebroadband_tuples = dataset_inputs.get("split_code_broadband").flatMap(new SplitCodeBroadbandFlatMap());
		vascodebroadband_tuples = dataset_inputs.get("vas_code_broadband").flatMap(new VasCodeBroadbandFlatMap());
		most_dominant_tuples = dataset_inputs.get("ref_most_dominant").flatMap(new MostDominantFlatMap());
	}

	public void processAggregate() {
		// Laccima
		laccima_tuples = laccima_tuples_3g.union(laccima_tuples_4g);

		/************* 1. Source *****************************/
		// Chg to Source
		source_chg = src_tuples_chg.leftOuterJoin(vascodebroadband_tuples).where("VAScode").equalTo("VASCODE")
				.with(new ChgDataUserInnerJoinVasCodeBroadband());

		// Rcg to Source
		source_rcg = src_tuples_rcg.leftOuterJoin(splitcodebroadband_tuples).where("splitcode_with_recharge")
				.equalTo("splitcode_with_recharge").with(new RcgDataUserInnerJoinSplitCodeBroadband());

		source_all = source_chg.union(source_rcg).union(source_upcc);

		/************* 2. Laccima *****************************/
		outputAgg_source_laccima = source_all.leftOuterJoin(laccima_tuples).where("lacci").equalTo("lacci_or_eci")
				.with(new SourceInnerJoinLaccima());

		/************* 3. Mostdom *****************************/
		source_laccima_unknown = source_all.leftOuterJoin(laccima_tuples).where("lacci").equalTo("lacci_or_eci")
				.with(new SourceLeftJoinLaccimaNULL());

		outputAgg_source_mostdom = source_laccima_unknown.leftOuterJoin(most_dominant_tuples).where("msisdn").equalTo("msisdn")
				.with(new SourceLeftJoinMostDominantWithMsisdn());

		/************* 4. Distinct **************************/
		outputAgg_all_distinct = outputAgg_source_laccima.union(outputAgg_source_mostdom)
				.groupBy("date", "node_type", "area", "region", "msisdn")
				.reduceGroup(new OutputAggDistinctMsisdnGroupReducer());

		/************* 5. Summary *********************************/
		outputAgg_all = outputAgg_all_distinct.groupBy("date", "node_type", "area", "region")
				.reduceGroup(new OutputAggGroupReducer());

		// Put into tuples
		output = outputAgg_all.flatMap(new OutputFlatMap(Constant.DATAUSER_HEADER));
	}

	public void sink() throws Exception {
		output.writeAsCsv(getOutputPath(), "\n", "|", WriteMode.OVERWRITE).setParallelism(getSink_paralel());

	}

	public static void main(String[] args) throws Exception {
		// set data input
		HashMap<String, String> files = new HashMap<String, String>();

		/** prod **/
		ParameterTool params = ParameterTool.fromArgs(args);

		int proses_paralel = params.getInt("slot");
		int sink_paralel = params.getInt("sink");
		String source = params.get("source");
		String source2 = params.get("source2");
		String source3 = params.get("source3");
		String source4 = params.get("source4");
		String source5 = params.get("source5");
		String laccima = params.get("laccima");
		String laccima_4g = params.get("laccima_4g");
		String most_dominant = params.get("most_dominant");
		String split_code_broadband = params.get("split_code_broadband");
		String vas_code_broadband = params.get("vas_code_broadband");
		String output = params.get("output");

		MainDataUser main = new MainDataUser(proses_paralel, sink_paralel, output);

		files.put("source", source);
		files.put("source2", source2);
		files.put("source3", source3);
		files.put("source4", source4);
		files.put("source5", source5);
		files.put("ref_lacima", laccima);
		files.put("ref_lacima_4g", laccima_4g);
		files.put("ref_most_dominant", most_dominant);
		files.put("split_code_broadband", split_code_broadband);
		files.put("vas_code_broadband", vas_code_broadband);

		/** dev **/
//		int proses_paralel = 2;
//		int sink_paralel = 1;
//		MainDataUser main = new MainDataUser(proses_paralel, sink_paralel, Constant.OUTPUT_USER);
//		files.put("source", Constant.FILE_CHG);
//		files.put("source2", Constant.FILE_RCG);
//		files.put("source3", Constant.FILE_UPCC);
//		files.put("source4", Constant.FILE_TC_CHG);
//		files.put("source5", Constant.FILE_TC_RCG);
//		files.put("ref_lacima", Constant.FILE_LACIMA);
//		files.put("ref_lacima_4g", Constant.FILE_LACIMA_4G);
//		files.put("ref_most_dominant", Constant.FILE_MOST_DOMINANT);
//		files.put("split_code_broadband", Constant.FILE_SPLIT_CODE_BROADBAND);
//		files.put("vas_code_broadband", Constant.FILE_VAS_CODE_BROADBAND);

		/****/
		main.setInput(files);
		main.processInput();
		main.processAggregate();
		main.sink();

		// System.out.println(env.getExecutionPlan());
		try {
			main.getEnv().execute(Constant.APP_NAME_USER);
		} catch (Exception e) {
			// TODO Auto-generated catch blockF
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
