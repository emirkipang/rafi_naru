package rafi_naru.qsr.model;

public class Upcc {
	private String TriggerType;//0
	private String Time;//1
	private String SubscriberIdentifier;//2
	private String IMSI;//3
	private String MSISDN;//4
	private String IMEI;//5
	private String PaidType;//6
	private String Category;//7
	private String HomeServiceZone;//8
	private String VisitServiceZone;//9
	private String CGI;//10
	private String SAI;//11
	private String RAI;//12
	private String SGSNAddress;//13
	private String MCCMNC;//14
	private String RoamingStatus;//15
	private String RoamingRegion;//16
	private String AccessType;//17
	private String IPCanType;//18
	private String UEIP;//19
	private String APN;//20
	private String DownloadBandwidth;//21
	private String UploadBandwidth;//22
	private String ServicePackageName;//23
	private String ServiceName;//24
	private String RuleName;//25
	private String QuotaName;//26
	private String QuotaStatus;//27
	private String QuotaConsumption;//28
	private String QuotaBalance;//29
	private String QuotaRecharge;//30
	private String QuotaUsage;//31
	private String QuotaNextResetTime;//32
	private String AccountName;//33
	private String AccountStatus;//34
	private String AccountPrivilege;//35
	private String PersonalValue;//36
	private String AccountBalance;//37
	private String AccountConsumption;//38
	private String AccountUsage;//39
	private String PCRFIPAddress;//40
	private String AccountNextResetTime;//41
	private String UEIPv6;//42
	private String ANGWAddress;//43
	private String AccessNodeStatus;//44
	private String TAI;//45
	private String ECGI;//46
	private String UnderControl;//47
	private String OldQuotaStatus;//48
	private String OldQuotaConsumption;//49
	private String OldQuotaBalance;//50
	private String QuotaResetTime;//51
	private String OldAccountStatus;//52
	private String OldAccountPrivilege;//53
	private String OldAccountBalance;//54
	private String OldAccountConsumption;//55
	private String AccountResetTime;//56
	private String QuotaLastResetTime;//57
	private String RoamingRegion2;//58
	private String RoamingRegion3;//59
	private String RoamingRegion4;//60
	private String RoamingRegion5;//61
	private String RoamingRegion6;//62
	private String RoamingRegion7;//63
	private String RoamingRegion8;//64
	private String RoamingRegion9;//65
	private String RoamingRegion10;//66
	private String QuotaValueOrStatus;//67
	private String VisitServiceZone2;//68
	private String VisitServiceZone3;//69
	private String VisitServiceZone4;//70
	private String VisitServiceZone5;//71
	private String AccumulationValue;//72
	private String AccumulationBalance;//73
	private String AccumulationConsumption;//74
	private String AccumulationStartTime;//75
	private String AccumulationEndTime;//76
	private String AccumulationExpireFlag;//77
	private String OldAccumulationValue;//78
	private String OldAccumulationBalance;//79
	private String OldAccumulationConsumption;//80
	private String OldAccumulationStartTime;//81
	private String OldAccumulationEndTime;//82
	private String ActivationTimeValue;//83
	private String ActivationStartTime;//84
	private String ActivationEndTime;//85
	private String RestTimeValue;//86
	private String PLMNIdentify;//87
	private String TimeZone;//88
	private String QuotaValue;//89
	private String ServiceStartDateTime;//90
	private String ServiceEndDateTime;//91
	private String ServiceDescription;//92
	private String ServiceCustomerAttribute;//93
	private String VisitServiceZone6;//94
	private String VisitServiceZone7;//95
	private String VisitServiceZone8;//96
	private String VisitServiceZone9;//97
	private String VisitServiceZone10;//98
	private String SubscribedDateTime;//99
	private String RARCause;//100
	private String TransinSubscriberID;//101
	private String TransinQuotaName;//102
	private String TransferQuotaValue;//103
	private String TransferQuotaStartTime;//104
	private String TransferQuotaEndTime;//105
	private String NotificationIndication;//106
	private String TransferQuotaBalance;//107
	private String TransferQuotaConsumption;//108
	private String TransferTimeStamp;//109
	private String OldActivationStartTime;//110
	private String OldActivationEndTime;//111
	private String OldRestTimeValue;//112
	private String Trans_inServiceName;//113
	private String Trans_inServiceCustomerAttribute;//114
	private String BillingCycleDate;//115
	private String SessionId;//116
	private String OriginHost;//117
	private String OriginRealm;//118
	private String DestinationHost;//119
	private String DestinationRealm;//120
	private String RxIPV4;//121
	private String RxIPV6;//122
	private String LastAccumulateValue;//123
	private String CurrentCumulateTimes;//124
	private String RxMediaType;//125
	private String RxSpecificAction;//126
	private String SyPolicyCounterIdentifier;//127
	private String SyPolicyCounterStatus;//128
	private String SyPendingPolicyCounterstatus1;//129
	private String SyPendingPolicyCounterChangeTime1;//130
	private String SyPendingPolicyCounterstatus2;//131
	private String SyPendingPolicyCounterChangeTime2;//132
	private String SyPendingPolicyCounterstatus3;//133
	private String SyPendingPolicyCounterChangeTime3;//134
	private String SyResultCode;//135
	private String QCI;//136
	private String ClientlessOptimizationRule;//137
	private String ContentFilteringRule;//138
	private String FUP;//139
	private String HTTPEnrichmentRule;//140
	private String BMIIMEI;//141
	private String BMIIMSI;//142
	private String OperatorID;//143
	private String BMIRoamingStatus;//144
	private String ServiceExtendedAttribute3;//145
	private String QuotaExtendedAttribute;//146
	private String Transfer;//147
	private String VisitServiceZone11;//148
	private String VisitServiceZone12;//149
	private String VisitServiceZone13;//150
	private String VisitServiceZone14;//151
	private String VisitServiceZone15;//152
	private String VisitServiceZone16;//153
	private String VisitServiceZone17;//154
	private String VisitServiceZone18;//155
	private String VisitServiceZone19;//156
	private String VisitServiceZone20;//157
	private String ActualQuotaUsage;//158
	private String RateDiscount;//159
	private String ActualAccountUsage;//160
	private String usrStatus;//161
	private String ServiceUsageState;//162
	private String Reserved;//163
	private String Reserved1;//164
	private String Reserved2;//165
	private String ServiceExtendedAttribute1;//166
	private String ServiceExtendedAttribute2;//167
	private String NetLocAccessSupport;//168
	private String TransactionId;//169
	private String QuotaSequenceId;//170
	private String OldQuotaValue;//171
	private String QuotaExpiredTime;//172
	private String OldQuotaExpiredTime;//173
	private String OldQuotaSequenceId;//174
	private String IfrsParam;//175
	
