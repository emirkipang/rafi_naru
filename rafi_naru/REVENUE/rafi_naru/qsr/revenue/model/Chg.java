package rafi_naru.qsr.revenue.model;

public class Chg {
	private String Timestamp;// 0
	private String AParty;// 1
	private String LocationNumberTypeA;// 2
	private String LocationNumberA;// 3
	private String BParty;// 4
	private String LocationNumberTypeB;// 5
	private String LocationNumberB;// 6
	private String NrOfReroutings;// 7
	private String IMSI;// 8
	private String NrOfNetworkReroutings;// 9
	private String RedirectingPartyID;// 10
	private String PreCallDuration;// 11
	private String CallDuration;// 12
	private String ChargingID;// 13
	private String RoamingFlag;// 14
	private String VLRNumber;// 15
	private String CellID;// 16
	private String NegotiatedQoS;// 17
	private String RequestedQoS;// 18
	private String SubscribedQoS;// 19
	private String DialledAPN;// 20
	private String EventType;// 21
	private String providerID;// 22
	private String Currency;// 23
	private String Subscriberstatus;// 24
	private String Forwardingflag;// 25
	private String Firstcallflag;// 26
	private String CAMELRoaming;// 27
	private String Timezone;// 28
	private String AccountBalance;// 29
	private String AccountDelta;// 30
	private String AccountNumber;// 31
	private String AccountOwner;// 32
	private String EventSource;// 33
	private String Guidingresourcetype;// 34
	private String Roundedduration;// 35
	private String Totalvolume;// 36
	private String Roundedtotalvolume;// 37
	private String Eventstartperiod;// 38
	private String Chargeincludingfreeallowance;// 39
	private String Discountamount;// 40
	private String Freetotalvolume;// 41
	private String Freeduration;// 42
	private String Calldirection;// 43
	private String Chargecodedescription;// 44
	private String Specialnumberind;// 45
	private String Bonusinformation;// 46
	private String InternalCause;// 47
	private String BasicCause;// 48
	private String Timeband;// 49
	private String Calltype;// 50
	private String Bonusconsumed;// 51
	private String VAScode;// 52
	private String Servicefilter;// 53
	private String Nationalcallingzone;// 54
	private String Nationalcalledzone;// 55
	private String Internationalcallingzone;// 56
	private String Internationalcalledzone;// 57
	private String Creditindicator;// 58
	private String EventID;// 59
	private String Accesscode;// 60
	private String Countryname;// 61
	private String CPname;// 62
	private String Contentid;// 63
	private String RatingGroup;// 64
	private String BFTIndicator;// 65
	private String Unappliedamount;// 66
	private String PartitionID;// 67
	private String RatedDateTime;// 68
	private String Area;// 69
	private String Costband;// 70
	private String RatingOfferId;// 71
	private String SettlementIndicator;// 72
	private String TapCode;// 73
	private String MCCMNC;// 74
	private String RatingPricingitemID;// 75
	private String FileIdentifier;// 76
	private String RecordNumber;// 77
	private String FutureString1;// 78
	private String FutureString2;// 79
	private String FutureString3;// 80
	// tc
	private String Allowanceconsumedrevenue;// 81
	private String IFRSIndforAllowancerevenue;// 82
	private String IFRSIndforVASevent;// 83
	private String ItemizedBillFee;// 84
	private String ConsumedMonetaryAllowance;// 85
	private String Partialchargeind;// 86

	private String date; // -1
	private String lacci; // -1
	private String revenue; // -1

	public Chg(String date, String lacci, String revenue, String BParty) {
		super();
		this.date = date;
		this.lacci = lacci;
		this.revenue = revenue;
		this.BParty = BParty;
	}

