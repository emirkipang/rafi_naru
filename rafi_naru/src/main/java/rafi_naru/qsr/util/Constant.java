package rafi_naru.qsr.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Constant {
	public static final String OUTPUT_DELIMITER = "|";
	
	// App Name
	public static final String APP_NAME_PAYLOAD = "Flink Payload Rafi/Naru";
	public static final String APP_NAME_REVENUE = "Flink Revenue Rafi/Naru";
	public static final String APP_NAME_USER = "Flink Data User Rafi/Naru";
	public static final String APP_NAME_COUNTER_USER_DISTINCT = "Flink Data User Distinct Rafi/Naru";
	public static final String APP_NAME_DU_ITU = "Flink DU ITU Base creation";
	
	public static final String PAYLOAD_HEADER = "PAYLOAD";
	public static final String USAGE_HEADER = "USAGE";
	public static final String DATAUSER_HEADER = "DATAUSER";
	public static final String DATAUSER_ITU = "DU_ITU";
	// datenow
	//public static final String datenow = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now());  

	
	// Base dir for data
	public static final String BASEDIR = "C:/Data";
	
	// Column length
	public static final int UPCC_COLUMN_LENGTH = 176;
	public static final int CHG_COLUMN_LENGTH = 81;
	public static final int RCG_COLUMN_LENGTH = 27;
	public static final int TC_CHG_COLUMN_LENGTH = 87;
	public static final int TC_RCG_COLUMN_LENGTH = 29;
	public static final int LACCIMA_COLUMN_LENGTH = 31;
	public static final int ITU_COLUMN_LENGTH = 1;
	public static final int SPLITCODEREV_COLUMN_LENGTH = 4;
	public static final int MOST_DOMINANT_COLUMN_LENGTH = 12;
	public static final int SPLIT_CODE_BROADBAND_COLUMN_LENGTH = 4;
	public static final int VAS_CODE_BROADBAND_COLUMN_LENGTH = 3;
	public static final int COUNTER_OUTPUT_LENGTH = 7;

	// Source
	public static final String FILE_UPCC = BASEDIR + "/in/upcc";
	public static final String FILE_CHG = BASEDIR + "/in/chg";
	public static final String FILE_RCG = BASEDIR + "/in/rcg";
	public static final String FILE_TC_CHG = BASEDIR + "/in/tc_chg";
	public static final String FILE_TC_RCG = BASEDIR + "/in/tc_rcg";
	public static final String FILE_DATAUSER_OUTPUT = BASEDIR + "/out/datauser/datauser_summary.csv";

	// Ref
	public static final String FILE_LACIMA = BASEDIR + "/ref/laccima/report_teradata_20181226.csv";
	public static final String FILE_LACIMA_4G = BASEDIR + "/ref/laccima/report_teradata_4g_20181226.csv";
	public static final String FILE_SPLIT_CODE_REV = BASEDIR + "/ref/20181206_Split_Code_Reference.txt";
	public static final String FILE_MOST_DOMINANT = BASEDIR + "/ref/mostdom.txt";
	public static final String FILE_SPLIT_CODE_BROADBAND = BASEDIR + "/ref/split_code_broadband.csv";
	public static final String FILE_VAS_CODE_BROADBAND = BASEDIR + "/ref/vas_code_broadband.csv";
	

	// Output
	public static final String OUTPUT_PAYLOAD = BASEDIR + "/out/payload/payload_summary.csv";
	public static final String OUTPUT_REVENUE = BASEDIR + "/out/revenue/revenue_summary.csv";
	public static final String OUTPUT_USER = BASEDIR + "/out/datauser/datauser_summary.csv";
	public static final String OUTPUT_USER_DISTINCT = BASEDIR + "/out/datauser/datauser_summary_distinct.csv";
	public static final String OUTPUT_REVENUE2 = BASEDIR + "/out/revenue/revenue_summary2.csv";

	// Ref ocs_bucket_rev
	public static final String[] OCS_BUCKET_REV = { "3311504", "3287074", "3358724", "3364804" };

	// Ref monbal
	public static final String[] MONBAL = { "BDL_Home_Pre_Basic_Prm_B_MT_OP", "BDL_Home_Pre_Basic_Prm_A_MT_OP",
			"BDL_Home_Pre_Medium_Prm_A_MT_OP", "BDL_Home_Pre_Medium_Prm_B_MT_OP", "BDL_Home_Pre_High_Prm_B_MT_OP",
			"BDL_Home_Pre_High_Prm_A_MT_OP", "BDL_Home_Pre_Jumbo_Prm_A_MT_OP", "BDL_Home_Pre_Jumbo_Prm_B_MT_OP",
			"BDL_Home_Pre_SP_A_MT_OP", "BDL_Home_Pre_SP_B_MT_OP", "homestarter_a", "homestarter_b" };
	
}
