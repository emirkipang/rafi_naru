package rafi_naru.qsr.model;

public class DU_ITU {
	private String date;
	private String msisdn;

	public DU_ITU(String date, String msisdn) {
		super();
		this.date = date;
		this.msisdn = msisdn;
	}

	public DU_ITU() {
		super();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

}
