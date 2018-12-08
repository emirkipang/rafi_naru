package rafi_naru.qsr.model;

import org.apache.flink.api.java.tuple.Tuple1;

import rafi_naru.qsr.util.Constant;

public class OutputTuple
		extends
		Tuple1<String> {
	private static final long serialVersionUID = 1L;
	private String header;

	public OutputTuple() {
		
	}
	
	public OutputTuple(String header) {
		this.header = header;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public void setFields(String values) {
		// TODO Auto-generated method stub
		super.setFields(values + Constant.OUTPUT_DELIMITER + header);
	}

}
