package rafi_naru.qsr.general.model;

public class MostDominant {
	private String trx_date;//0
	private String msisdn;//1
	private String lacci_id;//2
	private String lac;//3
	private String ci;//4
	private String node;//5
	private String area;//6
	private String region;//7
	private String branch;//8
	private String subbranch;//9
	private String cluster;//10
	private String kabupaten;//11
	
	
	
	public MostDominant(String msisdn, String node, String area, String region) {
		super();
		this.msisdn = msisdn;
		this.node = node;
		this.area = area;
		this.region = region;
	}


	public MostDominant() {
		super();
	}
	
	
	public String getTrx_date() {
		return trx_date;
	}
	public void setTrx_date(String trx_date) {
		this.trx_date = trx_date;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getLacci_id() {
		return lacci_id;
	}
	public void setLacci_id(String lacci_id) {
		this.lacci_id = lacci_id;
	}
	public String getLac() {
		return lac;
	}
	public void setLac(String lac) {
		this.lac = lac;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
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
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSubbranch() {
		return subbranch;
	}
	public void setSubbranch(String subbranch) {
		this.subbranch = subbranch;
	}
	public String getCluster() {
		return cluster;
	}
	public void setCluster(String cluster) {
		this.cluster = cluster;
	}
	public String getKabupaten() {
		return kabupaten;
	}
	public void setKabupaten(String kabupaten) {
		this.kabupaten = kabupaten;
	}

	
}
