package rafi_naru.qsr.model;

import rafi_naru.qsr.util.Constant;

public class CounterOutput {
	private String prc_date;
	private String tanggal;
	private String node_type;
	private String area;
	private String region;
	private String msisdn;
	private String counter;

	public CounterOutput() {
	}

	public CounterOutput(String prc_date, String tanggal, String node_type, String area, String region, String msisdn,
			String counter) {
		super();
		this.prc_date = prc_date;
		this.tanggal = tanggal;
		this.node_type = node_type;
		this.area = area;
		this.region = region;
		this.msisdn = msisdn;
		this.counter = counter;
	}

	public String getPrc_date() {
		return prc_date;
	}

	public void setPrc_date(String prc_date) {
		this.prc_date = prc_date;
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public String getNode_type() {
		return node_type;
	}

	public void setNode_type(String node_type) {
		this.node_type = node_type;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getCounter() {
		return counter;
	}

	public void setCounter(String counter) {
		this.counter = counter;
	}

	public String toString() {
		return this.getPrc_date() + Constant.OUTPUT_DELIMITER + this.getTanggal() + Constant.OUTPUT_DELIMITER
				+ this.getNode_type() + Constant.OUTPUT_DELIMITER + this.getArea() + Constant.OUTPUT_DELIMITER
				+ this.getRegion() + Constant.OUTPUT_DELIMITER + this.getMsisdn() + Constant.OUTPUT_DELIMITER
				+ this.getCounter();
	}
}
