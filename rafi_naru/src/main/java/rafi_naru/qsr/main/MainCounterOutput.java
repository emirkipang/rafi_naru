package rafi_naru.qsr.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.core.fs.FileSystem.WriteMode;

import rafi_naru.qsr.agg.CounterOutputAggGroupReducer;
import rafi_naru.qsr.agg.OutputAggGroupReducer;
import rafi_naru.qsr.map.CounterOutputFlatMap;
import rafi_naru.qsr.map.OutputCounterFlatMap;
import rafi_naru.qsr.model.CounterOutput;
import rafi_naru.qsr.model.OutputCounterTuple;
import rafi_naru.qsr.util.Constant;

/**
 * Hello Emir!!!
 *
 */
public class MainCounterOutput {
	private HashMap<String, DataSet<String>> dataset_inputs = new HashMap<String, DataSet<String>>();
	private ExecutionEnvironment env;
	private int proses_paralel;
	private int sink_paralel;
	private Configuration parameter;
	private String outputPath;

	private DataSet<CounterOutput> src_tuples_counter_output;
	private DataSet<CounterOutput> outputAgg_all;
	private DataSet<OutputCounterTuple> output;

	public MainCounterOutput(int proses_paralel, int sink_paralel, String outputPath) {
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
		src_tuples_counter_output = dataset_inputs.get("source").flatMap(new CounterOutputFlatMap())
				.union(dataset_inputs.get("source2").flatMap(new CounterOutputFlatMap()));
	}

	public void processAggregate() {
		/************* 1. Distinct **************************/
		outputAgg_all = src_tuples_counter_output.groupBy("prc_date", "tanggal", "node_type", "area", "region", "msisdn", "counter")
				.reduceGroup(new CounterOutputAggGroupReducer());

		/************* 2. Output *********************************/
		output = outputAgg_all.flatMap(new OutputCounterFlatMap());
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
		String output = params.get("output");
		MainCounterOutput main = new MainCounterOutput(proses_paralel, sink_paralel, output);
		files.put("source", source);
		files.put("source2", source2);
		/** dev **/
//		int proses_paralel = 2;
//		int sink_paralel = 1;
//		MainCounterOutput main = new MainCounterOutput(proses_paralel, sink_paralel, Constant.OUTPUT_USER_DISTINCT);
//		files.put("source", Constant.FILE_DATAUSER_OUTPUT);

		/****/
		main.setInput(files);
		main.processInput();
		main.processAggregate();
		main.sink();

		// System.out.println(env.getExecutionPlan());
		try {
			main.getEnv().execute(Constant.APP_NAME_COUNTER_USER_DISTINCT);
		} catch (Exception e) {
			// TODO Auto-generated catch blockF
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
