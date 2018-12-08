package rafi_naru.qsr.join;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Chg;
import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.Source;
import rafi_naru.qsr.model.SplitCodeRev;
import rafi_naru.qsr.model.VasCodeBroadband;

public class ChgDataUserInnerJoinVasCodeBroadband implements FlatJoinFunction<Chg, VasCodeBroadband, Source> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void join(Chg leftElem, VasCodeBroadband rightElem, Collector<Source> out) throws Exception {
		// TODO Auto-generated method stub

		if (rightElem != null || leftElem.getServicefilter().equalsIgnoreCase("GPRS")) {
			Source source = new Source();
			source.setDate(leftElem.getDate());
			source.setNode(leftElem.getFutureString3());
			source.setLacci(leftElem.getLacci());			
			source.setMsisdn(leftElem.getAParty());
			source.setAmount(leftElem.getRevenue());	
			source.setFeed("chg");
			out.collect(source);
		}

	}

}
