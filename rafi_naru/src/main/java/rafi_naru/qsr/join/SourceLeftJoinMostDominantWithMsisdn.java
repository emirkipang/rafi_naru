package rafi_naru.qsr.join;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.MostDominant;
import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.Source;

public class SourceLeftJoinMostDominantWithMsisdn implements FlatJoinFunction<Source, MostDominant, OutputAgg> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void join(Source leftElem, MostDominant rightElem, Collector<OutputAgg> out) throws Exception {
		// TODO Auto-generated method stub
		OutputAgg output = new OutputAgg();

		if (rightElem == null) {
			output.setDate(leftElem.getDate());
			output.setAmount(leftElem.getAmount());
			output.setNode_type(getUnknownNodeType(leftElem.getNode(), leftElem.getFeed()));
			output.setArea("UNKNOWN");
			output.setRegion("UNKNOWN");
			output.setMsisdn(leftElem.getMsisdn());
			out.collect(output);
		} else {
			output.setDate(leftElem.getDate());
			output.setAmount(leftElem.getAmount());
			output.setNode_type(rightElem.getNode());
			output.setArea(rightElem.getArea());
			output.setRegion(rightElem.getRegion());
			output.setMsisdn(leftElem.getMsisdn());
			out.collect(output);
		}

	}

	private String getUnknownNodeType(String futureString3, String feed) {
		if (feed.equalsIgnoreCase("chg")) {
			if (futureString3 != null && futureString3.equalsIgnoreCase("129")) {
				return "4G";
			} else {
				return "3G";
			}
		} else if (feed.equalsIgnoreCase("rcg")) {
			if (futureString3 != null && futureString3.equalsIgnoreCase("4G")) {
				return "4G";
			} else {
				return "3G";
			}
		} else if (feed.equalsIgnoreCase("upcc")) {
			if (futureString3.equals("2")) {
				return "2G";
			} else if (futureString3.equals("1")) {
				return "3G";
			} else if (futureString3.equals("6")) {
				return "4G";
			} else {
				return "3G";
			}
		}
		else {
			return "3G";
		}
	}

}
