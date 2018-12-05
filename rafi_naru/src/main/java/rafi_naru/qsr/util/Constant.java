package rafi_naru.qsr.util;

public class Constant {
	// App Name
	public static final String APP_NAME_PAYLOAD = "Flink Payload Rafi/Naru";
	public static final String APP_NAME_REVENUE = "Flink Revenue Rafi/Naru";
	public static final String APP_NAME_USER = "Flink Data User Rafi/Naru";
	
	// Base dir for data
	public static final String BASEDIR = "C:/Data";

	// Source
	public static final String FILE_UPCC = BASEDIR + "/in/upcc";
	public static final String FILE_CHG = BASEDIR + "/in/chg";
	public static final String FILE_RCG = BASEDIR + "/in/rcg";
	public static final String FILE_TC_CHG = BASEDIR + "/in/tc_chg";
	public static final String FILE_TC_RCG = BASEDIR + "/in/tc_rcg";
	
	// Ref
	public static final String FILE_LACIMA = BASEDIR
			+ "/ref/laccima/v_par_ref_lacima.csv";
	public static final String FILE_LACIMA_4G = BASEDIR
			+ "/ref/laccima/v_par_ref_lacima_4g.csv";
		
	// Output
	public static final String OUTPUT_PAYLOAD = BASEDIR
			+ "/out/payload/payload_summary.csv";
	public static final String OUTPUT_REVENUE = BASEDIR
			+ "/out/revenue/revenue_summary.csv";
	public static final String OUTPUT_USER = BASEDIR
			+ "/out/datauser/datauser_summary.csv";
	
}
