package rafi_naru.qsr.map;


import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Output;
import rafi_naru.qsr.model.OutputUpcc;
import rafi_naru.qsr.model.Upcc;


public class OutputPayloadFlatMap implements FlatMapFunction<OutputUpcc, Output> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void flatMap(OutputUpcc in, Collector<Output> out) throws Exception {
		// TODO Auto-generated method stub
		Output output = new Output();


		output.setFields(
				in.toString()
		);	
		
		out.collect(output);
	}


}
