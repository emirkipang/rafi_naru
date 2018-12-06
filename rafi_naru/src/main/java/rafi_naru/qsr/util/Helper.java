package rafi_naru.qsr.util;

import java.text.DecimalFormat;

public class Helper {
	public static final String isNull(String text) {
		return (text == null) ? "" : text;
	}

	public static final String isEmpty(String text) {
		text = text.replaceAll("\\s", "");
		return (text.equals("")) ? "0" : text;
	}

	public static final String getFormattedDate(String datetime) {
		// note: only for dateformat : "20181203120506"
		String year = datetime.substring(0, 4);
		String month = datetime.substring(4, 6);
		String day = datetime.substring(6, 8);
		String hour = datetime.substring(8, 10);
		String minute = datetime.substring(10, 12);
		String second = datetime.substring(12, 14);

		return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
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
