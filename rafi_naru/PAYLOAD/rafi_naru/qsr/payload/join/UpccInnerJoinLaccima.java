package rafi_naru.qsr.payload.join;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.general.model.Laccima;
import rafi_naru.qsr.general.model.OutputAgg;
import rafi_naru.qsr.payload.model.Upcc;
import rafi_naru.qsr.revenue.model.Chg;

public class UpccInnerJoinLaccima implements FlatJoinFunction<Upcc, Laccima, OutputAgg> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void join(Upcc leftElem, Laccima rightElem, Collector<OutputAgg> out) throws Exception {
		// TODO Auto-generated method stub
		OutputAgg outputUpcc = new OutputAgg();

		if (rightElem != null) {
			outputUpcc.setDate(leftElem.getDate());
			outputUpcc.setAmount(leftElem.getQuotaUsage());
			outputUpcc.setNode_type(rightElem.getNode());
			outputUpcc.setArea(rightElem.getArea());
			outputUpcc.setRegion(rightElem.getRegional_channel());
			out.collect(outputUpcc);
		}
	}

}
