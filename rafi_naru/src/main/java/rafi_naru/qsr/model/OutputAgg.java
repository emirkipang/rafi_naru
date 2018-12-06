package rafi_naru.qsr.model;

public class OutputAgg {
	private String date;
	private String node_type;
	private String area;
	private String region;
	private String amount;

	public OutputAgg() {
		super();
	}

	public OutputAgg(String date, String node_type, String area, String region,
			String amount) {
		super();
		this.date = date;
		this.node_type = node_type;
		this.area = area;
		this.region = region;
		this.amount = amount;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return this.getDate() + "|" + this.getNode_type() + "|" + this.getArea() + "|"
				+ this.getRegion() + "|" + this.getAmount();
	}

}
