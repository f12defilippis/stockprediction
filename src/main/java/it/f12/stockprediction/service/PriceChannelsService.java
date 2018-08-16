package it.f12.stockprediction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;

@Service
public class PriceChannelsService {

	@Autowired
	private QuoteService quoteService;
	
	
	public Double calculateCenterLine(Quote quote, int howManyDays)
	{
		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, howManyDays);
		
		return (quoteService.getMaxofMaxValues(quotes) + quoteService.getMinofMinValues(quotes)) / 2.0;
	}

	public Double calculateUpperLine(Quote quote, int howManyDays)
	{
		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, howManyDays);
		
		return quoteService.getMaxofMaxValues(quotes);
	}
	
	public Double calculateLowerLine(Quote quote, int howManyDays)
	{
		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, howManyDays);
		
		return quoteService.getMinofMinValues(quotes);
	}	
	
}