	private String date; //-1
	private String lacci_or_eci; //-2
	
	
	
	public Upcc(String date, String lacci_or_eci, String AccessType, String quotaUsage, String msisdn) {
		
		this.date = date;
		this.lacci_or_eci = lacci_or_eci;
		this.AccessType = AccessType;
		this.QuotaUsage = quotaUsage;
		this.MSISDN = msisdn;
	}

	
	public Upcc() {
		super();
	}
	public String getTriggerType() {
		return TriggerType;
	}
	public void setTriggerType(String triggerType) {
		TriggerType = triggerType;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getSubscriberIdentifier() {
		return SubscriberIdentifier;
	}
	public void setSubscriberIdentifier(String subscriberIdentifier) {
		SubscriberIdentifier = subscriberIdentifier;
	}
	public String getIMSI() {
		return IMSI;
	}
	public void setIMSI(String iMSI) {
		IMSI = iMSI;
	}
	public String getMSISDN() {
		return MSISDN;
	}
	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
	}
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getPaidType() {
		return PaidType;
	}
	public void setPaidType(String paidType) {
		PaidType = paidType;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getHomeServiceZone() {
		return HomeServiceZone;
	}
	public void setHomeServiceZone(String homeServiceZone) {
		HomeServiceZone = homeServiceZone;
	}
	public String getVisitServiceZone() {
		return VisitServiceZone;
	}
	public void setVisitServiceZone(String visitServiceZone) {
		VisitServiceZone = visitServiceZone;
	}
	public String getCGI() {
		return CGI;
	}
	public void setCGI(String cGI) {
		CGI = cGI;
	}
	public String getSAI() {
		return SAI;
	}
	public void setSAI(String sAI) {
		SAI = sAI;
	}
	public String getRAI() {
		return RAI;
	}
	public void setRAI(String rAI) {
		RAI = rAI;
	}
	public String getSGSNAddress() {
		return SGSNAddress;
	}
	public void setSGSNAddress(String sGSNAddress) {
		SGSNAddress = sGSNAddress;
	}
	public String getMCCMNC() {
		return MCCMNC;
	}
	public void setMCCMNC(String mCCMNC) {
		MCCMNC = mCCMNC;
	}
	public String getRoamingStatus() {
		return RoamingStatus;
	}
	public void setRoamingStatus(String roamingStatus) {
		RoamingStatus = roamingStatus;
	}
	public String getRoamingRegion() {
		return RoamingRegion;
	}
	public void setRoamingRegion(String roamingRegion) {
		RoamingRegion = roamingRegion;
	}
	public String getAccessType() {
		return AccessType;
	}
	public void setAccessType(String accessType) {
		AccessType = accessType;
	}
	public String getIPCanType() {
		return IPCanType;
	}
	public void setIPCanType(String iPCanType) {
		IPCanType = iPCanType;
	}
	public String getUEIP() {
		return UEIP;
	}
	public void setUEIP(String uEIP) {
		UEIP = uEIP;
	}
	public String getAPN() {
		return APN;
	}
	public void setAPN(String aPN) {
		APN = aPN;
	}
	public String getDownloadBandwidth() {
		return DownloadBandwidth;
	}
	public void setDownloadBandwidth(String downloadBandwidth) {
		DownloadBandwidth = downloadBandwidth;
	}
	public String getUploadBandwidth() {
		return UploadBandwidth;
	}
	public void setUploadBandwidth(String uploadBandwidth) {
		UploadBandwidth = uploadBandwidth;
	}
	public String getServicePackageName() {
		return ServicePackageName;
	}
	public void setServicePackageName(String servicePackageName) {
		ServicePackageName = servicePackageName;
	}
	public String getServiceName() {
		return ServiceName;
	}
	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}
	public String getRuleName() {
		return RuleName;
	}
	public void setRuleName(String ruleName) {
		RuleName = ruleName;
	}
	public String getQuotaName() {
		return QuotaName;
	}
	public void setQuotaName(String quotaName) {
		QuotaName = quotaName;
	}
	public String getQuotaStatus() {
		return QuotaStatus;
	}
	public void setQuotaStatus(String quotaStatus) {
		QuotaStatus = quotaStatus;
	}
	public String getQuotaConsumption() {
		return QuotaConsumption;
	}
	public void setQuotaConsumption(String quotaConsumption) {
		QuotaConsumption = quotaConsumption;
	}
	public String getQuotaBalance() {
		return QuotaBalance;
	}
	public void setQuotaBalance(String quotaBalance) {
		QuotaBalance = quotaBalance;
	}
	public String getQuotaRecharge() {
		return QuotaRecharge;
	}
	public void setQuotaRecharge(String quotaRecharge) {
		QuotaRecharge = quotaRecharge;
	}
	public String getQuotaUsage() {
		return QuotaUsage;
	}
	public void setQuotaUsage(String quotaUsage) {
		QuotaUsage = quotaUsage;
	}
	public String getQuotaNextResetTime() {
		return QuotaNextResetTime;
	}
	public void setQuotaNextResetTime(String quotaNextResetTime) {
		QuotaNextResetTime = quotaNextResetTime;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public String getAccountStatus() {
		return AccountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		AccountStatus = accountStatus;
	}
	public String getAccountPrivilege() {
		return AccountPrivilege;
	}
	public void setAccountPrivilege(String accountPrivilege) {
		AccountPrivilege = accountPrivilege;
	}
	public String getPersonalValue() {
		return PersonalValue;
	}
	public void setPersonalValue(String personalValue) {
		PersonalValue = personalValue;
	}
	public String getAccountBalance() {
		return AccountBalance;
	}
	public void setAccountBalance(String accountBalance) {
		AccountBalance = accountBalance;
	}
	public String getAccountConsumption() {
		return AccountConsumption;
	}
	public void setAccountConsumption(String accountConsumption) {
		AccountConsumption = accountConsumption;
	}
	public String getAccountUsage() {
		return AccountUsage;
	}
	public void setAccountUsage(String accountUsage) {
		AccountUsage = accountUsage;
	}
	public String getPCRFIPAddress() {
		return PCRFIPAddress;
	}
	public void setPCRFIPAddress(String pCRFIPAddress) {
		PCRFIPAddress = pCRFIPAddress;
	}
	public String getAccountNextResetTime() {
		return AccountNextResetTime;
	}
	public void setAccountNextResetTime(String accountNextResetTime) {
		AccountNextResetTime = accountNextResetTime;
	}
	public String getUEIPv6() {
		return UEIPv6;
	}
	public void setUEIPv6(String uEIPv6) {
		UEIPv6 = uEIPv6;
	}
	public String getANGWAddress() {
		return ANGWAddress;
	}
	public void setANGWAddress(String aNGWAddress) {
		ANGWAddress = aNGWAddress;
	}
	public String getAccessNodeStatus() {
		return AccessNodeStatus;
	}
	public void setAccessNodeStatus(String accessNodeStatus) {
		AccessNodeStatus = accessNodeStatus;
	}
	public String getTAI() {
		return TAI;
	}
	public void setTAI(String tAI) {
		TAI = tAI;
	}
	public String getECGI() {
		return ECGI;
	}
	public void setECGI(String eCGI) {
		ECGI = eCGI;
	}
	public String getUnderControl() {
		return UnderControl;
	}
	public void setUnderControl(String underControl) {
		UnderControl = underControl;
	}
	public String getOldQuotaStatus() {
		return OldQuotaStatus;
	}
	public void setOldQuotaStatus(String oldQuotaStatus) {
		OldQuotaStatus = oldQuotaStatus;
	}
	public String getOldQuotaConsumption() {
		return OldQuotaConsumption;
	}
	public void setOldQuotaConsumption(String oldQuotaConsumption) {
		OldQuotaConsumption = oldQuotaConsumption;
	}
	public String getOldQuotaBalance() {
		return OldQuotaBalance;
	}
	public void setOldQuotaBalance(String oldQuotaBalance) {
		OldQuotaBalance = oldQuotaBalance;
	}
	public String getQuotaResetTime() {
		return QuotaResetTime;
	}
	public void setQuotaResetTime(String quotaResetTime) {
		QuotaResetTime = quotaResetTime;
	}
	public String getOldAccountStatus() {
		return OldAccountStatus;
	}
	public void setOldAccountStatus(String oldAccountStatus) {
		OldAccountStatus = oldAccountStatus;
	}
	public String getOldAccountPrivilege() {
		return OldAccountPrivilege;
	}
	public void setOldAccountPrivilege(String oldAccountPrivilege) {
		OldAccountPrivilege = oldAccountPrivilege;
	}
	public String getOldAccountBalance() {
		return OldAccountBalance;
	}
	public void setOldAccountBalance(String oldAccountBalance) {
		OldAccountBalance = oldAccountBalance;
	}
	public String getOldAccountConsumption() {
		return OldAccountConsumption;
	}
	public void setOldAccountConsumption(String oldAccountConsumption) {
		OldAccountConsumption = oldAccountConsumption;
	}
	public String getAccountResetTime() {
		return AccountResetTime;
	}
	public void setAccountResetTime(String accountResetTime) {
		AccountResetTime = accountResetTime;
	}
	public String getQuotaLastResetTime() {
		return QuotaLastResetTime;
	}
	public void setQuotaLastResetTime(String quotaLastResetTime) {
		QuotaLastResetTime = quotaLastResetTime;
	}
	public String getRoamingRegion2() {
		return RoamingRegion2;
	}
	public void setRoamingRegion2(String roamingRegion2) {
		RoamingRegion2 = roamingRegion2;
	}
	public String getRoamingRegion3() {
		return RoamingRegion3;
	}
	public void setRoamingRegion3(String roamingRegion3) {
		RoamingRegion3 = roamingRegion3;
	}
	public String getRoamingRegion4() {
		return RoamingRegion4;
	}
	public void setRoamingRegion4(String roamingRegion4) {
		RoamingRegion4 = roamingRegion4;
	}
	public String getRoamingRegion5() {
		return RoamingRegion5;
	}
	public void setRoamingRegion5(String roamingRegion5) {
		RoamingRegion5 = roamingRegion5;
	}
	public String getRoamingRegion6() {
		return RoamingRegion6;
	}
	public void setRoamingRegion6(String roamingRegion6) {
		RoamingRegion6 = roamingRegion6;
	}
	public String getRoamingRegion7() {
		return RoamingRegion7;
	}
	public void setRoamingRegion7(String roamingRegion7) {
		RoamingRegion7 = roamingRegion7;
	}
	public String getRoamingRegion8() {
		return RoamingRegion8;
	}
	public void setRoamingRegion8(String roamingRegion8) {
		RoamingRegion8 = roamingRegion8;
	}
	public String getRoamingRegion9() {
		return RoamingRegion9;
	}
	public void setRoamingRegion9(String roamingRegion9) {
		RoamingRegion9 = roamingRegion9;
	}
	public String getRoamingRegion10() {
		return RoamingRegion10;
	}
	public void setRoamingRegion10(String roamingRegion10) {
		RoamingRegion10 = roamingRegion10;
	}
	public String getQuotaValueOrStatus() {
		return QuotaValueOrStatus;
	}
	public void setQuotaValueOrStatus(String quotaValueOrStatus) {
		QuotaValueOrStatus = quotaValueOrStatus;
	}
	public String getVisitServiceZone2() {
		return VisitServiceZone2;
	}
	public void setVisitServiceZone2(String visitServiceZone2) {
		VisitServiceZone2 = visitServiceZone2;
	}
	public String getVisitServiceZone3() {
		return VisitServiceZone3;
	}
	public void setVisitServiceZone3(String visitServiceZone3) {
		VisitServiceZone3 = visitServiceZone3;
	}
	public String getVisitServiceZone4() {
		return VisitServiceZone4;
	}
	public void setVisitServiceZone4(String visitServiceZone4) {
		VisitServiceZone4 = visitServiceZone4;
	}
	public String getVisitServiceZone5() {
		return VisitServiceZone5;
	}
	public void setVisitServiceZone5(String visitServiceZone5) {
		VisitServiceZone5 = visitServiceZone5;
	}
	public String getAccumulationValue() {
		return AccumulationValue;
	}
	public void setAccumulationValue(String accumulationValue) {
		AccumulationValue = accumulationValue;
	}
	public String getAccumulationBalance() {
		return AccumulationBalance;
	}
	public void setAccumulationBalance(String accumulationBalance) {
		AccumulationBalance = accumulationBalance;
	}
	public String getAccumulationConsumption() {
		return AccumulationConsumption;
	}
	public void setAccumulationConsumption(String accumulationConsumption) {
		AccumulationConsumption = accumulationConsumption;
	}
	public String getAccumulationStartTime() {
		return AccumulationStartTime;
	}
	public void setAccumulationStartTime(String accumulationStartTime) {
		AccumulationStartTime = accumulationStartTime;
	}
	public String getAccumulationEndTime() {
		return AccumulationEndTime;
	}
	public void setAccumulationEndTime(String accumulationEndTime) {
		AccumulationEndTime = accumulationEndTime;
	}
	public String getAccumulationExpireFlag() {
		return AccumulationExpireFlag;
	}
	public void setAccumulationExpireFlag(String accumulationExpireFlag) {
		AccumulationExpireFlag = accumulationExpireFlag;
	}
	public String getOldAccumulationValue() {
		return OldAccumulationValue;
	}
	public void setOldAccumulationValue(String oldAccumulationValue) {
		OldAccumulationValue = oldAccumulationValue;
	}
	public String getOldAccumulationBalance() {
		return OldAccumulationBalance;
	}
	public void setOldAccumulationBalance(String oldAccumulationBalance) {
		OldAccumulationBalance = oldAccumulationBalance;
	}
	public String getOldAccumulationConsumption() {
		return OldAccumulationConsumption;
	}
	public void setOldAccumulationConsumption(String oldAccumulationConsumption) {
		OldAccumulationConsumption = oldAccumulationConsumption;
	}
	public String getOldAccumulationStartTime() {
		return OldAccumulationStartTime;
	}
	public void setOldAccumulationStartTime(String oldAccumulationStartTime) {
		OldAccumulationStartTime = oldAccumulationStartTime;
	}
	public String getOldAccumulationEndTime() {
		return OldAccumulationEndTime;
	}
	public void setOldAccumulationEndTime(String oldAccumulationEndTime) {
		OldAccumulationEndTime = oldAccumulationEndTime;
	}
	public String getActivationTimeValue() {
		return ActivationTimeValue;
	}
	public void setActivationTimeValue(String activationTimeValue) {
		ActivationTimeValue = activationTimeValue;
	}
	public String getActivationStartTime() {
		return ActivationStartTime;
	}
	public void setActivationStartTime(String activationStartTime) {
		ActivationStartTime = activationStartTime;
	}
	public String getActivationEndTime() {
		return ActivationEndTime;
	}
	public void setActivationEndTime(String activationEndTime) {
		ActivationEndTime = activationEndTime;
	}
	public String getRestTimeValue() {
		return RestTimeValue;
	}
	public void setRestTimeValue(String restTimeValue) {
		RestTimeValue = restTimeValue;
	}
	public String getPLMNIdentify() {
		return PLMNIdentify;
	}
	public void setPLMNIdentify(String pLMNIdentify) {
		PLMNIdentify = pLMNIdentify;
	}
	public String getTimeZone() {
		return TimeZone;
	}
	public void setTimeZone(String timeZone) {
		TimeZone = timeZone;
	}
	public String getQuotaValue() {
		return QuotaValue;
	}
	public void setQuotaValue(String quotaValue) {
		QuotaValue = quotaValue;
	}
	public String getServiceStartDateTime() {
		return ServiceStartDateTime;
	}
	public void setServiceStartDateTime(String serviceStartDateTime) {
		ServiceStartDateTime = serviceStartDateTime;
	}
	public String getServiceEndDateTime() {
		return ServiceEndDateTime;
	}
	public void setServiceEndDateTime(String serviceEndDateTime) {
		ServiceEndDateTime = serviceEndDateTime;
	}
	public String getServiceDescription() {
		return ServiceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		ServiceDescription = serviceDescription;
	}
	public String getServiceCustomerAttribute() {
		return ServiceCustomerAttribute;
	}
	public void setServiceCustomerAttribute(String serviceCustomerAttribute) {
		ServiceCustomerAttribute = serviceCustomerAttribute;
	}
	public String getVisitServiceZone6() {
		return VisitServiceZone6;
	}
	public void setVisitServiceZone6(String visitServiceZone6) {
		VisitServiceZone6 = visitServiceZone6;
	}
	public String getVisitServiceZone7() {
		return VisitServiceZone7;
	}
	public void setVisitServiceZone7(String visitServiceZone7) {
		VisitServiceZone7 = visitServiceZone7;
	}
	public String getVisitServiceZone8() {
		return VisitServiceZone8;
	}
	public void setVisitServiceZone8(String visitServiceZone8) {
		VisitServiceZone8 = visitServiceZone8;
	}
	public String getVisitServiceZone9() {
		return VisitServiceZone9;
	}
	public void setVisitServiceZone9(String visitServiceZone9) {
		VisitServiceZone9 = visitServiceZone9;
	}
	public String getVisitServiceZone10() {
		return VisitServiceZone10;
	}
	public void setVisitServiceZone10(String visitServiceZone10) {
		VisitServiceZone10 = visitServiceZone10;
	}
	public String getSubscribedDateTime() {
		return SubscribedDateTime;
	}
	public void setSubscribedDateTime(String subscribedDateTime) {
		SubscribedDateTime = subscribedDateTime;
	}
	public String getRARCause() {
		return RARCause;
	}
	public void setRARCause(String rARCause) {
		RARCause = rARCause;
	}
	public String getTransinSubscriberID() {
		return TransinSubscriberID;
	}
	public void setTransinSubscriberID(String transinSubscriberID) {
		TransinSubscriberID = transinSubscriberID;
	}
	public String getTransinQuotaName() {
		return TransinQuotaName;
	}
	public void setTransinQuotaName(String transinQuotaName) {
		TransinQuotaName = transinQuotaName;
	}
	public String getTransferQuotaValue() {
		return TransferQuotaValue;
	}
	public void setTransferQuotaValue(String transferQuotaValue) {
		TransferQuotaValue = transferQuotaValue;
	}
	public String getTransferQuotaStartTime() {
		return TransferQuotaStartTime;
	}
	public void setTransferQuotaStartTime(String transferQuotaStartTime) {
		TransferQuotaStartTime = transferQuotaStartTime;
	}
	public String getTransferQuotaEndTime() {
		return TransferQuotaEndTime;
	}
	public void setTransferQuotaEndTime(String transferQuotaEndTime) {
		TransferQuotaEndTime = transferQuotaEndTime;
	}
	public String getNotificationIndication() {
		return NotificationIndication;
	}
	public void setNotificationIndication(String notificationIndication) {
		NotificationIndication = notificationIndication;
	}
	public String getTransferQuotaBalance() {
		return TransferQuotaBalance;
	}
	public void setTransferQuotaBalance(String transferQuotaBalance) {
		TransferQuotaBalance = transferQuotaBalance;
	}
	public String getTransferQuotaConsumption() {
		return TransferQuotaConsumption;
	}
	public void setTransferQuotaConsumption(String transferQuotaConsumption) {
		TransferQuotaConsumption = transferQuotaConsumption;
	}
	public String getTransferTimeStamp() {
		return TransferTimeStamp;
	}
	public void setTransferTimeStamp(String transferTimeStamp) {
		TransferTimeStamp = transferTimeStamp;
	}
	public String getOldActivationStartTime() {
		return OldActivationStartTime;
	}
	public void setOldActivationStartTime(String oldActivationStartTime) {
		OldActivationStartTime = oldActivationStartTime;
	}
	public String getOldActivationEndTime() {
		return OldActivationEndTime;
	}
	public void setOldActivationEndTime(String oldActivationEndTime) {
		OldActivationEndTime = oldActivationEndTime;
	}
	public String getOldRestTimeValue() {
		return OldRestTimeValue;
	}
	public void setOldRestTimeValue(String oldRestTimeValue) {
		OldRestTimeValue = oldRestTimeValue;
	}
	public String getTrans_inServiceName() {
		return Trans_inServiceName;
	}
	public void setTrans_inServiceName(String trans_inServiceName) {
		Trans_inServiceName = trans_inServiceName;
	}
	public String getTrans_inServiceCustomerAttribute() {
		return Trans_inServiceCustomerAttribute;
	}
	public void setTrans_inServiceCustomerAttribute(String trans_inServiceCustomerAttribute) {
		Trans_inServiceCustomerAttribute = trans_inServiceCustomerAttribute;
	}
	public String getBillingCycleDate() {
		return BillingCycleDate;
	}
	public void setBillingCycleDate(String billingCycleDate) {
		BillingCycleDate = billingCycleDate;
	}
	public String getSessionId() {
		return SessionId;
	}
	public void setSessionId(String sessionId) {
		SessionId = sessionId;
	}
	public String getOriginHost() {
		return OriginHost;
	}
	public void setOriginHost(String originHost) {
		OriginHost = originHost;
	}
	public String getOriginRealm() {
		return OriginRealm;
	}
	public void setOriginRealm(String originRealm) {
		OriginRealm = originRealm;
	}
	public String getDestinationHost() {
		return DestinationHost;
	}
	public void setDestinationHost(String destinationHost) {
		DestinationHost = destinationHost;
	}
	public String getDestinationRealm() {
		return DestinationRealm;
	}
	public void setDestinationRealm(String destinationRealm) {
		DestinationRealm = destinationRealm;
	}
	public String getRxIPV4() {
		return RxIPV4;
	}
	public void setRxIPV4(String rxIPV4) {
		RxIPV4 = rxIPV4;
	}
	public String getRxIPV6() {
		return RxIPV6;
	}
	public void setRxIPV6(String rxIPV6) {
		RxIPV6 = rxIPV6;
	}
	public String getLastAccumulateValue() {
		return LastAccumulateValue;
	}
	public void setLastAccumulateValue(String lastAccumulateValue) {
		LastAccumulateValue = lastAccumulateValue;
	}
	public String getCurrentCumulateTimes() {
		return CurrentCumulateTimes;
	}
	public void setCurrentCumulateTimes(String currentCumulateTimes) {
		CurrentCumulateTimes = currentCumulateTimes;
	}
	public String getRxMediaType() {
		return RxMediaType;
	}
	public void setRxMediaType(String rxMediaType) {
		RxMediaType = rxMediaType;
	}
	public String getRxSpecificAction() {
		return RxSpecificAction;
	}
	public void setRxSpecificAction(String rxSpecificAction) {
		RxSpecificAction = rxSpecificAction;
	}
	public String getSyPolicyCounterIdentifier() {
		return SyPolicyCounterIdentifier;
	}
	public void setSyPolicyCounterIdentifier(String syPolicyCounterIdentifier) {
		SyPolicyCounterIdentifier = syPolicyCounterIdentifier;
	}
	public String getSyPolicyCounterStatus() {
		return SyPolicyCounterStatus;
	}
	public void setSyPolicyCounterStatus(String syPolicyCounterStatus) {
		SyPolicyCounterStatus = syPolicyCounterStatus;
	}
	public String getSyPendingPolicyCounterstatus1() {
		return SyPendingPolicyCounterstatus1;
	}
	public void setSyPendingPolicyCounterstatus1(String syPendingPolicyCounterstatus1) {
		SyPendingPolicyCounterstatus1 = syPendingPolicyCounterstatus1;
	}
	public String getSyPendingPolicyCounterChangeTime1() {
		return SyPendingPolicyCounterChangeTime1;
	}
	public void setSyPendingPolicyCounterChangeTime1(String syPendingPolicyCounterChangeTime1) {
		SyPendingPolicyCounterChangeTime1 = syPendingPolicyCounterChangeTime1;
	}
	public String getSyPendingPolicyCounterstatus2() {
		return SyPendingPolicyCounterstatus2;
	}
	public void setSyPendingPolicyCounterstatus2(String syPendingPolicyCounterstatus2) {
		SyPendingPolicyCounterstatus2 = syPendingPolicyCounterstatus2;
	}
	public String getSyPendingPolicyCounterChangeTime2() {
		return SyPendingPolicyCounterChangeTime2;
	}
	public void setSyPendingPolicyCounterChangeTime2(String syPendingPolicyCounterChangeTime2) {
		SyPendingPolicyCounterChangeTime2 = syPendingPolicyCounterChangeTime2;
	}
	public String getSyPendingPolicyCounterstatus3() {
		return SyPendingPolicyCounterstatus3;
	}
	public void setSyPendingPolicyCounterstatus3(String syPendingPolicyCounterstatus3) {
		SyPendingPolicyCounterstatus3 = syPendingPolicyCounterstatus3;
	}
	public String getSyPendingPolicyCounterChangeTime3() {
		return SyPendingPolicyCounterChangeTime3;
	}
	public void setSyPendingPolicyCounterChangeTime3(String syPendingPolicyCounterChangeTime3) {
		SyPendingPolicyCounterChangeTime3 = syPendingPolicyCounterChangeTime3;
	}
	public String getSyResultCode() {
		return SyResultCode;
	}
	public void setSyResultCode(String syResultCode) {
		SyResultCode = syResultCode;
	}
	public String getQCI() {
		return QCI;
	}
	public void setQCI(String qCI) {
		QCI = qCI;
	}
	public String getClientlessOptimizationRule() {
		return ClientlessOptimizationRule;
	}
	public void setClientlessOptimizationRule(String clientlessOptimizationRule) {
		ClientlessOptimizationRule = clientlessOptimizationRule;
	}
	public String getContentFilteringRule() {
		return ContentFilteringRule;
	}
	public void setContentFilteringRule(String contentFilteringRule) {
		ContentFilteringRule = contentFilteringRule;
	}
	public String getFUP() {
		return FUP;
	}
	public void setFUP(String fUP) {
		FUP = fUP;
	}
	public String getHTTPEnrichmentRule() {
		return HTTPEnrichmentRule;
	}
	public void setHTTPEnrichmentRule(String hTTPEnrichmentRule) {
		HTTPEnrichmentRule = hTTPEnrichmentRule;
	}
	public String getBMIIMEI() {
		return BMIIMEI;
	}
	public void setBMIIMEI(String bMIIMEI) {
		BMIIMEI = bMIIMEI;
	}
	public String getBMIIMSI() {
		return BMIIMSI;
	}
	public void setBMIIMSI(String bMIIMSI) {
		BMIIMSI = bMIIMSI;
	}
	public String getOperatorID() {
		return OperatorID;
	}
	public void setOperatorID(String operatorID) {
		OperatorID = operatorID;
	}
	public String getBMIRoamingStatus() {
		return BMIRoamingStatus;
	}
	public void setBMIRoamingStatus(String bMIRoamingStatus) {
		BMIRoamingStatus = bMIRoamingStatus;
	}
	public String getServiceExtendedAttribute3() {
		return ServiceExtendedAttribute3;
	}
	public void setServiceExtendedAttribute3(String serviceExtendedAttribute3) {
		ServiceExtendedAttribute3 = serviceExtendedAttribute3;
	}
	public String getQuotaExtendedAttribute() {
		return QuotaExtendedAttribute;
	}
	public void setQuotaExtendedAttribute(String quotaExtendedAttribute) {
		QuotaExtendedAttribute = quotaExtendedAttribute;
	}
	public String getTransfer() {
		return Transfer;
	}
	public void setTransfer(String transfer) {
		Transfer = transfer;
	}
	public String getVisitServiceZone11() {
		return VisitServiceZone11;
	}
	public void setVisitServiceZone11(String visitServiceZone11) {
		VisitServiceZone11 = visitServiceZone11;
	}
	public String getVisitServiceZone12() {
		return VisitServiceZone12;
	}
	public void setVisitServiceZone12(String visitServiceZone12) {
		VisitServiceZone12 = visitServiceZone12;
	}
	public String getVisitServiceZone13() {
		return VisitServiceZone13;
	}
	public void setVisitServiceZone13(String visitServiceZone13) {
		VisitServiceZone13 = visitServiceZone13;
	}
	public String getVisitServiceZone14() {
		return VisitServiceZone14;
	}
	public void setVisitServiceZone14(String visitServiceZone14) {
		VisitServiceZone14 = visitServiceZone14;
	}
	public String getVisitServiceZone15() {
		return VisitServiceZone15;
	}
	public void setVisitServiceZone15(String visitServiceZone15) {
		VisitServiceZone15 = visitServiceZone15;
	}
	public String getVisitServiceZone16() {
		return VisitServiceZone16;
	}
	public void setVisitServiceZone16(String visitServiceZone16) {
		VisitServiceZone16 = visitServiceZone16;
	}
	public String getVisitServiceZone17() {
		return VisitServiceZone17;
	}
	public void setVisitServiceZone17(String visitServiceZone17) {
		VisitServiceZone17 = visitServiceZone17;
	}
	public String getVisitServiceZone18() {
		return VisitServiceZone18;
	}
	public void setVisitServiceZone18(String visitServiceZone18) {
		VisitServiceZone18 = visitServiceZone18;
	}
	public String getVisitServiceZone19() {
		return VisitServiceZone19;
	}
	public void setVisitServiceZone19(String visitServiceZone19) {
		VisitServiceZone19 = visitServiceZone19;
	}
	public String getVisitServiceZone20() {
		return VisitServiceZone20;
	}
	public void setVisitServiceZone20(String visitServiceZone20) {
		VisitServiceZone20 = visitServiceZone20;
	}
	public String getActualQuotaUsage() {
		return ActualQuotaUsage;
	}
	public void setActualQuotaUsage(String actualQuotaUsage) {
		ActualQuotaUsage = actualQuotaUsage;
	}
	public String getRateDiscount() {
		return RateDiscount;
	}
	public void setRateDiscount(String rateDiscount) {
		RateDiscount = rateDiscount;
	}
	public String getActualAccountUsage() {
		return ActualAccountUsage;
	}
	public void setActualAccountUsage(String actualAccountUsage) {
		ActualAccountUsage = actualAccountUsage;
	}
	public String getUsrStatus() {
		return usrStatus;
	}
	public void setUsrStatus(String usrStatus) {
		this.usrStatus = usrStatus;
	}
	public String getServiceUsageState() {
		return ServiceUsageState;
	}
	public void setServiceUsageState(String serviceUsageState) {
		ServiceUsageState = serviceUsageState;
	}
	public String getReserved() {
		return Reserved;
	}
	public void setReserved(String reserved) {
		Reserved = reserved;
	}
	public String getReserved1() {
		return Reserved1;
	}
	public void setReserved1(String reserved1) {
		Reserved1 = reserved1;
	}
	public String getReserved2() {
		return Reserved2;
	}
	public void setReserved2(String reserved2) {
		Reserved2 = reserved2;
	}
	public String getServiceExtendedAttribute1() {
		return ServiceExtendedAttribute1;
	}
	public void setServiceExtendedAttribute1(String serviceExtendedAttribute1) {
		ServiceExtendedAttribute1 = serviceExtendedAttribute1;
	}
	public String getServiceExtendedAttribute2() {
		return ServiceExtendedAttribute2;
	}
	public void setServiceExtendedAttribute2(String serviceExtendedAttribute2) {
		ServiceExtendedAttribute2 = serviceExtendedAttribute2;
	}
	public String getNetLocAccessSupport() {
		return NetLocAccessSupport;
	}
	public void setNetLocAccessSupport(String netLocAccessSupport) {
		NetLocAccessSupport = netLocAccessSupport;
	}
	public String getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLacci_or_eci() {
		return lacci_or_eci;
	}

	public void setLacci_or_eci(String lacci_or_eci) {
		this.lacci_or_eci = lacci_or_eci;
	}

	public String getQuotaSequenceId() {
		return QuotaSequenceId;
	}
	public void setQuotaSequenceId(String quotaSequenceId) {
		QuotaSequenceId = quotaSequenceId;
	}
	public String getOldQuotaValue() {
		return OldQuotaValue;
	}
	public void setOldQuotaValue(String oldQuotaValue) {
		OldQuotaValue = oldQuotaValue;
	}
	public String getQuotaExpiredTime() {
		return QuotaExpiredTime;
	}
	public void setQuotaExpiredTime(String quotaExpiredTime) {
		QuotaExpiredTime = quotaExpiredTime;
	}
	public String getOldQuotaExpiredTime() {
		return OldQuotaExpiredTime;
	}
	public void setOldQuotaExpiredTime(String oldQuotaExpiredTime) {
		OldQuotaExpiredTime = oldQuotaExpiredTime;
	}
	public String getOldQuotaSequenceId() {
		return OldQuotaSequenceId;
	}
	public void setOldQuotaSequenceId(String oldQuotaSequenceId) {
		OldQuotaSequenceId = oldQuotaSequenceId;
	}
	public String getIfrsParam() {
		return IfrsParam;
	}
	public void setIfrsParam(String ifrsParam) {
		IfrsParam = ifrsParam;
	}
	
	
	

}
