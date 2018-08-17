package it.f12.stockprediction.service.indicators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;
import it.f12.stockprediction.service.QuoteService;

@Service
public class AroonService {

	@Autowired
	private QuoteService quoteService;
	
	public Double calculateUp(Quote quote)
	{
		return calculate(quote, "u");
	}
	
	public Double calculateDown(Quote quote)
	{
		return calculate(quote, "d");
	}
	
	public Double calculateOscillator(Quote quote)
	{
		return calculate(quote, "u") - calculate(quote, "d");
	}	

	public Double calculate(Quote quote, String updown)
	{
		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, 25);
		
		Integer maxIndex = quoteService.getIndexMaxofMaxValues(quotes);
		Integer minIndex = quoteService.getIndexMinofMinValues(quotes);
		
		Integer daysSince = updown.equals("u") ? quotes.size()-1-maxIndex : quotes.size()-1-minIndex;

		
		Double aroon = ((25.0 - (double)daysSince) / 25.0) * 100;
		
		
		return aroon;
		
		
	}
	
	
	
	
}
