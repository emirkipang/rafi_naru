package rafi_naru.qsr.util;

import java.text.DecimalFormat;

public class Helper {
	public static final String isNull(String text) {
		return (text == null) ? "" : text;
	}
	
	public static final String isEmpty(String text) {
		text = text.replaceAll("\\s","");
		return (text.equals("")) ? "0" : text;
	}
	
	public static final String joinRule(String in, int length) {
		int gap = length - in.length();

		if (gap != 0) {
			for (int i = 1; i <= gap; i++) {
				in = "0" + in;
			}
		}

		return in;
	}
	
	public static final String withoutScientificNotation(Double n) {
		DecimalFormat df = new DecimalFormat("0");
		df.setMaximumFractionDigits(340);
		
		return df.format(n);
	}
}
