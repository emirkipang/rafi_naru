package rafi_naru.qsr.map;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Laccima;
import rafi_naru.qsr.model.SplitCodeBroadband;
import rafi_naru.qsr.model.Upcc;
import rafi_naru.qsr.util.Constant;
import rafi_naru.qsr.util.Helper;

public class SplitCodeBroadbandFlatMap implements FlatMapFunction<String, SplitCodeBroadband> {

	private static final long serialVersionUID = 1L;

	public void flatMap(String value, Collector<SplitCodeBroadband> out) throws Exception {
		// TODO Auto-generated method stub
		String[] lines = value.split("\n");

		for (String fields : lines) {
			String[] field = fields.split("\\,", -1);

			if (field.length == Constant.SPLIT_CODE_BROADBAND_COLUMN_LENGTH) {
				// head
				 String SPLITCODE = field[0].trim();
				 String DENOM = field[1].trim();
				 String COSTBAND = field[2].trim();
				 String SERVICE_TYPE_ID = field[3].trim();
				 String splitcode_with_recharge = SPLITCODE + "~" + DENOM;

				out.collect(new SplitCodeBroadband(SPLITCODE, DENOM, COSTBAND, SERVICE_TYPE_ID, splitcode_with_recharge));
			}
		}

	}

}
