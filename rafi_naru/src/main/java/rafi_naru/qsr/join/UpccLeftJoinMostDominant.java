package rafi_naru.qsr.join;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Chg;
import rafi_naru.qsr.model.MostDominant;
import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.Upcc;

public class UpccLeftJoinMostDominant implements FlatJoinFunction<Upcc, MostDominant, OutputAgg> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void join(Upcc leftElem, MostDominant rightElem, Collector<OutputAgg> out) throws Exception {
		// TODO Auto-generated method stub
		OutputAgg outputUpcc = new OutputAgg();

		if (rightElem == null) {
			outputUpcc.setDate(leftElem.getDate());
			outputUpcc.setAmount(leftElem.getQuotaUsage());
			outputUpcc.setNode_type(getUnknownNodeType(leftElem));
			outputUpcc.setArea("UNKNOWN");
			outputUpcc.setRegion("UNKNOWN");

			out.collect(outputUpcc);
		} else {
			outputUpcc.setDate(leftElem.getDate());
			outputUpcc.setAmount(leftElem.getQuotaUsage());
			outputUpcc.setNode_type(rightElem.getNode());
			outputUpcc.setArea(rightElem.getArea());
			outputUpcc.setRegion(rightElem.getRegion());

			out.collect(outputUpcc);
		}

	}

	private String getUnknownNodeType(Upcc upcc) {
		if (upcc.getAccessType().equals("2")) {
			return "2G";
		} else if (upcc.getAccessType().equals("1")) {
			return "3G";
		} else if (upcc.getAccessType().equals("6")) {
			return "4G";
		} else {
			return "3G";
		}
	}

}
