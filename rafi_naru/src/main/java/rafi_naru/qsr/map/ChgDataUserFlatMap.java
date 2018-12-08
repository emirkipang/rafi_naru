package rafi_naru.qsr.map;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Chg;
import rafi_naru.qsr.util.Constant;
import rafi_naru.qsr.util.Helper;

public class ChgDataUserFlatMap implements FlatMapFunction<String, Chg> {

	private static final long serialVersionUID = 1L;

	// output
	private String date;
	private String lacci = "";
	private String revenue;

	public void flatMap(String value, Collector<Chg> out) throws Exception {
		// TODO Auto-generated method stub
		String[] lines = value.split("\n");

		for (String fields : lines) {
			String[] field = fields.split("\\|", -1);

			if (field.length == Constant.CHG_COLUMN_LENGTH || field.length == Constant.TC_CHG_COLUMN_LENGTH) {
				// head
				String Timestamp = field[0].trim();// 0
				String CellID = field[16].trim();// 16			
				String FutureString3 = field[80].trim();// 80
				String AParty = field[1].trim(); // 1
				String Servicefilter = field[53].trim();// 53
				String VAScode = field[52];// 52

				// body
				date = Helper.getFormattedDate(Timestamp.substring(0, 12) + "00");

				// Lacci
				if (FutureString3.equalsIgnoreCase("129")) {
					lacci = CellID.substring(10, 17) + "~" + CellID.substring(17, CellID.length());
				} else if (CellID.length() == 15) {
					lacci = CellID.substring(5, 10) + "~" + CellID.substring(10, CellID.length());
				} else {
					lacci = "00000~00000";
				}

				// revenue become total trx
				revenue = "1";

				// output
				out.collect(new Chg(date, lacci, revenue, AParty, Servicefilter, VAScode));

			}
		}
	}

}
