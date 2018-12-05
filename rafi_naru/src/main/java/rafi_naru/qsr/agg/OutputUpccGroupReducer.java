package rafi_naru.qsr.agg;

import org.apache.flink.api.common.functions.GroupReduceFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.OutputUpcc;
import rafi_naru.qsr.model.Upcc;
import rafi_naru.qsr.util.Helper;

public class OutputUpccGroupReducer implements GroupReduceFunction<OutputUpcc, OutputUpcc> {
	private String date = "";
	private String node_type = "";
	private String area = "";
	private String region = "";
	private Double total_payload = 0.0;

	public void reduce(Iterable<OutputUpcc> in, Collector<OutputUpcc> out) throws Exception {
		// TODO Auto-generated method stub

		for (OutputUpcc output : in) {
			date = output.getDate();
			node_type = output.getNode_type();
			area = output.getArea();
			region = output.getRegion();

			total_payload += Double.parseDouble(output.getTotal_payload());
		}

		OutputUpcc output = new OutputUpcc(date, node_type, area, region, Helper.withoutScientificNotation(total_payload));
		out.collect(output);
	}

}
