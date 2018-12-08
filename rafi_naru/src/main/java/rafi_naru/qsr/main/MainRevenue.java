package rafi_naru.qsr.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.core.fs.FileSystem.WriteMode;

import rafi_naru.qsr.agg.OutputAggGroupReducer;
import rafi_naru.qsr.join.ChgInnerJoinLaccima;
import rafi_naru.qsr.join.ChgLeftJoinLaccimaNULL;
import rafi_naru.qsr.join.RcgInnerJoinLaccima;
import rafi_naru.qsr.join.RcgInnerJoinSplitCodeRev;
import rafi_naru.qsr.join.RcgLeftJoinLaccimaNULL;
import rafi_naru.qsr.join.UnknownRevLeftJoinMostDominant;
import rafi_naru.qsr.join.UpccInnerJoinLaccima;
import rafi_naru.qsr.join.UpccLeftJoinLaccimaNULL;
import rafi_naru.qsr.join.UpccLeftJoinMostDominant;
import rafi_naru.qsr.map.ChgFlatMap;
import rafi_naru.qsr.map.LaccimaFlatMap;
import rafi_naru.qsr.map.MostDominantFlatMap;
import rafi_naru.qsr.map.OutputFlatMap;
import rafi_naru.qsr.map.RcgFlatMap;
import rafi_naru.qsr.map.SplitCodeRevFlatMap;
import rafi_naru.qsr.model.Chg;
import rafi_naru.qsr.model.Laccima;
import rafi_naru.qsr.model.MostDominant;
import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.OutputTuple;
import rafi_naru.qsr.model.Rcg;
import rafi_naru.qsr.model.SplitCodeRev;
import rafi_naru.qsr.model.UnknownRev;
import rafi_naru.qsr.revenue.join.ChgLeftJoinLaccima;
import rafi_naru.qsr.revenue.join.RcgLeftJoinLaccima;
import rafi_naru.qsr.util.Constant;

/**
 * Hello world!
 *
 */
public class MainRevenue {
	private HashMap<String, DataSet<String>> dataset_inputs = new HashMap<String, DataSet<String>>();
	private ExecutionEnvironment env;
	private int proses_paralel;
	private int sink_paralel;
	private Configuration parameter;
	private String outputPath;

	// tuples variable
	private DataSet<Chg> src_tuples;
	private DataSet<UnknownRev> src_tuples_laccima_unknown;
	private DataSet<Rcg> src_tuples2;
	private DataSet<UnknownRev> src_tuples2_laccima_unknown;

	private DataSet<Laccima> laccima_tuples;
	private DataSet<Laccima> laccima_tuples_4g;
	private DataSet<SplitCodeRev> splitcoderev_tuples;
	private DataSet<MostDominant> most_dominant_tuples;

	private DataSet<OutputTuple> output;
	private DataSet<OutputAgg> outputAgg1;
	private DataSet<OutputAgg> outputAgg2;
	private DataSet<OutputAgg> outputAgg3;
	private DataSet<OutputAgg> outputAgg;

	public MainRevenue(int proses_paralel, int sink_paralel, String outputPath) {
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
		src_tuples = dataset_inputs.get("source").flatMap(new ChgFlatMap())
				.union(dataset_inputs.get("source3").flatMap(new ChgFlatMap()));
		src_tuples2 = dataset_inputs.get("source2").flatMap(new RcgFlatMap())
				.union(dataset_inputs.get("source4").flatMap(new RcgFlatMap()));

		// ref
		laccima_tuples = dataset_inputs.get("ref_lacima").flatMap(new LaccimaFlatMap("3G", false));
		laccima_tuples_4g = dataset_inputs.get("ref_lacima_4g").flatMap(new LaccimaFlatMap("4G", false));
		splitcoderev_tuples = dataset_inputs.get("split_code_ref").flatMap(new SplitCodeRevFlatMap());
		most_dominant_tuples = dataset_inputs.get("ref_most_dominant").flatMap(new MostDominantFlatMap());
	}

	public void processAggregate() {
		// Laccima
		laccima_tuples = laccima_tuples.union(laccima_tuples_4g);

		// Chg inner join Laccima
		outputAgg1 = src_tuples.leftOuterJoin(laccima_tuples).where("lacci").equalTo("lacci_or_eci")
				.with(new ChgInnerJoinLaccima());

		// chg left join laccima NULL
		src_tuples_laccima_unknown = src_tuples.leftOuterJoin(laccima_tuples).where("lacci").equalTo("lacci_or_eci")
				.with(new ChgLeftJoinLaccimaNULL());

		// Rcg inner join SplitCodeRev
		src_tuples2 = src_tuples2.leftOuterJoin(splitcoderev_tuples).where("splitcode_with_recharge")
				.equalTo("splitcode_with_recharge").with(new RcgInnerJoinSplitCodeRev());

		// Rcg inner join Laccima
		outputAgg2 = src_tuples2.leftOuterJoin(laccima_tuples).where("lacci").equalTo("lacci_or_eci")
				.with(new RcgInnerJoinLaccima());

		// rcg left join laccima NULL
		src_tuples2_laccima_unknown = src_tuples2.leftOuterJoin(laccima_tuples).where("lacci").equalTo("lacci_or_eci")
				.with(new RcgLeftJoinLaccimaNULL());

		// chg laccima null + rcg laccima null -> mostdom
		outputAgg3 = (src_tuples_laccima_unknown.union(src_tuples2_laccima_unknown)).leftOuterJoin(most_dominant_tuples)
				.where("MSISDN").equalTo("msisdn").with(new UnknownRevLeftJoinMostDominant());

		// Summary Chg
		outputAgg = outputAgg1.union(outputAgg2).union(outputAgg3);
		outputAgg = outputAgg.groupBy("date", "node_type", "area", "region").reduceGroup(new OutputAggGroupReducer());

		// Put into tuples
		output = outputAgg.flatMap(new OutputFlatMap(Constant.USAGE_HEADER));
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
		String laccima = params.get("laccima");
		String laccima_4g = params.get("laccima_4g");
		String most_dominant = params.get("most_dominant");
		String split_code_ref = params.get("split_code_ref");
		String output = params.get("output");

		MainRevenue main = new MainRevenue(proses_paralel, sink_paralel, output);

		files.put("source", source);
		files.put("source2", source2);
		files.put("source3", source3);
		files.put("source4", source4);
		files.put("ref_lacima", laccima);
		files.put("ref_lacima_4g", laccima_4g);
		files.put("ref_most_dominant", most_dominant);
		files.put("split_code_ref", split_code_ref);

		/** dev **/
//		int proses_paralel = 2;
//		int sink_paralel = 1;
//		MainRevenue main = new MainRevenue(proses_paralel, sink_paralel, Constant.OUTPUT_REVENUE);
//		files.put("source", Constant.FILE_CHG);
//		files.put("source2", Constant.FILE_RCG);
//		files.put("source3", Constant.FILE_TC_CHG);
//		files.put("source4", Constant.FILE_TC_RCG);
//		files.put("ref_lacima", Constant.FILE_LACIMA);
//		files.put("ref_lacima_4g", Constant.FILE_LACIMA_4G);
//		files.put("ref_most_dominant", Constant.FILE_MOST_DOMINANT);
//		files.put("split_code_ref", Constant.FILE_SPLIT_CODE_REV);

		/****/

		main.setInput(files);
		main.processInput();
		main.processAggregate();
		main.sink();

		// System.out.println(env.getExecutionPlan());
		try {
			main.getEnv().execute(Constant.APP_NAME_REVENUE);
		} catch (Exception e) {
			// TODO Auto-generated catch blockF
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
