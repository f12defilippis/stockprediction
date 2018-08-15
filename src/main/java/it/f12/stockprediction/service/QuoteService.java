package it.f12.stockprediction.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import it.f12.stockprediction.orm.entity.Quote;

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
	
	//TODO return the last howManyDays quotes
	public List<Quote> getLastNQuotesUntilDate(Date date, int howManyDays)
	{
		return null;
	}
	
	
	
	
}
