package rafi_naru.qsr.model;

public class VasCodeBroadband {
	private String VASCODE;
	private String COSTBAND;
	private String SERVICE_TYPE_ID;

	public VasCodeBroadband() {
		super();
	}

	public VasCodeBroadband(String vASCODE, String cOSTBAND, String sERVICE_TYPE_ID) {
		super();
		VASCODE = vASCODE;
		COSTBAND = cOSTBAND;
		SERVICE_TYPE_ID = sERVICE_TYPE_ID;
	}

	public String getVASCODE() {
		return VASCODE;
	}

	public void setVASCODE(String vASCODE) {
		VASCODE = vASCODE;
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
