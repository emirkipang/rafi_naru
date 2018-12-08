package rafi_naru.qsr.agg;

import org.apache.flink.api.common.functions.GroupReduceFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.Upcc;
import rafi_naru.qsr.util.Helper;

public class OutputAggDistinctMsisdnGroupReducer implements GroupReduceFunction<OutputAgg, OutputAgg> {
	

	public void reduce(Iterable<OutputAgg> in, Collector<OutputAgg> out) throws Exception {
		// TODO Auto-generated method stub
		String date = "";
		String node_type = "";
		String area = "";
		String region = "";
		String msisdn = "";
		String amount = "1";

		for (OutputAgg output : in) {
			date = output.getDate();
			node_type = output.getNode_type();
			area = output.getArea();
			region = output.getRegion();
			msisdn = output.getMsisdn();
		}

		OutputAgg output = new OutputAgg(date, node_type, area, region, msisdn, amount);
		out.collect(output);
	}

}
