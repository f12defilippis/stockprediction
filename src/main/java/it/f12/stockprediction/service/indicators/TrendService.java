package it.f12.stockprediction.service.indicators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;

@Service
public class TrendService {

	@Autowired
	private MovingAverageService movingAverageService;
	
	
	public String longTermTrendWithEma(Quote quote)
	{
		String trend = "LATERAL";
		
		Double ema150 = movingAverageService.calculateEMA(quote, 150);
		
		Double ema20 = movingAverageService.calculateEMA(quote, 20);
		if(ema20 > ema150)
		{
			trend = "BULLISH";
		}else if(ema20 < ema150)
		{
			trend = "BEARISH";
		}
			
		Double ema40 = movingAverageService.calculateEMA(quote, 40);
		if(ema40 > ema150 && trend.equals("BULLISH"))
		{
			trend = "BULLISH";
		}else if(ema40 < ema150 && trend.equals("BEARISH"))
		{
			trend = "BEARISH";
		}else
		{
			return "LATERAL";
		}

		Double ema60 = movingAverageService.calculateEMA(quote, 60);
		if(ema60 > ema150 && trend.equals("BULLISH"))
		{
			trend = "BULLISH";
		}else if(ema60 < ema150 && trend.equals("BEARISH"))
		{
			trend = "BEARISH";
		}else
		{
			return "LATERAL";
		}
		
		Double ema80 = movingAverageService.calculateEMA(quote, 80);
		if(ema80 > ema150 && trend.equals("BULLISH"))
		{
			trend = "BULLISH";
		}else if(ema80 < ema150 && trend.equals("BEARISH"))
		{
			trend = "BEARISH";
		}else
		{
			return "LATERAL";
		}
		
		return trend;
	}
	
	
	
	
}
