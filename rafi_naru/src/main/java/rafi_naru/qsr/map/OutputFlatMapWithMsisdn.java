package rafi_naru.qsr.map;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.OutputTuple;

public class OutputFlatMapWithMsisdn implements FlatMapFunction<OutputAgg, OutputTuple> {

	private String header;
	private static final long serialVersionUID = 1L;

	public OutputFlatMapWithMsisdn(String header) {
		this.header = header;
	}

	public void flatMap(OutputAgg in, Collector<OutputTuple> out) throws Exception {
		// TODO Auto-generated method stub
		OutputTuple output = new OutputTuple(header);

		output.setFields(in.toStringWithMsisdn());

		out.collect(output);
	}

}
