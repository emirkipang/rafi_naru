package rafi_naru.qsr.test;

import rafi_naru.qsr.util.Helper;

public class MainTest {
	public static void main(String[] args) {
//		String datetime = "2018-12-05 13:46:33";
//		String cgi = "51010123456789";
//		
//		System.out.println(datetime.substring(0, 13)+ ":00:00");
//		System.out.println(cgi.substring(5,10)+"~"+cgi.substring(10,cgi.length()));
//		System.out.println(cgi.substring(5));
		
//		String lac = "1111";
//		String ci = "11";
//		
//		System.out.println(Helper.joinRule(lac, 5));
//		System.out.println(Helper.joinRule(ci, 5));	
		
		
		String s= "10000|04461|SON047MW1_PROTELINDOARAR|NOKIA|SON047|SON047MW1|RSRG3||3G|131.26821|-0.9983694||PUMA|PAPUA BARAT|SORONG|AIMAS|WARMON|MALUKU DAN PAPUA|SORONG|SORONG|||SORONG||51010100004461|510101000004461|9150_Papua Barat C_46|46|1||";
	
		System.out.println((s.split("\\|",-1)).length);
	}

}
