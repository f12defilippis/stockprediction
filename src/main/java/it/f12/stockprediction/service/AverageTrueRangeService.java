package it.f12.stockprediction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.orm.entity.Quote;

@Service
public class AverageTrueRangeService {

	@Autowired
	private QuoteService quoteService; 
	
	
	public Double calculate(Quote quote, int howManyDays)
	{
		Double atr = 0.0;

		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, howManyDays);

		double [] trueRanges = new double[quotes.size()];

		trueRanges[0] = calculateTrueRange(quotes.get(0),null);
		
		for(int i = 1 ; i < quotes.size() ; i++)
		{
			trueRanges[i] = calculateTrueRange(quotes.get(i), quotes.get(i-1));
		}

		double sum = 0.0;
		for(int i = 0; i<trueRanges.length ; i++)
		{
			sum += trueRanges[i];
		}
		atr = sum / trueRanges.length;
		
		return atr;
	}

	
	private Double calculateTrueRange(Quote today, Quote yesterday)
	{
		Double trueRange = 0.0;
		double highMinusLow = Math.abs(today.getMaxValue()-today.getMinValue());
		if(yesterday!=null)
		{
			double highTMinusCloseY = Math.abs(today.getMaxValue()-yesterday.getValue());
			double lowTMinusCloseY = Math.abs(today.getMinValue()-yesterday.getValue());
			
			trueRange = highMinusLow >= highTMinusCloseY ? highMinusLow : highTMinusCloseY;
			trueRange = lowTMinusCloseY > trueRange ? lowTMinusCloseY : trueRange;
		}else
		{
			trueRange = highMinusLow;
		}
		
		return trueRange;
	}
	
	
	
	
}
