package rafi_naru.qsr.revenue.model;

public class SplitCodeRev {
	private String splitCode;
	private String feed;
	private String recharge_amount;
	private String desc;
	
	private String splitcode_with_recharge;

	public SplitCodeRev() {
		super();
	}

	public SplitCodeRev(String splitCode, String feed, String recharge_amount, String desc, String splitcode_with_recharge) {
		super();
		this.splitCode = splitCode;
		this.feed = feed;
		this.recharge_amount = recharge_amount;
		this.desc = desc;
		this.splitcode_with_recharge = splitcode_with_recharge;
	}

	
	
	public String getSplitcode_with_recharge() {
		return splitcode_with_recharge;
	}

	public void setSplitcode_with_recharge(String splitcode_with_recharge) {
		this.splitcode_with_recharge = splitcode_with_recharge;
	}

	public String getSplitCode() {
		return splitCode;
	}

	public void setSplitCode(String splitCode) {
		this.splitCode = splitCode;
	}

	public String getFeed() {
		return feed;
	}

	public void setFeed(String feed) {
		this.feed = feed;
	}

	public String getRecharge_amount() {
		return recharge_amount;
	}

	public void setRecharge_amount(String recharge_amount) {
		this.recharge_amount = recharge_amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
