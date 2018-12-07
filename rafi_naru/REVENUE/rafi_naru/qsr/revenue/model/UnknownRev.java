package rafi_naru.qsr.revenue.model;

public class UnknownRev {
	private String MSISDN; //-1
	private String date; // -1
	private String lacci; // -1
	private String amount; // -1
	private String futureString3; // -1
	private String feed;

	public UnknownRev(String date, String lacci, String amount, String MSISDN, String futureString3, String feed) {
		super();
		this.date = date;
		this.lacci = lacci;
		this.amount = amount;
		this.MSISDN = MSISDN;
		this.futureString3 = futureString3;
		this.feed = feed;
	}

	public UnknownRev() {
		super();
	}
		


	public String getFeed() {
		return feed;
	}

	public void setFeed(String feed) {
		this.feed = feed;
	}

	public String getFutureString3() {
		return futureString3;
	}

	public void setFutureString3(String futureString3) {
		this.futureString3 = futureString3;
	}

	public String getMSISDN() {
		return MSISDN;
	}

	public void setMSISDN(String mSISDN) {
		MSISDN = mSISDN;
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}


	

}
