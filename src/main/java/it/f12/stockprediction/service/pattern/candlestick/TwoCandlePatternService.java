package it.f12.stockprediction.service.pattern.candlestick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;
import it.f12.stockprediction.service.indicators.TrendService;

@Service
public class TwoCandlePatternService {

	@Autowired
	private TrendService trendService;
	
	// BEARISH SIGNAL 60-40
	public boolean checkDarkCloudCover(Quote today, Quote yesterday, Double atr)
	{
		CandlestickTO candleToday = new CandlestickTO(today, atr);
		CandlestickTO candleYesterday = new CandlestickTO(yesterday, atr);
		
		String trend = trendService.longTermTrendWithEma(today);

		boolean checked = candleToday.getType().equals("BEARISH") && trend.equals("BULLISH");
		checked = checked && candleYesterday.getType().equals("BULLISH");

		Double middleCandleYesterday = (candleYesterday.getUp() + candleYesterday.getDown()) / 2.0;
		
		checked = checked && 
				candleToday.getDown() < middleCandleYesterday && 
				candleToday.getDown() > candleYesterday.getDown(); 
		
		return checked;
		
	}
	
	
}
