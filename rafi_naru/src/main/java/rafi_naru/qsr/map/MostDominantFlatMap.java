package rafi_naru.qsr.map;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.MostDominant;
import rafi_naru.qsr.model.Upcc;
import rafi_naru.qsr.util.Constant;
import rafi_naru.qsr.util.Helper;

public class MostDominantFlatMap implements FlatMapFunction<String, MostDominant> {

	private static final long serialVersionUID = 1L;
	private String msisdn;
	private String node;
	private String area;
	private String region;

	public void flatMap(String value, Collector<MostDominant> out) throws Exception {
		// TODO Auto-generated method stub
		String[] lines = value.split("\n");

		for (String fields : lines) {
			String[] field = fields.split("\\|", -1);

			if (field.length == Constant.MOST_DOMINANT_COLUMN_LENGTH) {
				// head
				msisdn = field[1];
				node = field[5];
				area = field[6];
				region = field[7];

				// output
				out.collect(new MostDominant(msisdn, node, area, region));
			}

		}
	}

}
