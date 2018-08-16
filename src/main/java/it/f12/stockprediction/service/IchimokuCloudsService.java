package it.f12.stockprediction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.f12.stockprediction.orm.entity.Quote;

@Service
public class IchimokuCloudsService {

	private QuoteService quoteService;
	
	public Double calculateConversionLine(Quote quote)
	{
		return calculateLine(quote, 9);
	}

	public Double calculateBaseLine(Quote quote)
	{
		return calculateLine(quote, 26);
	}
	
	public Double calculateLeadingSpanB(Quote quote)
	{
		return calculateLine(quote, 52);
	}
	
	public Double calculateLeadingSpanA(Quote quote)
	{
		return (calculateConversionLine(quote) + calculateBaseLine(quote))/2.0;
	}
	
	private Double calculateLine(Quote quote, int numDays)
	{
		Double conversionLine = 0.0;
		
		List<Quote> list = quoteService.getLastNQuotesUntilDateOfQuote(quote, numDays);
		
		Double max = quoteService.getMaxofMaxValues(list);
		Double min = quoteService.getMinofMinValues(list);

		conversionLine = (max+min)/2.0;
		
		return conversionLine;
	}
	
	
	
	
}
