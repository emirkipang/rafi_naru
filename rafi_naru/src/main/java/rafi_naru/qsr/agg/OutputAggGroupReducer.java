package rafi_naru.qsr.agg;

import org.apache.flink.api.common.functions.GroupReduceFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.Upcc;
import rafi_naru.qsr.util.Helper;

public class OutputAggGroupReducer implements GroupReduceFunction<OutputAgg, OutputAgg> {
	

	public void reduce(Iterable<OutputAgg> in, Collector<OutputAgg> out) throws Exception {
		// TODO Auto-generated method stub
		String date = "";
		String node_type = "";
		String area = "";
		String region = "";
		Double amount = 0.0;

		for (OutputAgg output : in) {
			date = output.getDate();
			node_type = output.getNode_type();
			area = output.getArea();
			region = output.getRegion();

			amount += Double.parseDouble(output.getAmount());
		}

		OutputAgg output = new OutputAgg(date, node_type, area, region, Helper.withoutScientificNotation(amount));
		out.collect(output);
	}

}
