package rafi_naru.qsr.payload.join;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.general.model.Laccima;
import rafi_naru.qsr.general.model.OutputAgg;
import rafi_naru.qsr.payload.model.Upcc;
import rafi_naru.qsr.revenue.model.Chg;

public class UpccLeftJoinLaccimaNULL implements FlatJoinFunction<Upcc, Laccima, Upcc> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void join(Upcc leftElem, Laccima rightElem, Collector<Upcc> out) throws Exception {
		// TODO Auto-generated method stub
		if (rightElem == null) {			
			out.collect(leftElem);
		} 
	}
}
