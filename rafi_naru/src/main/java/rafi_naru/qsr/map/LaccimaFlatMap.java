package rafi_naru.qsr.map;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import rafi_naru.qsr.model.Laccima;
import rafi_naru.qsr.model.Upcc;
import rafi_naru.qsr.util.Constant;
import rafi_naru.qsr.util.Helper;

public class LaccimaFlatMap implements FlatMapFunction<String, Laccima> {

	private static final long serialVersionUID = 1L;
	private String node_;
	private boolean forUpcc;

	public LaccimaFlatMap(String node_, boolean forUPCC) {
		this.node_ = node_;
		this.forUpcc = forUPCC;
	}

	public void flatMap(String value, Collector<Laccima> out) throws Exception {
		// TODO Auto-generated method stub
		String[] lines = value.split("\n");

		for (String fields : lines) {
			String[] field = fields.split("\\|", -1);

			if (field.length == Constant.LACCIMA_COLUMN_LENGTH) {
				// head
				String lac = field[0].trim();
				String cell_id = field[1].trim();
				String node = field[8].trim();
				String regional_channel = field[17].trim();
				String eci = field[30].trim();
				String lacci_or_eci = "";
				String area = "";

				if (!(regional_channel.equalsIgnoreCase("") && !(node.equalsIgnoreCase("UNKNOWN")))) {

					// body
					if (node_.equals("3G")) {
						lacci_or_eci = Helper.joinRule(lac, 5) + "~" + Helper.joinRule(cell_id, 5);
					} else if (node_.equals("4G") && this.forUpcc) {
						lacci_or_eci = eci;
					} else {
						lacci_or_eci = Helper.joinRule(lac, 7) + "~" + Helper.joinRule(cell_id, 3);
					}

					if (regional_channel.equals("BALI NUSRA")) {
						regional_channel = "BALINUSRA";
					} else if (regional_channel.equals("JATENG-DIY")) {
						regional_channel = "JATENG";
					} else if (regional_channel.equals("MALUKU DAN PAPUA")) {
						regional_channel = "PUMA";
					} else if (regional_channel.equals("SAD REGIONAL")) {
						regional_channel = "UNKNOWN";
					}

					if (regional_channel.equalsIgnoreCase("SUMBAGSEL") || regional_channel.equalsIgnoreCase("SUMBAGUT")
							|| regional_channel.equalsIgnoreCase("SUMBAGTENG")) {
						area = "AREA 1";
					} else if (regional_channel.equalsIgnoreCase("WESTERN JABOTABEK")
							|| regional_channel.equalsIgnoreCase("EASTERN JABOTABEK")
							|| regional_channel.equalsIgnoreCase("CENTRAL JABOTABEK")
							|| regional_channel.equalsIgnoreCase("JABAR")) {
						area = "AREA 2";
					} else if (regional_channel.equalsIgnoreCase("JATENG") || regional_channel.equalsIgnoreCase("JATIM")
							|| regional_channel.equalsIgnoreCase("BALINUSRA")) {
						area = "AREA 3";
					} else if (regional_channel.equalsIgnoreCase("KALIMANTAN")
							|| regional_channel.equalsIgnoreCase("SULAWESI")
							|| regional_channel.equalsIgnoreCase("PUMA")) {
						area = "AREA 4";
					} else {
						area = "UNKNOWN";
					}

					// output
					out.collect(new Laccima(lacci_or_eci, node, area, regional_channel));
				}
			}

		}
	}

}
