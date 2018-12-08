package rafi_naru.qsr.join;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.Rcg;
import rafi_naru.qsr.model.Source;
import rafi_naru.qsr.model.SplitCodeBroadband;
import rafi_naru.qsr.model.SplitCodeRev;
import rafi_naru.qsr.model.VasCodeBroadband;

public class RcgDataUserInnerJoinSplitCodeBroadband implements FlatJoinFunction<Rcg, SplitCodeBroadband, Source> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void join(Rcg leftElem, SplitCodeBroadband rightElem, Collector<Source> out) throws Exception {
		// TODO Auto-generated method stub

		if (rightElem != null) {
			Source source = new Source();
			source.setDate(leftElem.getDate());
			source.setLacci(leftElem.getLacci());
			source.setMsisdn(leftElem.getMSISDN());
			source.setNode(leftElem.getFuture_String_3());
			source.setAmount(leftElem.getRevenue());	
			source.setFeed("rcg");	
			out.collect(source);
		}

	}

}
