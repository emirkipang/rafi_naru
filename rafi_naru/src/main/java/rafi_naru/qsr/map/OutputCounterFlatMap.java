package rafi_naru.qsr.map;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.CounterOutput;
import rafi_naru.qsr.model.OutputCounterTuple;

public class OutputCounterFlatMap implements FlatMapFunction<CounterOutput, OutputCounterTuple> {

	private static final long serialVersionUID = 1L;



	public void flatMap(CounterOutput in, Collector<OutputCounterTuple> out) throws Exception {
		// TODO Auto-generated method stub
		OutputCounterTuple output = new OutputCounterTuple();
		output.setFields(in.toString());
		out.collect(output);
	}

}
