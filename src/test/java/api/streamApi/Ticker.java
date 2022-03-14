package api.streamApi;

import java.util.List;
import lombok.Data;

@Data
public class Ticker{
	private List<TickerItem> ticker;
	private long time;
}