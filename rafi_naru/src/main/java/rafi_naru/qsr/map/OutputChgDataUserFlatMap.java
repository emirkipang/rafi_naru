package rafi_naru.qsr.map;


import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Chg;
import rafi_naru.qsr.model.OutputTuple;
import rafi_naru.qsr.model.Upcc;


public class OutputChgDataUserFlatMap implements FlatMapFunction<Chg, OutputTuple> {

	private String header;
	private static final long serialVersionUID = 1L;
	
	public OutputChgDataUserFlatMap(){
		
	}

	public OutputChgDataUserFlatMap(String header) {
		this.header = header;
	}
	
	public void flatMap(Chg in, Collector<OutputTuple> out) throws Exception {
		// TODO Auto-generated method stub
		OutputTuple output = new OutputTuple(header);


		output.setFields(
				in.toStringDataUser()
		);	
		
		out.collect(output);
	}


}
