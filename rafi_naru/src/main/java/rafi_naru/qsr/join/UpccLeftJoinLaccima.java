package rafi_naru.qsr.join;

import org.apache.flink.api.common.functions.FlatJoinFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Laccima;
import rafi_naru.qsr.model.OutputUpcc;
import rafi_naru.qsr.model.Upcc;

public class UpccLeftJoinLaccima implements FlatJoinFunction<Upcc, Laccima, OutputUpcc> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void join(Upcc leftElem, Laccima rightElem, Collector<OutputUpcc> out) throws Exception {
		// TODO Auto-generated method stub
		OutputUpcc outputUpcc = new OutputUpcc();

		if (rightElem == null) {
			String node_type = "";
			outputUpcc.setDate(leftElem.getDate());
			outputUpcc.setTotal_payload(leftElem.getQuotaUsage());
			if(leftElem.getAccessType().equals("2") || leftElem.getAccessType().equals("")) {
				node_type = "2G";
			} else if(leftElem.getAccessType().equals("1")) {
				node_type = "3G";
			} else if(leftElem.getAccessType().equals("6")) {
				node_type = "4G";
			} 
			outputUpcc.setNode_type(node_type);
			outputUpcc.setArea("UNKNOWN");
			outputUpcc.setRegion("UNKNOWN");
			
			
			out.collect(outputUpcc);
		} else {
			outputUpcc.setDate(leftElem.getDate());
			outputUpcc.setTotal_payload(leftElem.getQuotaUsage());
			outputUpcc.setNode_type(rightElem.getNode());
			outputUpcc.setArea(rightElem.getArea());
			outputUpcc.setRegion(rightElem.getRegional_channel());
			
			
			out.collect(outputUpcc);
		}

	}

}
