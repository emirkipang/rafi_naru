package rafi_naru.qsr.revenue.map;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.revenue.model.Rcg;
import rafi_naru.qsr.util.Constant;
import rafi_naru.qsr.util.Helper;

public class RcgFlatMap implements FlatMapFunction<String, Rcg> {

	private static final long serialVersionUID = 1L;
	
	// output
	private String date;
	private String lacci;
	private String revenue;
	private String splitcode_with_recharge;

	public void flatMap(String value, Collector<Rcg> out) throws Exception {
		// TODO Auto-generated method stub
		String[] lines = value.split("\n");

		for (String fields : lines) {
			String[] field = fields.split("\\|", -1);
			
			if(field.length == Constant.RCG_COLUMN_LENGTH) {
				// head
				String Timestamp = field[0].trim();//0
				String Anumberlocation = field[17].trim();//17
				String SplitCode = field[23].trim();//23
				String RechargeAmount = field[24].trim();//24
				String Future_String_3 = field[26].trim();//26
				String MSISDN = field[1].trim(); //1
				
				if (!SplitCode.equalsIgnoreCase("001") && !SplitCode.equalsIgnoreCase("088")) {
					// body
					date = Helper.getFormattedDate(Timestamp.substring(0, 12)+ "00");
					
					// Lacci
					if(Future_String_3.equalsIgnoreCase("4G") && !Anumberlocation.equalsIgnoreCase("")) {
						lacci = Anumberlocation.substring(0,7)+"~"+Anumberlocation.substring(7,Anumberlocation.length());
					} else if(!Future_String_3.equalsIgnoreCase("4G") && Anumberlocation.length() == 10 ){
						lacci = Anumberlocation.substring(0,5)+"~"+Anumberlocation.substring(5, Anumberlocation.length());
					} else {
						lacci = "00000~00000";
					}

					// revenue
					revenue = RechargeAmount;
					
					// splitcode with rechargeamount
					splitcode_with_recharge = SplitCode + "~" + revenue;
					
					// output
					out.collect(new Rcg(date, lacci, revenue, splitcode_with_recharge, MSISDN));
				}
			}			
		}
	}

}
