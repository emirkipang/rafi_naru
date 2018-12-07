package rafi_naru.qsr.revenue.join;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.general.model.Laccima;
import rafi_naru.qsr.general.model.OutputAgg;
import rafi_naru.qsr.payload.model.Upcc;
import rafi_naru.qsr.revenue.model.Chg;
import rafi_naru.qsr.revenue.model.Rcg;

public class RcgInnerJoinLaccima implements FlatJoinFunction<Rcg, Laccima, OutputAgg> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void join(Rcg leftElem, Laccima rightElem, Collector<OutputAgg> out) throws Exception {
		// TODO Auto-generated method stub
		OutputAgg outputUpcc = new OutputAgg();

		if (rightElem != null) {
			outputUpcc.setDate(leftElem.getDate());
			outputUpcc.setAmount(leftElem.getRevenue());
			outputUpcc.setNode_type(rightElem.getNode());
			outputUpcc.setArea(rightElem.getArea());
			outputUpcc.setRegion(rightElem.getRegional_channel());
			out.collect(outputUpcc);
		}
	}

}
