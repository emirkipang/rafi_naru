package rafi_naru.qsr.revenue.model;

public class Rcg {
	private String Timestamp;//0
	private String MSISDN;//1
	private String Account;//2
	private String RechargeChannel;//3
	private String Expirationdate;//4
	private String Serialnumber;//5
	private String DeltaBalance;//6
	private String Balanceamount;//7
	private String Creditindicator;//8
	private String Rechargemethod;//9
	private String RechargeID;//10
	private String Bonusinformation;//11
	private String providerID;//12
	private String SourceIP;//13
	private String UserID;//14
	private String ResultCode;//15
	private String Bankcode;//16
	private String Anumberlocation;//17
	private String Balancebefore;//18
	private String AdjustmentReason;//19
	private String CaseID;//20
	private String CRMUserID;//21
	private String OldExpirationDate;//22
	private String SplitCode;//23
	private String RechargeAmount;//24
	private String Future_String_2;//25
	private String Future_String_3;//26
	// tc
	private String IFRS_ALLOWANCE_INFO;//27
	private String IFRS_IND;//28
	
	private String date; // -1
	private String lacci; // -1
	private String revenue; // -1
	private String splitcode_with_recharge; // -1

	public Rcg(String date, String lacci, String revenue, String splitcode_with_recharge, String MSISDN) {
		super();
		this.date = date;
		this.lacci = lacci;
		this.revenue = revenue;
		this.splitcode_with_recharge = splitcode_with_recharge;
		this.MSISDN = MSISDN;
	}
	
	public Rcg(String date, String lacci, String revenue) {
		super();
		this.date = date;
		this.lacci = lacci;
		this.revenue = revenue;
	}
	
	
	public Rcg() {
		super();
	}
	public String getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(String timestamp) {
		Timestamp = timestamp;
	}
	public String getMSISDN() {
		return MSISDN;
	}
	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}
	public String getAccount() {
		return Account;
	}
	public void setAccount(String account) {
		Account = account;
	}
	public String getRechargeChannel() {
		return RechargeChannel;
	}
	public void setRechargeChannel(String rechargeChannel) {
		RechargeChannel = rechargeChannel;
	}
	public String getExpirationdate() {
		return Expirationdate;
	}
	
	public String getSplitcode_with_recharge() {
		return splitcode_with_recharge;
	}

	public void setSplitcode_with_recharge(String splitcode_with_recharge) {
		this.splitcode_with_recharge = splitcode_with_recharge;
	}

	public void setExpirationdate(String expirationdate) {
		Expirationdate = expirationdate;
	}
	public String getSerialnumber() {
		return Serialnumber;
	}
	public void setSerialnumber(String serialnumber) {
		Serialnumber = serialnumber;
	}
	public String getDeltaBalance() {
		return DeltaBalance;
	}
	public void setDeltaBalance(String deltaBalance) {
		DeltaBalance = deltaBalance;
	}
	public String getBalanceamount() {
		return Balanceamount;
	}
	public void setBalanceamount(String balanceamount) {
		Balanceamount = balanceamount;
	}
	public String getCreditindicator() {
		return Creditindicator;
	}
	public void setCreditindicator(String creditindicator) {
		Creditindicator = creditindicator;
	}
	public String getRechargemethod() {
		return Rechargemethod;
	}
	public void setRechargemethod(String rechargemethod) {
		Rechargemethod = rechargemethod;
	}
	public String getRechargeID() {
		return RechargeID;
	}
	public void setRechargeID(String rechargeID) {
		RechargeID = rechargeID;
	}
	public String getBonusinformation() {
		return Bonusinformation;
	}
	public void setBonusinformation(String bonusinformation) {
		Bonusinformation = bonusinformation;
	}
	public String getProviderID() {
		return providerID;
	}
	public void setProviderID(String providerID) {
		this.providerID = providerID;
	}
	public String getSourceIP() {
		return SourceIP;
	}
	public void setSourceIP(String sourceIP) {
		SourceIP = sourceIP;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getResultCode() {
		return ResultCode;
	}
	public void setResultCode(String resultCode) {
		ResultCode = resultCode;
	}
	public String getBankcode() {
		return Bankcode;
	}
	public void setBankcode(String bankcode) {
		Bankcode = bankcode;
	}
	public String getAnumberlocation() {
		return Anumberlocation;
	}
	public void setAnumberlocation(String anumberlocation) {
		Anumberlocation = anumberlocation;
	}
	public String getBalancebefore() {
		return Balancebefore;
	}
	public void setBalancebefore(String balancebefore) {
		Balancebefore = balancebefore;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLacci() {
		return lacci;
	}

	public void setLacci(String lacci) {
		this.lacci = lacci;
	}

	public String getRevenue() {
		return revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	public String getAdjustmentReason() {
		return AdjustmentReason;
	}
	public void setAdjustmentReason(String adjustmentReason) {
		AdjustmentReason = adjustmentReason;
	}
	public String getCaseID() {
		return CaseID;
	}
	public void setCaseID(String caseID) {
		CaseID = caseID;
	}
	public String getCRMUserID() {
		return CRMUserID;
	}
	public void setCRMUserID(String cRMUserID) {
		CRMUserID = cRMUserID;
	}
	public String getOldExpirationDate() {
		return OldExpirationDate;
	}
	public void setOldExpirationDate(String oldExpirationDate) {
		OldExpirationDate = oldExpirationDate;
	}
	public String getSplitCode() {
		return SplitCode;
	}
	public void setSplitCode(String splitCode) {
		SplitCode = splitCode;
	}
	public String getRechargeAmount() {
		return RechargeAmount;
	}
	public void setRechargeAmount(String rechargeAmount) {
		RechargeAmount = rechargeAmount;
	}
	public String getFuture_String_2() {
		return Future_String_2;
	}
	public void setFuture_String_2(String future_String_2) {
		Future_String_2 = future_String_2;
	}
	public String getFuture_String_3() {
		return Future_String_3;
	}
	public void setFuture_String_3(String future_String_3) {
		Future_String_3 = future_String_3;
	}
	public String getIFRS_ALLOWANCE_INFO() {
		return IFRS_ALLOWANCE_INFO;
	}
	public void setIFRS_ALLOWANCE_INFO(String iFRS_ALLOWANCE_INFO) {
		IFRS_ALLOWANCE_INFO = iFRS_ALLOWANCE_INFO;
	}
	public String getIFRS_IND() {
		return IFRS_IND;
	}
	public void setIFRS_IND(String iFRS_IND) {
		IFRS_IND = iFRS_IND;
	}

	
}
