package it.f12.stockprediction.service.indicators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;
import it.f12.stockprediction.service.QuoteService;

@Service
public class StochasticService {

	@Autowired
	private QuoteService quoteService;

	
	public Double calculateFastK(Quote quote, int howManyPeriods)
	{
		Double fastK = 0.0;
		
		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, howManyPeriods);
		
		Double highestHigh = quoteService.getMaxofMaxValues(quotes);
		Double lowestLow = quoteService.getMinofMinValues(quotes);
		
		fastK = ( quote.getValue() - lowestLow ) / ( highestHigh - lowestLow ) * 100.0;
		
		return fastK;
	}

	public Double calculateFastDOrSlowK(Quote quote, int howManyPeriods, int howManyTimes)
	{
		Double fastD = 0.0;

		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, howManyTimes);

		Double totalFastK = 0.0;
		for(Quote q : quotes)
		{
			totalFastK += calculateFastK(q, howManyPeriods);
		}
		
		fastD = totalFastK / (double)howManyTimes;
		
		return fastD;
	}
	
	public Double calculateSlowD(Quote quote, int howManyPeriods, int howManyTimes)
	{
		Double slowD = 0.0;
		
		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, howManyTimes);

		Double totalslowK = 0.0;
		for(Quote q : quotes)
		{
			totalslowK += calculateFastDOrSlowK(q, howManyPeriods, howManyTimes);
		}
		
		slowD = totalslowK / (double)howManyTimes;		
		
		
		
		return slowD;
	}
	
	
	
}
