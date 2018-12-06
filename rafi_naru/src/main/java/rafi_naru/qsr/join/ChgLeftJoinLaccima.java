package rafi_naru.qsr.join;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Laccima;
import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.Chg;

public class ChgLeftJoinLaccima implements FlatJoinFunction<Chg, Laccima, OutputAgg> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void join(Chg leftElem, Laccima rightElem, Collector<OutputAgg> out) throws Exception {
		// TODO Auto-generated method stub
		OutputAgg outputAgg = new OutputAgg();

		if (rightElem == null) {
			outputAgg.setDate(leftElem.getDate());
			outputAgg.setAmount(leftElem.getRevenue());
			outputAgg.setNode_type(getUnknownNodeType(leftElem));
			outputAgg.setArea("UNKNOWN");
			outputAgg.setRegion("UNKNOWN");

			out.collect(outputAgg);
		} else {
			outputAgg.setDate(leftElem.getDate());
			outputAgg.setAmount(leftElem.getRevenue());
			outputAgg.setNode_type(rightElem.getNode());
			outputAgg.setArea(rightElem.getArea());
			outputAgg.setRegion(rightElem.getRegional_channel());

			out.collect(outputAgg);
		}

	}

	private String getUnknownNodeType(Chg chg) {
		if (chg.getFutureString3() != null && chg.getFutureString3().equalsIgnoreCase("129")) {
			return "4G";
		} else {
			return "3G";
		}
	}

}
