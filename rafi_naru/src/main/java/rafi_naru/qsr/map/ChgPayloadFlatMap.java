package rafi_naru.qsr.map;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Source;
import rafi_naru.qsr.util.Constant;
import rafi_naru.qsr.util.Helper;

public class ChgPayloadFlatMap implements FlatMapFunction<String, Source> {

	private static final long serialVersionUID = 1L;

	// output
	private String date;
	private String lacci = "";
	private String revenue;

	public void flatMap(String value, Collector<Source> out) throws Exception {
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
				String Freetotalvolume = checkBlank(field[41].trim());// 41
				String Roundedtotalvolume = checkBlank(field[37].trim());// 37

				if (Servicefilter.equalsIgnoreCase("GPRS")) {
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

					// amount
					// - chg non payu : service filter = GPRS, ambil free volume
					// - chg payu : service filter = GPRS, ambil (rounded - free volume)

					revenue = Double.toString(
							Math.abs(Double.parseDouble(Roundedtotalvolume) - Double.parseDouble(Freetotalvolume)));

					// output
					out.collect(new Source(date, lacci, AParty, FutureString3, revenue, "chg"));
				}

			}
		}
	}

	private String checkBlank(String s) {
		if (s.equalsIgnoreCase(""))
			return "0";
		else
			return s;
	}

}
