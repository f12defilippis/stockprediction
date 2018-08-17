package it.f12.stockprediction.service.indicators;

import java.util.List;

import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;
import it.f12.stockprediction.service.QuoteService;
import it.f12.stockprediction.util.MathUtil;

@Service
public class BollingerBandService {

	@Autowired
	private QuoteService quoteService;
	
	
	public Double calculateMiddleBand(Quote quote, int howManyDays)
	{

		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, howManyDays);
		
		List<Double> list = quoteService.getValues(quotes);
		Double avg = MathUtil.average(list);		
		return avg;
	}
	
	
	public Double calculateUpperBand(Quote quote, int howManyDays)
	{
		return calculateBand(quote, "u", howManyDays);
	}

	public Double calculateLowerBand(Quote quote, int howManyDays)
	{
		return calculateBand(quote, "l", howManyDays);
	}
	
	public Double calculateBandWidth(Quote quote, int howManyDays)
	{
		Double bw = ( (calculateUpperBand(quote, howManyDays) - calculateLowerBand(quote, howManyDays)) / calculateMiddleBand(quote, howManyDays)) * 100.0;
		return bw;
	}
	
	public Double calculateBIndicator(Quote quote, int howManyDays)
	{
		Double b = (quote.getValue() - calculateLowerBand(quote, howManyDays))/(calculateUpperBand(quote, howManyDays) - calculateLowerBand(quote, howManyDays));
		return b;
	}
	
	private Double calculateBand(Quote quote, String ul, int howManyDays)
	{
		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, howManyDays);
		Double band = 0.0;
		
		StandardDeviation sd = new StandardDeviation();
		double stddev = sd.evaluate(quoteService.getValuesArray(quotes));
		if(ul.equals("u"))
			band = calculateMiddleBand(quote,howManyDays) + (stddev * 2);
		else
			band = calculateMiddleBand(quote,howManyDays) - (stddev * 2);
			
		return band;
	}

	
	
	
	
}
