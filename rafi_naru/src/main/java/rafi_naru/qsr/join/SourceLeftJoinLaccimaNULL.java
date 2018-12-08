package rafi_naru.qsr.join;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Laccima;
import rafi_naru.qsr.model.Source;

public class SourceLeftJoinLaccimaNULL implements FlatJoinFunction<Source, Laccima, Source> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void join(Source leftElem, Laccima rightElem, Collector<Source> out) throws Exception {
		// TODO Auto-generated method stub
		if (rightElem == null) {	
			out.collect(leftElem);
		} 
	}
}
