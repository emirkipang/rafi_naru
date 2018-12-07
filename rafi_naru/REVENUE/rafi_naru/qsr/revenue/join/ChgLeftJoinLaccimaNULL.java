package rafi_naru.qsr.revenue.join;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.general.model.Laccima;
import rafi_naru.qsr.general.model.OutputAgg;
import rafi_naru.qsr.payload.model.Upcc;
import rafi_naru.qsr.revenue.model.Chg;
import rafi_naru.qsr.revenue.model.UnknownRev;

public class ChgLeftJoinLaccimaNULL implements FlatJoinFunction<Chg, Laccima, UnknownRev> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void join(Chg leftElem, Laccima rightElem, Collector<UnknownRev> out) throws Exception {
		// TODO Auto-generated method stub
		if (rightElem == null) {	
			UnknownRev unknown = new UnknownRev();
			unknown.setDate(leftElem.getDate());
			unknown.setLacci(leftElem.getLacci());
			unknown.setAmount(leftElem.getRevenue());
			unknown.setMSISDN(leftElem.getBParty());
			unknown.setFutureString3(leftElem.getFutureString3());
			unknown.setFeed("chg");
			out.collect(unknown);
		} 
	}
}
