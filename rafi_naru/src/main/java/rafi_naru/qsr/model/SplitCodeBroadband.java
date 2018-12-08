package rafi_naru.qsr.model;

public class SplitCodeBroadband {
	private String SPLITCODE;
	private String DENOM;
	private String COSTBAND;
	private String SERVICE_TYPE_ID;
	private String splitcode_with_recharge;

	public SplitCodeBroadband() {
		super();
	}

	public SplitCodeBroadband(String sPLITCODE, String dENOM, String cOSTBAND, String sERVICE_TYPE_ID,
			String splitcode_with_recharge) {
		super();
		SPLITCODE = sPLITCODE;
		DENOM = dENOM;
		COSTBAND = cOSTBAND;
		SERVICE_TYPE_ID = sERVICE_TYPE_ID;
		this.splitcode_with_recharge = splitcode_with_recharge;
	}

	public String getSplitcode_with_recharge() {
		return splitcode_with_recharge;
	}

	public void setSplitcode_with_recharge(String splitcode_with_recharge) {
		this.splitcode_with_recharge = splitcode_with_recharge;
	}

	public String getSPLITCODE() {
		return SPLITCODE;
	}

	public void setSPLITCODE(String sPLITCODE) {
		SPLITCODE = sPLITCODE;
	}

	public String getDENOM() {
		return DENOM;
	}

	public void setDENOM(String dENOM) {
		DENOM = dENOM;
	}

	public String getCOSTBAND() {
		return COSTBAND;
	}

	public void setCOSTBAND(String cOSTBAND) {
		COSTBAND = cOSTBAND;
	}

	public String getSERVICE_TYPE_ID() {
		return SERVICE_TYPE_ID;
	}

	public void setSERVICE_TYPE_ID(String sERVICE_TYPE_ID) {
		SERVICE_TYPE_ID = sERVICE_TYPE_ID;
	}

}
