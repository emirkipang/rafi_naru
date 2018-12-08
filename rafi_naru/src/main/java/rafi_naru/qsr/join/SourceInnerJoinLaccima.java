package rafi_naru.qsr.join;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Chg;
import rafi_naru.qsr.model.Laccima;
import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.Source;
import rafi_naru.qsr.model.Upcc;

public class SourceInnerJoinLaccima implements FlatJoinFunction<Source, Laccima, OutputAgg> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void join(Source leftElem, Laccima rightElem, Collector<OutputAgg> out) throws Exception {
		// TODO Auto-generated method stub
		OutputAgg output = new OutputAgg();

		if (rightElem != null) {
			output.setDate(leftElem.getDate());
			output.setAmount(leftElem.getAmount());
			output.setNode_type(rightElem.getNode());
			output.setArea(rightElem.getArea());
			output.setRegion(rightElem.getRegional_channel());
			output.setMsisdn(leftElem.getMsisdn());
			out.collect(output);
		}
	}

}
