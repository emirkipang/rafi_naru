package rafi_naru.qsr.revenue.join;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.general.model.OutputAgg;
import rafi_naru.qsr.revenue.model.Rcg;
import rafi_naru.qsr.revenue.model.SplitCodeRev;

public class RcgInnerJoinSplitCodeRev implements FlatJoinFunction<Rcg, SplitCodeRev, Rcg> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void join(Rcg leftElem, SplitCodeRev rightElem, Collector<Rcg> out) throws Exception {
		// TODO Auto-generated method stub

		if (rightElem != null) {
			out.collect(leftElem);
		}

	}

}
