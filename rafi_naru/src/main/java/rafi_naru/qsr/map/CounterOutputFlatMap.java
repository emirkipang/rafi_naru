package rafi_naru.qsr.map;

import java.text.SimpleDateFormat;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.util.Constant;
import rafi_naru.qsr.util.Helper;

public class CounterOutputFlatMap implements FlatMapFunction<String, OutputAgg> {

	private static final long serialVersionUID = 1L;

	private String next_prc_date;

	public CounterOutputFlatMap( String next_prc_date) {
		this.next_prc_date = next_prc_date;
	}

	public void flatMap(String value, Collector<OutputAgg> out) throws Exception {
		// TODO Auto-generated method stub
		String[] lines = value.split("\n");

		for (String fields : lines) {
			String[] field = fields.split("\\|", -1);

			if (field.length == Constant.COUNTER_OUTPUT_LENGTH) {
				// head
				String tanggal = field[1].trim();
				String node_type = field[2].trim();
				String area = field[3].trim();
				String region = field[4].trim();
				String msisdn = field[5].trim();
				
				if(tanggal.length() == 8) {
					tanggal = Helper.getFormattedDateOnly(tanggal);
				}
				
//				if (tanggal.substring(0, 10).equalsIgnoreCase(counter_prc_date)) {
					// output
					// out.collect(new CounterOutput(prc_date, tanggal, node_type, area, region,
					// msisdn, counter));
					OutputAgg output = new OutputAgg();
					output.setDate(next_prc_date + Constant.OUTPUT_DELIMITER + next_prc_date);
					output.setAmount("");
					output.setNode_type(node_type);
					output.setArea(area);
					output.setRegion(region);
					output.setMsisdn(msisdn);
					out.collect(output);
//				}

			}

		}
	}

}
