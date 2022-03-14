package api.streamApi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TickerItem {

	private String symbol;
	private String last;
	private String makerFeeRate;
	private String buy;
	private String sell;
	private String makerCoefficient;
	private String volValue;
	private String high;
	private String vol;
	private String low;
	private String changePrice;
	private String takerFeeRate;
	private String takerCoefficient;
	private String symbolName;
	private String averagePrice;
	private String changeRate;
}