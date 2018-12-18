package rafi_naru.qsr.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.core.fs.FileSystem.WriteMode;

import rafi_naru.qsr.agg.OutputAggDistinctMsisdnGroupReducer;
import rafi_naru.qsr.agg.OutputAggGroupReducer;
import rafi_naru.qsr.join.SourceLeftJoinMostDominantWithMsisdn;
import rafi_naru.qsr.map.DU_ITUFlatMap;
import rafi_naru.qsr.map.MostDominantFlatMap;
import rafi_naru.qsr.map.OutputCounterFlatMap;
import rafi_naru.qsr.map.OutputFlatMapWithMsisdn;
import rafi_naru.qsr.model.DU_ITU;
import rafi_naru.qsr.model.MostDominant;
import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.OutputCounterTuple;
import rafi_naru.qsr.model.OutputTuple;
import rafi_naru.qsr.model.Source;
import rafi_naru.qsr.util.Constant;

/**
 * Hello Emir!!!
 *
 */
public class MainDataUserITU {
	private HashMap<String, DataSet<String>> dataset_inputs = new HashMap<String, DataSet<String>>();
	private ExecutionEnvironment env;
	private int proses_paralel;
	private int sink_paralel;
	private Configuration parameter;
	private String outputPath;
	private String prc_date;

	private DataSet<Source> source;
	private DataSet<MostDominant> most_dominant_tuples;
	private DataSet<OutputAgg> outputAgg;
	private DataSet<OutputTuple> output;

	public MainDataUserITU(int proses_paralel, int sink_paralel, String outputPath) {
		this.env = ExecutionEnvironment.getExecutionEnvironment();
		this.parameter = new Configuration();
		this.outputPath = outputPath;
		this.prc_date = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()); 

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
		source = dataset_inputs.get("source").flatMap(new DU_ITUFlatMap(this.prc_date));
		
		// ref
		most_dominant_tuples = dataset_inputs.get("ref_most_dominant").flatMap(new MostDominantFlatMap());
	}

	public void processAggregate() {
		/************* 1. Join Mostdom **************************/
		outputAgg = source.leftOuterJoin(most_dominant_tuples).where("msisdn").equalTo("msisdn")
				.with(new SourceLeftJoinMostDominantWithMsisdn());

		outputAgg = outputAgg
				.groupBy("date", "node_type", "area", "region", "msisdn")
				.reduceGroup(new OutputAggDistinctMsisdnGroupReducer());
		
		/************* 3. Output *********************************/
		output = outputAgg.flatMap(new OutputFlatMapWithMsisdn(Constant.DATAUSER_ITU));
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
		String most_dominant = params.get("most_dominant");
		String output = params.get("output");
		
		MainDataUserITU main = new MainDataUserITU(proses_paralel, sink_paralel, output);
		files.put("source", source);
		files.put("ref_most_dominant", most_dominant);
		
		/** dev **/
//		int proses_paralel = 2;
//		int sink_paralel = 1;
//		MainDU_ITU main = new MainDU_ITU(proses_paralel, sink_paralel, Constant.OUTPUT_USER_DISTINCT);
//		files.put("source", Constant.FILE_DATAUSER_OUTPUT);

		/****/
		main.setInput(files);
		main.processInput();
		main.processAggregate();
		main.sink();

		// System.out.println(env.getExecutionPlan());
		try {
			main.getEnv().execute(Constant.APP_NAME_DU_ITU);
		} catch (Exception e) {
			// TODO Auto-generated catch blockF
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
