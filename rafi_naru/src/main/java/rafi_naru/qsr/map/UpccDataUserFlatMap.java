package rafi_naru.qsr.map;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Upcc;
import rafi_naru.qsr.util.Constant;

public class UpccDataUserFlatMap implements FlatMapFunction<String, Upcc> {

	private static final long serialVersionUID = 1L;

	public void flatMap(String value, Collector<Upcc> out) throws Exception {
		// TODO Auto-generated method stub
		String[] lines = value.split("\n");

		for (String fields : lines) {
			String[] field = fields.split("\\,", -1);

			if (field.length == Constant.UPCC_COLUMN_LENGTH) {
				// head
				String AccessType = field[17].trim();
				String triggerType = field[0].trim();
				String MSISDN = field[4].trim(); // 4
				String Time = field[1].trim();
				String CGI = field[10].trim();
				String SAI = field[11].trim();
				String ECGI = field[46].trim();

				if (((triggerType.equalsIgnoreCase("2") || triggerType.equalsIgnoreCase("3")
						|| triggerType.equalsIgnoreCase("18")))) {
					// body
					String date = Time.substring(0, 16) + ":00";
					String lacci_or_eci = "";
					if (!CGI.equals("")) {
						lacci_or_eci = CGI.substring(5, 10) + "~" + CGI.substring(10, CGI.length());
					} else if (CGI.equals("") && !SAI.equals("")) {
						lacci_or_eci = SAI.substring(5, 10) + "~" + SAI.substring(10, SAI.length());
					} else if (CGI.equals("") && SAI.equals("") && ECGI.length() > 0) {
						lacci_or_eci = ECGI.substring(5);
					}
					String quotaUsage = "1";

					// output
					out.collect(new Upcc(date, lacci_or_eci, AccessType, quotaUsage, MSISDN));
				}
			}
		}
	}

}
