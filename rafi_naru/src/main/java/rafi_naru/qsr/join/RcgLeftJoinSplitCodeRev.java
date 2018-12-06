package rafi_naru.qsr.join;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.SplitCodeRev;
import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.Rcg;

public class RcgLeftJoinSplitCodeRev implements FlatJoinFunction<Rcg, SplitCodeRev, Rcg> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void join(Rcg leftElem, SplitCodeRev rightElem, Collector<Rcg> out) throws Exception {
		// TODO Auto-generated method stub

		if (rightElem != null) {
			Rcg rcg = new Rcg(leftElem.getDate(), leftElem.getLacci(), leftElem.getRevenue());
			out.collect(rcg);
		}

	}

}
