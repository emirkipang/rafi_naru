package rafi_naru.qsr.map;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Chg;
import rafi_naru.qsr.util.Constant;
import rafi_naru.qsr.util.Helper;

public class ChgFlatMap implements FlatMapFunction<String, Chg> {

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
			
			if(field.length == Constant.CHG_COLUMN_LENGTH || field.length == Constant.TC_CHG_COLUMN_LENGTH) {
				// head
				String Timestamp = field[0].trim();//0
				String CellID = field[16].trim();//16
				String AccountDelta = field[30].trim();//30
				String Chargeincludingfreeallowance = field[39].trim();//39
				String Bonusconsumed = field[51].trim();//51
				String VAScode = field[52].trim();//52
				String Creditindicator = field[58].trim();//58
				String Contentid = field[63].trim(); ;//63
				String FutureString3 = field[80].trim();//80
				//String BParty = field[4].trim().replace("+", ""); //4
				String AParty = field[1].trim(); // 1

				
				if (!Chargeincludingfreeallowance.equalsIgnoreCase("0.00") && !AccountDelta.equalsIgnoreCase("0.00") &&
						!Chargeincludingfreeallowance.equalsIgnoreCase("") && !AccountDelta.equalsIgnoreCase("")) {
					// body
					date = Helper.getFormattedDate(Timestamp.substring(0, 12)+ "00");
					
					// Lacci
					if(FutureString3.equalsIgnoreCase("129")) {
						lacci = CellID.substring(10,17)+"~"+CellID.substring(17,CellID.length());
					} else if(CellID.length() == 15){
						lacci = CellID.substring(5,10)+"~"+CellID.substring(10, CellID.length());
					} else {
						lacci = "00000~00000";
					}
					
					// revenue
					String bonusID = Bonusconsumed.split("\\#",-1)[0];
					if (isRevBonusId(bonusID) && Creditindicator.equals("D")) {
						revenue = Chargeincludingfreeallowance;
					} else if(VAScode.contains("VC_D") && Creditindicator.equals("D")) {
						revenue = Chargeincludingfreeallowance;
					} else if(Creditindicator.equals("C")) {
						revenue = Double.toString((Double.parseDouble(AccountDelta) * -1)) ;
					} else if(isMonbal(Contentid)&& Creditindicator.equals("D")) {
						revenue = Chargeincludingfreeallowance;
					} else {
						revenue = AccountDelta;
					}					
				

					// output
					out.collect(new Chg(date, lacci, revenue, AParty));
				}
			}			
		}
	}
	
	private boolean isRevBonusId(String bonusId) {
		for (int i = 0; i < Constant.OCS_BUCKET_REV.length; i++) {
			if (bonusId.equals(Constant.OCS_BUCKET_REV[i]))
				return true;
		}
		return false;
	}

	private boolean isMonbal(String ContentId) {
		for (int i = 0; i < Constant.MONBAL.length; i++) {
			if (ContentId.equals(Constant.MONBAL[i]))
				return true;
		}

		return false;
	}
}
