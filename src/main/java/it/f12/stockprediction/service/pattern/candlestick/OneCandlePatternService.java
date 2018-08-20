package it.f12.stockprediction.service.pattern.candlestick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;
import it.f12.stockprediction.service.indicators.TrendService;

@Service
public class OneCandlePatternService {


	@Autowired
	private TrendService trendService;
	
	public boolean checkBeltHoldBullish(Quote quote, Double atr)
	{
		CandlestickTO candle = new CandlestickTO(quote, atr);
		
		String trend = trendService.longTermTrendWithEma(quote);
		
		
		return trend.equals("BEARISH") && candle.getType().equals("BULLISH") &&
				candle.isLongBody() && 
				candle.getLowerShadow() == 0.0 && 
				candle.isShortUpperShadow();
		
	}
	
	public boolean checkBeltHoldBearish(Quote quote, Double atr)
	{
		CandlestickTO candle = new CandlestickTO(quote, atr);

		String trend = trendService.longTermTrendWithEma(quote);
		
		return trend.equals("BULLISH") && candle.getType().equals("BEARISH") &&
				candle.isLongBody() && 
				candle.getUpperShadow() == 0.0 && 
				candle.isShortLowerShadow();
		
	}
	
}
