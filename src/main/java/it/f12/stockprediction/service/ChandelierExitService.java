package it.f12.stockprediction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;

@Service
public class ChandelierExitService {

	@Autowired
	private QuoteService quoteService;
	
	@Autowired
	private AverageTrueRangeService averageTrueRangeService;
	
	public Double calculateLong(Quote quote,  int numDays)
	{
		return calculate(quote, "l", numDays);
	}

	public Double calculateShort(Quote quote,  int numDays)
	{
		return calculate(quote, "s", numDays);
	}

	
	private Double calculate(Quote quote, String longShort, int numDays)
	{
		
		Double exit = 0.0;
		
		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, numDays);

		Double max = quoteService.getMaxofMaxValues(quotes);
		
		Double atr = averageTrueRangeService.calculate(quote, numDays);
				
		if(longShort.equals("l"))
		{
			exit = max - (atr*3);
		}else
		{
			exit = max + (atr*3);
		}
		
		
		return exit;
		
	}
	
	
	
	
}
