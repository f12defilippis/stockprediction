package it.f12.stockprediction.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;

@Service
public class QuoteService {

	
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
	public List<Quote> getLastNQuotesUntilDateOfQuote(Quote quote, int howManyDays)
	{
		return null;
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
	
	
	
	
}
