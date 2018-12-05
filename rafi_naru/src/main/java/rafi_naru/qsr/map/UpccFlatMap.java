package rafi_naru.qsr.map;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Upcc;

public class UpccFlatMap implements FlatMapFunction<String, Upcc> {

	private static final long serialVersionUID = 1L;

	public void flatMap(String value, Collector<Upcc> out) throws Exception {
		// TODO Auto-generated method stub
		String[] lines = value.split("\n");

		for (String fields : lines) {
			String[] field = fields.split("\\,", -1);
			
			if(field.length == 176) {
				// head
				String AccessType = field[17];
				String triggerType = field[0];
				String Time = field[1];
				String CGI = field[10];
				String SAI = field[11];
				String ECGI = field[46];
				String QuotaUsage = field[31];

				if (((triggerType.equalsIgnoreCase("2") || triggerType.equalsIgnoreCase("3"))
						&& !QuotaUsage.equalsIgnoreCase("") && !QuotaUsage.equalsIgnoreCase("0"))) {
					// body
					String date = Time.substring(0, 13) + ":00:00";
					String lacci_or_eci = "";
					if (!CGI.equals("")) {
						lacci_or_eci = CGI.substring(5, 10) + "~" + CGI.substring(10, CGI.length());
					} else if (CGI.equals("") && !SAI.equals("")) {
						lacci_or_eci = SAI.substring(5, 10) + "~" + SAI.substring(10, SAI.length());
					} else if (CGI.equals("") && SAI.equals("") && ECGI.length() > 0) {
						lacci_or_eci = ECGI.substring(5);
					} 

					// output
					out.collect(new Upcc(date, lacci_or_eci, AccessType, QuotaUsage));
				}
			}			
		}
	}

}