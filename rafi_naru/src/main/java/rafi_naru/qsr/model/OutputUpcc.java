package rafi_naru.qsr.model;

public class OutputUpcc {
	private String date;
	private String node_type;
	private String area;
	private String region;
	private String total_payload;

	public OutputUpcc() {
		super();
	}

	public OutputUpcc(String date, String node_type, String area, String region,
			String total_payload) {
		super();
		this.date = date;
		this.node_type = node_type;
		this.area = area;
		this.region = region;
		this.total_payload = total_payload;
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

	public String getTotal_payload() {
		return total_payload;
	}

	public void setTotal_payload(String total_payload) {
		this.total_payload = total_payload;
	}

	@Override
	public String toString() {
		return this.getDate() + "|" + this.getNode_type() + "|" + this.getArea() + "|"
				+ this.getRegion() + "|" + this.getTotal_payload();
	}

}
