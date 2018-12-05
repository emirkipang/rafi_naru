package rafi_naru.qsr.model;

import org.apache.flink.api.java.tuple.Tuple1;

public class Output
		extends
		Tuple1<String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public void setFields(String values) {
		// TODO Auto-generated method stub
		super.setFields(values);
	}

}
