package it.f12.stockprediction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.f12.stockprediction.orm.entity.Quote;

@Service
public class MovingAverageService {

	private QuoteService quoteService;
	
	
	public Double calculateSMA(Quote quote, int howManyDays)
	{
		
		Double sma = 0.0;
		Double sum = 0.0;
		
		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, howManyDays);
		
		for(Quote q : quotes)
		{
			sum += q.getValue();
		}

		sma = sum / new Double(howManyDays);
		
		
		return sma;
	}

	
	public Double calculateEMA(Quote quote, int howManyDays)
	{
		Double ema = quoteService.getEma(quote);
		
		if(ema == null)
		{
			Double multiplier = new Double(2) / (new Double(howManyDays) + 1.0);
			Quote yesterdayQuote = quoteService.getLastNQuotesUntilDateOfQuote(quote, 2).get(0);
			
			Double emaYesterday = calculateEMA(yesterdayQuote, howManyDays);
			
			ema = multiplier * (quote.getValue() - emaYesterday) + emaYesterday;
		}
		
		return ema;
	}
	
	
	
}
