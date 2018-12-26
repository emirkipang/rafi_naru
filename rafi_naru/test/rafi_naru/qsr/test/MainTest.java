package rafi_naru.qsr.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import rafi_naru.qsr.util.Helper;

public class MainTest {
	public static void main(String[] args) {
//		String s = "+628115520412";
//		System.out.println(s.replace("+", ""));
		
		String s = "2018-12-08";
		System.out.println(s.substring(0,10));

//		String datetime = "20181203120506";
////		String cgi = "5101000000123456789";
//		
//		System.out.println(datetime.substring(0, 4));
//		System.out.println(datetime.substring(4, 6));
//		System.out.println(datetime.substring(6, 8));
//		System.out.println(datetime.substring(8, 10));
//		System.out.println(datetime.substring(10, 12));

		// System.out.println(datetime.substring(0, 12)+ "00");
//		System.out.println(cgi.substring(5,10)+"~"+cgi.substring(10,cgi.length()));
//		System.out.println(cgi.substring(10,15)+"~"+cgi.substring(15,cgi.length()));
//		System.out.println(cgi.substring(5));

//		String lac = "51010000000268036021";
//		String ci = "11";
//		
//		System.out.println(Helper.joinRule(lac, 5));
//		System.out.println(Helper.joinRule(ci, 5));	

//		String s= "20181203120506|6285248434690||c0d6950001|+628115520412|28519403673187||0|0|0| ||0| |0|6281107020|510100736111686|||| |SMS|12391|IDR|Active|0|0|0|1|7278.00|325.00|842013083|6285248434690|6285248434690|C|0|0|0|1|325.00|0.0000|0|0|O|Dummy charge code|1| |||1| | | |SMTKMO|JKT|JKT| | |D|484543400053149899| | | | | |N|0|612|20181203130507|40|SMS_Tsel|12391|0| |0|3686794|0|0| | | ";
//	
//		System.out.println((s.split("\\|",-1)).length);

//		Double n = 122222222222222222222222223.0;
//		
//		System.out.println(Helper.withoutScientificNotation(n));

//		String n = "3722984#59076#108#Duration";
//		System.out.println(n.split("\\#",-1)[0]);

//		String s ="sssvC_D123asdasd";
//		
//		if(s.contains("VC_D")) {
//			System.out.println("asd");
//		}

		// 00 - 14 -> 00
		// 15 - 29 -> 15
		// 30 - 44 -> 30
		// 45 - 59 -> 45

//		String date = "2018-12-03 12:56:00";
//		String pre = date.substring(0, 14);
//		String post = date.substring(16, date.length());
//
//
//		String menit = date.substring(14, 16);
//		int int_menit = Integer.parseInt(menit);
//
//		if (int_menit >= 0 && int_menit <= 14) {
//			menit = "00";
//		} else if (int_menit >= 15 && int_menit <= 29) {
//			menit = "15";
//		} else if (int_menit >= 30 && int_menit <= 44) {
//			menit = "30";
//		} else if (int_menit >= 45 && int_menit <= 59) {
//			menit = "45";
//		}
//		
//		System.out.println(pre + menit + post);
		
//		String msisdn = "6281";
//		if(msisdn.length() >= 3) {
//			if(msisdn.substring(0,3).equalsIgnoreCase("628")) {
//				System.out.println("Valid");
//			} else {
//				System.out.println("Invalid");
//			}
//		}
//		
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");  
//		   LocalDateTime now = LocalDateTime.now();  
//		   System.out.println(dtf.format(now));  
	}

}
