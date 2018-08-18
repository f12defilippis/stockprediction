package it.f12.stockprediction.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;
import it.f12.stockprediction.entity.repository.QuoteRepository;

@Service
public class QuoteService {

	@Autowired
	private QuoteRepository quoteRepository;
	
	
	public List<Double> getValues(List<Quote> quotes)
	{
		List<Double> list = new ArrayList<Double>();
		for(Quote quote : quotes)
		{
			list.add(quote.getValue());
		}
		return list;
		
	}
	
	public double[] getValuesArray(List<Quote> quotes)
	{
		double[] list = new double[quotes.size()];
		for(int i = 0 ; i< quotes.size() ; i++)
		{
			list[i] = quotes.get(i).getValue();
		}
		return list;
		
	}
	
	public Double getMaxofMaxValues(List<Quote> quotes)
	{

		Double max = 0.0;
		
		for(Quote quote : quotes)
		{
			max = quote.getMaxValue() > max ? quote.getMaxValue() : max;
		}
		
		return max;
		
	}
	
	public Integer getIndexMaxofMaxValues(List<Quote> quotes)
	{

		Integer maxIndex = 0;
		Double max = 0.0;
		
		for(int i = 0; i < quotes.size(); i++)
		{
			Quote quote = quotes.get(i);
			if(quote.getMaxValue() > max)
			{
				max = quote.getMaxValue();
				maxIndex = i;
			}
		}
		
		return maxIndex;
		
	}
	
	public Integer getIndexMinofMinValues(List<Quote> quotes)
	{

		Integer minIndex = 0;
		Double min = quotes.get(0).getMinValue();;
		
		for(int i = 0; i < quotes.size(); i++)
		{
			Quote quote = quotes.get(i);
			if(quote.getMaxValue() < min)
			{
				min = quote.getMaxValue();
				minIndex = i;
			}
		}
		
		return minIndex;
		
	}
	
	
	public Double getMaxofQuoteValues(List<Quote> quotes)
	{

		Double max = 0.0;
		
		for(Quote quote : quotes)
		{
			max = quote.getValue() > max ? quote.getValue() : max;
		}
		
		return max;
		
	}	
	
	
	public Double getMinofMinValues(List<Quote> quotes)
	{

		Double min = quotes.get(0).getMinValue();
		
		for(Quote quote : quotes)
		{
			min = quote.getMaxValue() < min ? quote.getMaxValue() : min;
		}
		
		return min;
		
	}
	
	public Double getMinofQuoteValues(List<Quote> quotes)
	{

		Double min = quotes.get(0).getValue();
		
		for(Quote quote : quotes)
		{
			min = quote.getValue() < min ? quote.getValue() : min;
		}
		
		return min;
		
	}
	
	//TODO return the last howManyDays quotes
	public List<Quote> getPreviousMonthQuotes(Quote quote)
	{
		return null;
	}	
	
	//TODO return the last howManyDays quotes
	public List<Quote> getLastNQuotesUntilDateOfQuote(Quote quote, int howMany)
	{
		List<Quote> quotes = quoteRepository.getLastNQuotesUntilDateOfQuote(quote.getDateOfQuote(), quote.getStock(), howMany);
		Collections.reverse(quotes);
		return quotes;
	}
	
	//TODO return the EMA
	public Double getEma(Quote quote)
	{
		return null;
	}
	
	//TODO return the Kama
	public Double getKama(Quote quote)
	{
		return null;
	}

	//TODO return the SAR
	public Double getSAR(Quote quote, String risingFalling)
	{
		return null;
	}
	
	//TODO return the ADL
	public Double getADL(Quote quote)
	{
		return null;
	}

	//TODO return the ADX
	public Double getADX(Quote quote) {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
}
