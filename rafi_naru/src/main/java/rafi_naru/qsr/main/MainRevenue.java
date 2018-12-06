package rafi_naru.qsr.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.core.fs.FileSystem.WriteMode;

import rafi_naru.qsr.agg.OutputAggGroupReducer;
import rafi_naru.qsr.join.ChgLeftJoinLaccima;
import rafi_naru.qsr.join.RcgLeftJoinLaccima;
import rafi_naru.qsr.join.RcgLeftJoinSplitCodeRev;
import rafi_naru.qsr.map.ChgFlatMap;
import rafi_naru.qsr.map.LaccimaFlatMap;
import rafi_naru.qsr.map.OutputFlatMap;
import rafi_naru.qsr.map.RcgFlatMap;
import rafi_naru.qsr.map.SplitCodeRevFlatMap;
import rafi_naru.qsr.model.Chg;
import rafi_naru.qsr.model.Laccima;
import rafi_naru.qsr.model.OutputTuple;
import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.Rcg;
import rafi_naru.qsr.model.SplitCodeRev;
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
	private DataSet<Rcg> src_tuples2;

	private DataSet<Laccima> laccima_tuples;
	private DataSet<Laccima> laccima_tuples_4g;
	private DataSet<SplitCodeRev> splitcoderev_tuples;

	private DataSet<OutputTuple> output;
	private DataSet<OutputAgg> outputAgg;
	private DataSet<OutputAgg> outputAgg2;

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
		src_tuples = dataset_inputs.get("source").flatMap(new ChgFlatMap());
		src_tuples2 = dataset_inputs.get("source2").flatMap(new RcgFlatMap());

		// ref
		laccima_tuples = dataset_inputs.get("ref_lacima").flatMap(new LaccimaFlatMap("3G", false));
		laccima_tuples_4g = dataset_inputs.get("ref_lacima_4g").flatMap(new LaccimaFlatMap("4G", false));
		splitcoderev_tuples = dataset_inputs.get("split_code_ref").flatMap(new SplitCodeRevFlatMap());

	}

	public void processAggregate() {
		// Laccima
		laccima_tuples = laccima_tuples.union(laccima_tuples_4g);

		// Chg left join Laccima
		outputAgg = src_tuples.leftOuterJoin(laccima_tuples).where("lacci").equalTo("lacci_or_eci")
				.with(new ChgLeftJoinLaccima());

		// Rcg left join SplitCodeRev
		src_tuples2 = src_tuples2.leftOuterJoin(splitcoderev_tuples).where("splitcode_with_recharge")
				.equalTo("splitcode_with_recharge").with(new RcgLeftJoinSplitCodeRev());

		// Rcg left join Laccima
		outputAgg2 = src_tuples2.leftOuterJoin(laccima_tuples).where("lacci").equalTo("lacci_or_eci")
				.with(new RcgLeftJoinLaccima());

		// Summary Chg
		outputAgg = outputAgg.union(outputAgg2);
		outputAgg = outputAgg.groupBy("date", "node_type", "area", "region").reduceGroup(new OutputAggGroupReducer());

		// Put into tuples
		output = outputAgg2.flatMap(new OutputFlatMap());
	}

	public void sink() throws Exception {
		output.writeAsCsv(getOutputPath(), "\n", "|", WriteMode.OVERWRITE).setParallelism(getSink_paralel());

	}

	public static void main(String[] args) throws Exception {
		// set data input
		HashMap<String, String> files = new HashMap<String, String>();

		/** prod **/
//		 ParameterTool params = ParameterTool.fromArgs(args);
//		
//		 int proses_paralel = params.getInt("slot");
//		 int sink_paralel = params.getInt("sink");
//		 String source = params.get("source");
//		 String laccima = params.get("laccima");
//		 String laccima_4g = params.get("laccima_4g");
//		 String output = params.get("output");
//		
//		 MainRevenue main = new MainRevenue(proses_paralel, sink_paralel, output);
//		
//		 files.put("source", source);
//		 files.put("ref_lacima", laccima);
//		 files.put("ref_lacima_4g", laccima_4g);

		/** dev **/
		int proses_paralel = 2;
		int sink_paralel = 1;
		MainRevenue main = new MainRevenue(proses_paralel, sink_paralel, Constant.OUTPUT_REVENUE);
		files.put("source", Constant.FILE_CHG);
		files.put("source2", Constant.FILE_RCG);
		files.put("ref_lacima", Constant.FILE_LACIMA);
		files.put("ref_lacima_4g", Constant.FILE_LACIMA_4G);
		files.put("split_code_ref", Constant.FILE_SPLIT_CODE_REV);
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
