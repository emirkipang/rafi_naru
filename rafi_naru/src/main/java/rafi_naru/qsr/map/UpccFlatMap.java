package rafi_naru.qsr.map;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Source;
import rafi_naru.qsr.model.Upcc;
import rafi_naru.qsr.util.Constant;
import rafi_naru.qsr.util.Helper;

public class UpccFlatMap implements FlatMapFunction<String, Source> {

	private static final long serialVersionUID = 1L;

	public void flatMap(String value, Collector<Source> out) throws Exception {
		// TODO Auto-generated method stub
		String[] lines = value.split("\n");

		for (String fields : lines) {
			String[] field = fields.split("\\,", -1);
			
			if(field.length == Constant.UPCC_COLUMN_LENGTH) {
				// head
				String AccessType = field[17].trim();
				String triggerType = field[0].trim();
				String MSISDN= field[4].trim(); //4
				String Time = field[1].trim();
				String CGI = field[10].trim();
				String SAI = field[11].trim();
				String ECGI = field[46].trim();
				String QuotaUsage = field[31].trim();

				if (((triggerType.equalsIgnoreCase("2") || triggerType.equalsIgnoreCase("3"))
						&& !QuotaUsage.equalsIgnoreCase("") && !QuotaUsage.equalsIgnoreCase("0"))) {
					// body
					String date = Time.substring(0, 16) + ":00";
					String lacci_or_eci = "";
					if (!CGI.equals("")) {
						lacci_or_eci = CGI.substring(5, 10) + "~" + CGI.substring(10, CGI.length());
					} else if (CGI.equals("") && !SAI.equals("")) {
						lacci_or_eci = SAI.substring(5, 10) + "~" + SAI.substring(10, SAI.length());
					} else if (CGI.equals("") && SAI.equals("") && ECGI.length() > 0) {
						//lacci_or_eci = ECGI.substring(5);
						
						// updated at 2018-12-27
						String lacci_bin = Long.toBinaryString(Long.parseLong(ECGI.substring(5)));
						String ci_bin = lacci_bin.substring(lacci_bin.length()-8,lacci_bin.length());
						String lac_bin = lacci_bin.substring(0,lacci_bin.length()-8);
						String lac = Helper.joinRule(Long.toString(Long.parseLong(lac_bin,2)), 7);
						String ci = Helper.joinRule(Long.toString(Long.parseLong(ci_bin,2)), 3);
						
						lacci_or_eci = lac + "~" + ci;
					} 

					// output
					//out.collect(new Upcc(date, lacci_or_eci, AccessType, QuotaUsage, MSISDN));
					out.collect(new Source(date, lacci_or_eci, MSISDN, AccessType, QuotaUsage, "upcc")); 
				}
			}			
		}
	}

}
