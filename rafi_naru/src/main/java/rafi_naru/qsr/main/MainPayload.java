package rafi_naru.qsr.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.core.fs.FileSystem.WriteMode;

import rafi_naru.qsr.agg.OutputAggGroupReducer;
import rafi_naru.qsr.join.UpccLeftJoinLaccima;
import rafi_naru.qsr.map.LaccimaFlatMap;
import rafi_naru.qsr.map.OutputFlatMap;
import rafi_naru.qsr.map.UpccFlatMap;
import rafi_naru.qsr.model.Laccima;
import rafi_naru.qsr.model.OutputTuple;
import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.Upcc;
import rafi_naru.qsr.util.Constant;

/**
 * Hello world!
 *
 */
public class MainPayload {
	private HashMap<String, DataSet<String>> dataset_inputs = new HashMap<String, DataSet<String>>();
	private ExecutionEnvironment env;
	private int proses_paralel;
	private int sink_paralel;
	private Configuration parameter;
	private String outputPath;

	// tuples variable
	private DataSet<Upcc> src_tuples;

	private DataSet<Laccima> laccima_tuples;
	private DataSet<Laccima> laccima_tuples_4g;
	private DataSet<OutputTuple> output;
	private DataSet<OutputAgg> outputUpcc;

	public MainPayload(int proses_paralel, int sink_paralel, String outputPath) {
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
		src_tuples = dataset_inputs.get("source").flatMap(new UpccFlatMap());
		laccima_tuples = dataset_inputs.get("ref_lacima").flatMap(new LaccimaFlatMap("3G", true));
		laccima_tuples_4g = dataset_inputs.get("ref_lacima_4g").flatMap(new LaccimaFlatMap("4G", true));

	}

	public void processAggregate() {
		// Laccima
		laccima_tuples = laccima_tuples.union(laccima_tuples_4g);
		
		// Upcc left join Laccima
		outputUpcc = src_tuples.leftOuterJoin(laccima_tuples)
				.where("lacci_or_eci").equalTo("lacci_or_eci")
				.with(new UpccLeftJoinLaccima());
		
		// Summary Upcc
		outputUpcc = outputUpcc.groupBy("date", "node_type", "area", "region").reduceGroup(new OutputAggGroupReducer());
		
		// Put into tuples
		output = outputUpcc.flatMap(new OutputFlatMap());
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
		 String laccima = params.get("laccima");
		 String laccima_4g = params.get("laccima_4g");
		 String output = params.get("output");
		
		 MainPayload main = new MainPayload(proses_paralel, sink_paralel, output);
		
		 files.put("source", source);
		 files.put("ref_lacima", laccima);
		 files.put("ref_lacima_4g", laccima_4g);

		/** dev **/
//		int proses_paralel = 2;
//		int sink_paralel = 1;
//		MainPayload main = new MainPayload(proses_paralel, sink_paralel, Constant.OUTPUT_PAYLOAD);
//		files.put("source", Constant.FILE_UPCC);
//		files.put("ref_lacima", Constant.FILE_LACIMA);
//		files.put("ref_lacima_4g", Constant.FILE_LACIMA_4G);
		/****/

		main.setInput(files);
		main.processInput();
		main.processAggregate();
		main.sink();

		// System.out.println(env.getExecutionPlan());
		try {
			main.getEnv().execute(Constant.APP_NAME_PAYLOAD);
		} catch (Exception e) {
			// TODO Auto-generated catch blockF
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
