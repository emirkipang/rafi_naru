package rafi_naru.qsr.map;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Laccima;
import rafi_naru.qsr.model.SplitCodeRev;
import rafi_naru.qsr.model.Upcc;
import rafi_naru.qsr.util.Constant;
import rafi_naru.qsr.util.Helper;

public class SplitCodeRevFlatMap implements FlatMapFunction<String, SplitCodeRev> {

	private static final long serialVersionUID = 1L;

	// output
	private String splitCode;
	private String feed;
	private String recharge_amount;
	private String desc;
	private String splitcode_with_recharge;

	public void flatMap(String value, Collector<SplitCodeRev> out) throws Exception {
		// TODO Auto-generated method stub
		String[] lines = value.split("\n");

		for (String fields : lines) {
			String[] field = fields.split("\\|", -1);

			if (field.length == Constant.SPLITCODEREV_COLUMN_LENGTH) {
				// head
				splitCode = field[0].trim();
				feed = field[1].trim();
				recharge_amount = field[2].trim();
				desc = field[3].trim();
				splitcode_with_recharge = splitCode + "~" + recharge_amount;

				out.collect(new SplitCodeRev(splitCode, feed, recharge_amount, desc, splitcode_with_recharge));
			}
		}

	}

}
