package rafi_naru.qsr.agg;

import org.apache.flink.api.common.functions.GroupReduceFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.CounterOutput;
import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.Upcc;
import rafi_naru.qsr.util.Helper;

public class CounterOutputAggGroupReducer implements GroupReduceFunction<CounterOutput, CounterOutput> {
	
	private String tempMsisdn = "";
	
	public void reduce(Iterable<CounterOutput> in, Collector<CounterOutput> out) throws Exception {
		// TODO Auto-generated method stub
		String prc_date = "";
		String tanggal = "";
		String node_type = "";
		String area = "";
		String region = "";
		String msisdn = "";
		String counter = "";

		for (CounterOutput output : in) {
			prc_date = output.getPrc_date();
			tanggal = output.getTanggal();
			node_type = output.getNode_type();
			area = output.getArea();
			region = output.getRegion();
			msisdn = output.getMsisdn();
			counter = output.getCounter();
		}

		CounterOutput output = new CounterOutput(prc_date, tanggal, node_type, area, region, msisdn, counter);
		out.collect(output);
	}

}
