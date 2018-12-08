package rafi_naru.qsr.join;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Chg;
import rafi_naru.qsr.model.Laccima;
import rafi_naru.qsr.model.OutputAgg;
import rafi_naru.qsr.model.UnknownRev;
import rafi_naru.qsr.model.Upcc;

public class UpccLeftJoinLaccimaNULL implements FlatJoinFunction<Upcc, Laccima, UnknownRev> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void join(Upcc leftElem, Laccima rightElem, Collector<UnknownRev> out) throws Exception {
		// TODO Auto-generated method stub
		if (rightElem == null) {				
			UnknownRev unknown = new UnknownRev();
			unknown.setDate(leftElem.getDate());
			unknown.setLacci(leftElem.getLacci_or_eci());
			unknown.setAmount(leftElem.getQuotaUsage());
			unknown.setMSISDN(leftElem.getMSISDN());
			unknown.setFutureString3(leftElem.getAccessType());
			unknown.setFeed("upcc");
			out.collect(unknown);
		} 
	}
}
