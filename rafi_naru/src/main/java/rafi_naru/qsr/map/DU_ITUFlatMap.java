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

public class DU_ITUFlatMap implements FlatMapFunction<String, Source> {

	private static final long serialVersionUID = 1L;
	private String next_prc_date;

	public DU_ITUFlatMap(String next_prc_date) {
		this.next_prc_date = next_prc_date;
	}

	public void flatMap(String value, Collector<Source> out) throws Exception {
		// TODO Auto-generated method stub
		String[] lines = value.split("\n");

		for (String fields : lines) {
			String[] field = fields.split("\\|", -1);

			if (field.length == Constant.ITU_COLUMN_LENGTH) {
				// head
				String date = next_prc_date + Constant.OUTPUT_DELIMITER + next_prc_date;
				String msisdn = field[0].trim();
				String lacci = "00000~00000";
				String FutureString3 = "";
				String revenue = "";

				if (!msisdn.equalsIgnoreCase("msisdn")) {
					// output
					out.collect(new Source(date, lacci, msisdn, FutureString3, revenue, "du"));
				}
			}

		}
	}

}
