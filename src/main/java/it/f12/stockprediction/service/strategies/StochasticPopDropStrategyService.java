package it.f12.stockprediction.service.strategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;
import it.f12.stockprediction.service.QuoteService;
import it.f12.stockprediction.service.indicators.ADXService;
import it.f12.stockprediction.service.indicators.MovingAverageService;
import it.f12.stockprediction.service.indicators.StochasticService;
import it.f12.stockprediction.util.DateUtil;

@Service
public class StochasticPopDropStrategyService {

	@Autowired
	private MovingAverageService movingAverageService;
	
	@Autowired
	private StochasticService stochasticService;
	
	@Autowired
	private ADXService adxService;

	@Autowired
	private QuoteService quoteService;
	
//	@Autowired
//	private PivotPointsService pivotPointsService;

	
	public String check(Quote quote)
	{

		String ret = "NONE";
		
		
		Quote yesterdayQuote = quoteService.getLastNQuotesUntilDateOfQuote(quote, 2).get(0);
		
		Double sma20Volume = movingAverageService.calculateSMAVolume(quote, 20);
		Double sma60 = movingAverageService.calculateSMA(quote, 60);
		Double stochasticSlowK70 = stochasticService.calculateFastDOrSlowK(quote, 70, 3);
		Double adxLine14 = adxService.calculate(quote, 14);
		Double yesterdayStochasticSlowK14 = stochasticService.calculateFastDOrSlowK(yesterdayQuote, 14, 3);
		Double todayStochasticSlowK14 = stochasticService.calculateFastDOrSlowK(quote, 14, 3);
		
		boolean bullish = sma20Volume > 40000 &&
						  sma60 > 20 &&
						  stochasticSlowK70 > 50 &&
						  adxLine14 < 20 &&
						  yesterdayStochasticSlowK14 < 80 &&
						  todayStochasticSlowK14 > 80;
		
		boolean bearish =  sma20Volume > 40000 &&
						sma60 > 20 &&
						stochasticSlowK70 < 50 &&
						adxLine14 < 20 &&
						yesterdayStochasticSlowK14 > 20 &&
						todayStochasticSlowK14 < 20;

		
//		Double stopLoss = 0.0;				
						
		if(bullish)
		{
			System.out.println("BUY SIGNAL with Stochastic Pop Drop: " + quote.getStock().getDescription() + " "
					+ "Date: " + DateUtil.format(quote.getDateOfQuote()) + " Price: " + quote.getValue());

			ret = "BULLISH";
//			stopLoss = pivotPointsService.calculate(quote).getFibonacciSupport1();
			
		}else if(bearish)
		{
			System.out.println("SELL SIGNAL with Stochastic Pop Drop: " + quote.getStock().getDescription() + " "
					+ "Date: " + DateUtil.format(quote.getDateOfQuote()) + " Price: " + quote.getValue());
			ret = "BEARISH";
//			stopLoss = pivotPointsService.calculate(quote).getFibonacciResistance1();
		}
						
		return ret;
						
	}
	
	
	
}