	public Chg() {
		super();
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

	public String getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(String timestamp) {
		Timestamp = timestamp;
	}

	public String getAParty() {
		return AParty;
	}

	public void setAParty(String aParty) {
		AParty = aParty;
	}

	public String getLocationNumberTypeA() {
		return LocationNumberTypeA;
	}

	public void setLocationNumberTypeA(String locationNumberTypeA) {
		LocationNumberTypeA = locationNumberTypeA;
	}

	public String getLocationNumberA() {
		return LocationNumberA;
	}

	public void setLocationNumberA(String locationNumberA) {
		LocationNumberA = locationNumberA;
	}

	public String getBParty() {
		return BParty;
	}

	public void setBParty(String bParty) {
		BParty = bParty;
	}

	public String getLocationNumberTypeB() {
		return LocationNumberTypeB;
	}

	public void setLocationNumberTypeB(String locationNumberTypeB) {
		LocationNumberTypeB = locationNumberTypeB;
	}

	public String getLocationNumberB() {
		return LocationNumberB;
	}

	public void setLocationNumberB(String locationNumberB) {
		LocationNumberB = locationNumberB;
	}

	public String getNrOfReroutings() {
		return NrOfReroutings;
	}

	public void setNrOfReroutings(String nrOfReroutings) {
		NrOfReroutings = nrOfReroutings;
	}

	public String getIMSI() {
		return IMSI;
	}

	public void setIMSI(String iMSI) {
		IMSI = iMSI;
	}

	public String getNrOfNetworkReroutings() {
		return NrOfNetworkReroutings;
	}

	public void setNrOfNetworkReroutings(String nrOfNetworkReroutings) {
		NrOfNetworkReroutings = nrOfNetworkReroutings;
	}

	public String getRedirectingPartyID() {
		return RedirectingPartyID;
	}

	public void setRedirectingPartyID(String redirectingPartyID) {
		RedirectingPartyID = redirectingPartyID;
	}

	public String getPreCallDuration() {
		return PreCallDuration;
	}

	public void setPreCallDuration(String preCallDuration) {
		PreCallDuration = preCallDuration;
	}

	public String getCallDuration() {
		return CallDuration;
	}

	public void setCallDuration(String callDuration) {
		CallDuration = callDuration;
	}

	public String getChargingID() {
		return ChargingID;
	}

	public void setChargingID(String chargingID) {
		ChargingID = chargingID;
	}

	public String getRoamingFlag() {
		return RoamingFlag;
	}

	public void setRoamingFlag(String roamingFlag) {
		RoamingFlag = roamingFlag;
	}

	public String getVLRNumber() {
		return VLRNumber;
	}

	public void setVLRNumber(String vLRNumber) {
		VLRNumber = vLRNumber;
	}

	public String getCellID() {
		return CellID;
	}

	public void setCellID(String cellID) {
		CellID = cellID;
	}

	public String getNegotiatedQoS() {
		return NegotiatedQoS;
	}

	public void setNegotiatedQoS(String negotiatedQoS) {
		NegotiatedQoS = negotiatedQoS;
	}

	public String getRequestedQoS() {
		return RequestedQoS;
	}

	public void setRequestedQoS(String requestedQoS) {
		RequestedQoS = requestedQoS;
	}

	public String getSubscribedQoS() {
		return SubscribedQoS;
	}

	public void setSubscribedQoS(String subscribedQoS) {
		SubscribedQoS = subscribedQoS;
	}

	public String getDialledAPN() {
		return DialledAPN;
	}

	public void setDialledAPN(String dialledAPN) {
		DialledAPN = dialledAPN;
	}

	public String getEventType() {
		return EventType;
	}

	public void setEventType(String eventType) {
		EventType = eventType;
	}

	public String getProviderID() {
		return providerID;
	}

	public void setProviderID(String providerID) {
		this.providerID = providerID;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getSubscriberstatus() {
		return Subscriberstatus;
	}

	public void setSubscriberstatus(String subscriberstatus) {
		Subscriberstatus = subscriberstatus;
	}

	public String getForwardingflag() {
		return Forwardingflag;
	}

	public void setForwardingflag(String forwardingflag) {
		Forwardingflag = forwardingflag;
	}

	public String getFirstcallflag() {
		return Firstcallflag;
	}

	public void setFirstcallflag(String firstcallflag) {
		Firstcallflag = firstcallflag;
	}

	public String getCAMELRoaming() {
		return CAMELRoaming;
	}

	public void setCAMELRoaming(String cAMELRoaming) {
		CAMELRoaming = cAMELRoaming;
	}

	public String getTimezone() {
		return Timezone;
	}

	public void setTimezone(String timezone) {
		Timezone = timezone;
	}

	public String getAccountBalance() {
		return AccountBalance;
	}

	public void setAccountBalance(String accountBalance) {
		AccountBalance = accountBalance;
	}

	public String getAccountDelta() {
		return AccountDelta;
	}

	public void setAccountDelta(String accountDelta) {
		AccountDelta = accountDelta;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getAccountOwner() {
		return AccountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		AccountOwner = accountOwner;
	}

	public String getEventSource() {
		return EventSource;
	}

	public void setEventSource(String eventSource) {
		EventSource = eventSource;
	}

	public String getGuidingresourcetype() {
		return Guidingresourcetype;
	}

	public void setGuidingresourcetype(String guidingresourcetype) {
		Guidingresourcetype = guidingresourcetype;
	}

	public String getRoundedduration() {
		return Roundedduration;
	}

	public void setRoundedduration(String roundedduration) {
		Roundedduration = roundedduration;
	}

	public String getTotalvolume() {
		return Totalvolume;
	}

	public void setTotalvolume(String totalvolume) {
		Totalvolume = totalvolume;
	}

	public String getRoundedtotalvolume() {
		return Roundedtotalvolume;
	}

	public void setRoundedtotalvolume(String roundedtotalvolume) {
		Roundedtotalvolume = roundedtotalvolume;
	}

	public String getEventstartperiod() {
		return Eventstartperiod;
	}

	public void setEventstartperiod(String eventstartperiod) {
		Eventstartperiod = eventstartperiod;
	}

	public String getChargeincludingfreeallowance() {
		return Chargeincludingfreeallowance;
	}

	public void setChargeincludingfreeallowance(String chargeincludingfreeallowance) {
		Chargeincludingfreeallowance = chargeincludingfreeallowance;
	}

	public String getDiscountamount() {
		return Discountamount;
	}

	public void setDiscountamount(String discountamount) {
		Discountamount = discountamount;
	}

	public String getFreetotalvolume() {
		return Freetotalvolume;
	}

	public void setFreetotalvolume(String freetotalvolume) {
		Freetotalvolume = freetotalvolume;
	}

	public String getFreeduration() {
		return Freeduration;
	}

	public void setFreeduration(String freeduration) {
		Freeduration = freeduration;
	}

	public String getCalldirection() {
		return Calldirection;
	}

	public void setCalldirection(String calldirection) {
		Calldirection = calldirection;
	}

	public String getChargecodedescription() {
		return Chargecodedescription;
	}

	public void setChargecodedescription(String chargecodedescription) {
		Chargecodedescription = chargecodedescription;
	}

	public String getSpecialnumberind() {
		return Specialnumberind;
	}

	public void setSpecialnumberind(String specialnumberind) {
		Specialnumberind = specialnumberind;
	}

	public String getBonusinformation() {
		return Bonusinformation;
	}

	public void setBonusinformation(String bonusinformation) {
		Bonusinformation = bonusinformation;
	}

	public String getInternalCause() {
		return InternalCause;
	}

	public void setInternalCause(String internalCause) {
		InternalCause = internalCause;
	}

	public String getBasicCause() {
		return BasicCause;
	}

	public void setBasicCause(String basicCause) {
		BasicCause = basicCause;
	}

	public String getTimeband() {
		return Timeband;
	}

	public void setTimeband(String timeband) {
		Timeband = timeband;
	}

	public String getCalltype() {
		return Calltype;
	}

	public void setCalltype(String calltype) {
		Calltype = calltype;
	}

	public String getBonusconsumed() {
		return Bonusconsumed;
	}

	public void setBonusconsumed(String bonusconsumed) {
		Bonusconsumed = bonusconsumed;
	}

	public String getVAScode() {
		return VAScode;
	}

	public void setVAScode(String vAScode) {
		VAScode = vAScode;
	}

	public String getServicefilter() {
		return Servicefilter;
	}

	public void setServicefilter(String servicefilter) {
		Servicefilter = servicefilter;
	}

	public String getNationalcallingzone() {
		return Nationalcallingzone;
	}

	public void setNationalcallingzone(String nationalcallingzone) {
		Nationalcallingzone = nationalcallingzone;
	}

	public String getNationalcalledzone() {
		return Nationalcalledzone;
	}

	public void setNationalcalledzone(String nationalcalledzone) {
		Nationalcalledzone = nationalcalledzone;
	}

	public String getInternationalcallingzone() {
		return Internationalcallingzone;
	}

	public void setInternationalcallingzone(String internationalcallingzone) {
		Internationalcallingzone = internationalcallingzone;
	}

	public String getInternationalcalledzone() {
		return Internationalcalledzone;
	}

	public void setInternationalcalledzone(String internationalcalledzone) {
		Internationalcalledzone = internationalcalledzone;
	}

	public String getCreditindicator() {
		return Creditindicator;
	}

	public void setCreditindicator(String creditindicator) {
		Creditindicator = creditindicator;
	}

	public String getEventID() {
		return EventID;
	}

	public void setEventID(String eventID) {
		EventID = eventID;
	}

	public String getAccesscode() {
		return Accesscode;
	}

	public void setAccesscode(String accesscode) {
		Accesscode = accesscode;
	}

	public String getCountryname() {
		return Countryname;
	}

	public void setCountryname(String countryname) {
		Countryname = countryname;
	}

	public String getCPname() {
		return CPname;
	}

	public void setCPname(String cPname) {
		CPname = cPname;
	}

	public String getContentid() {
		return Contentid;
	}

	public void setContentid(String contentid) {
		Contentid = contentid;
	}

	public String getRatingGroup() {
		return RatingGroup;
	}

	public void setRatingGroup(String ratingGroup) {
		RatingGroup = ratingGroup;
	}

	public String getBFTIndicator() {
		return BFTIndicator;
	}

	public void setBFTIndicator(String bFTIndicator) {
		BFTIndicator = bFTIndicator;
	}

	public String getUnappliedamount() {
		return Unappliedamount;
	}

	public void setUnappliedamount(String unappliedamount) {
		Unappliedamount = unappliedamount;
	}

	public String getPartitionID() {
		return PartitionID;
	}

	public void setPartitionID(String partitionID) {
		PartitionID = partitionID;
	}

	public String getRatedDateTime() {
		return RatedDateTime;
	}

	public void setRatedDateTime(String ratedDateTime) {
		RatedDateTime = ratedDateTime;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getCostband() {
		return Costband;
	}

	public void setCostband(String costband) {
		Costband = costband;
	}

	public String getRatingOfferId() {
		return RatingOfferId;
	}

	public void setRatingOfferId(String ratingOfferId) {
		RatingOfferId = ratingOfferId;
	}

	public String getSettlementIndicator() {
		return SettlementIndicator;
	}

	public void setSettlementIndicator(String settlementIndicator) {
		SettlementIndicator = settlementIndicator;
	}

	public String getTapCode() {
		return TapCode;
	}

	public void setTapCode(String tapCode) {
		TapCode = tapCode;
	}

	public String getMCCMNC() {
		return MCCMNC;
	}

	public void setMCCMNC(String mCCMNC) {
		MCCMNC = mCCMNC;
	}

	public String getRatingPricingitemID() {
		return RatingPricingitemID;
	}

	public void setRatingPricingitemID(String ratingPricingitemID) {
		RatingPricingitemID = ratingPricingitemID;
	}

	public String getFileIdentifier() {
		return FileIdentifier;
	}

	public void setFileIdentifier(String fileIdentifier) {
		FileIdentifier = fileIdentifier;
	}

	public String getRecordNumber() {
		return RecordNumber;
	}

	public void setRecordNumber(String recordNumber) {
		RecordNumber = recordNumber;
	}

	public String getFutureString1() {
		return FutureString1;
	}

	public void setFutureString1(String futureString1) {
		FutureString1 = futureString1;
	}

	public String getFutureString2() {
		return FutureString2;
	}

	public void setFutureString2(String futureString2) {
		FutureString2 = futureString2;
	}

	public String getFutureString3() {
		return FutureString3;
	}

	public void setFutureString3(String futureString3) {
		FutureString3 = futureString3;
	}

	public String getAllowanceconsumedrevenue() {
		return Allowanceconsumedrevenue;
	}

	public void setAllowanceconsumedrevenue(String allowanceconsumedrevenue) {
		Allowanceconsumedrevenue = allowanceconsumedrevenue;
	}

	public String getIFRSIndforAllowancerevenue() {
		return IFRSIndforAllowancerevenue;
	}

	public void setIFRSIndforAllowancerevenue(String iFRSIndforAllowancerevenue) {
		IFRSIndforAllowancerevenue = iFRSIndforAllowancerevenue;
	}

	public String getIFRSIndforVASevent() {
		return IFRSIndforVASevent;
	}

	public void setIFRSIndforVASevent(String iFRSIndforVASevent) {
		IFRSIndforVASevent = iFRSIndforVASevent;
	}

	public String getItemizedBillFee() {
		return ItemizedBillFee;
	}

	public void setItemizedBillFee(String itemizedBillFee) {
		ItemizedBillFee = itemizedBillFee;
	}

	public String getConsumedMonetaryAllowance() {
		return ConsumedMonetaryAllowance;
	}

	public void setConsumedMonetaryAllowance(String consumedMonetaryAllowance) {
		ConsumedMonetaryAllowance = consumedMonetaryAllowance;
	}

	public String getPartialchargeind() {
		return Partialchargeind;
	}

	public void setPartialchargeind(String partialchargeind) {
		Partialchargeind = partialchargeind;
	}

}
