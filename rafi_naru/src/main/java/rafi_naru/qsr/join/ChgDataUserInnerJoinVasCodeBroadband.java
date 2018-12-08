package rafi_naru.qsr.join;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Chg;
import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.SplitCodeRev;
import rafi_naru.qsr.model.VasCodeBroadband;

public class ChgDataUserInnerJoinVasCodeBroadband implements FlatJoinFunction<Chg, VasCodeBroadband, Chg> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void join(Chg leftElem, VasCodeBroadband rightElem, Collector<Chg> out) throws Exception {
		// TODO Auto-generated method stub

		if (rightElem != null || leftElem.getServicefilter().equalsIgnoreCase("GPRS")) {
			out.collect(leftElem);
		}

	}

}
