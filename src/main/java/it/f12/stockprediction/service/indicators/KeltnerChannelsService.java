package it.f12.stockprediction.service.indicators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;

@Service
public class KeltnerChannelsService {

	
	@Autowired
	private AverageTrueRangeService averageTrueRangeService;
	
	@Autowired
	private MovingAverageService movingAverageService;
	
	
	public Double calculateUpperChannel(Quote quote)
	{
		return calculateChannel(quote, "u");
	}

	public Double calculateLowerChannel(Quote quote)
	{
		return calculateChannel(quote, "l");
	}

	public Double calculateMiddleChannel(Quote quote)
	{
		return movingAverageService.calculateEMA(quote, 20);
	}
	
	
	public Double calculateChannel(Quote quote, String upperLower)
	{
		Double channel = 0.0;
		Double ema20 = movingAverageService.calculateEMA(quote, 20);
		Double atr10 = averageTrueRangeService.calculate(quote, 10);
		if(upperLower.equals("u"))
		{
			channel = ema20 + (2*atr10);
		}else
		{
			channel = ema20 - (2*atr10);
		}
		return channel;
	}
	
	
}
