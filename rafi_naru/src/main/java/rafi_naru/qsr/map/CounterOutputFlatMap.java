package rafi_naru.qsr.map;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Chg;
import rafi_naru.qsr.model.CounterOutput;
import rafi_naru.qsr.model.Source;
import rafi_naru.qsr.util.Constant;
import rafi_naru.qsr.util.Helper;

public class CounterOutputFlatMap implements FlatMapFunction<String, CounterOutput> {

	private static final long serialVersionUID = 1L;

	public void flatMap(String value, Collector<CounterOutput> out) throws Exception {
		// TODO Auto-generated method stub
		String[] lines = value.split("\n");

		for (String fields : lines) {
			String[] field = fields.split("\\|", -1);

			// head
			String prc_date = field[0].trim();
			String tanggal = field[1].trim();
			String node_type = field[2].trim();
			String area = field[3].trim();
			String region = field[4].trim();
			String msisdn = field[5].trim();
			String counter = field[6].trim();

			out.collect(new CounterOutput(prc_date, tanggal, node_type, area, region, msisdn, counter));

		}
	}

}
