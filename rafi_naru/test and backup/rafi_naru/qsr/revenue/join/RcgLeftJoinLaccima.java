package rafi_naru.qsr.revenue.join;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.general.model.Laccima;
import rafi_naru.qsr.general.model.OutputAgg;
import rafi_naru.qsr.revenue.model.Chg;
import rafi_naru.qsr.revenue.model.Rcg;

public class RcgLeftJoinLaccima implements FlatJoinFunction<Rcg, Laccima, OutputAgg> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void join(Rcg leftElem, Laccima rightElem, Collector<OutputAgg> out) throws Exception {
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
	
	private String getUnknownNodeType(Rcg rcg) {
		if (rcg.getFuture_String_3() != null && rcg.getFuture_String_3().equalsIgnoreCase("4G")) {
			return "4G";
		} else {
			return "3G";
		}
	}

}
