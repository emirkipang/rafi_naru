package rafi_naru.qsr.model;

public class Source {
	private String date; 
	private String lacci; 
	private String msisdn; 
	private String node;	
	private String amount; 
	private String feed;
	
	public Source() {
		
	}

	public Source(String date, String lacci, String msisdn, String node, String amount, String feed) {
		super();
		this.date = date;
		this.lacci = lacci;
		this.msisdn = msisdn;
		this.node = node;
		this.amount = amount;
		this.feed = feed;
	}	
	
	public String getFeed() {
		return feed;
	}

	public void setFeed(String feed) {
		this.feed = feed;
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

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}


	
	
	
}
