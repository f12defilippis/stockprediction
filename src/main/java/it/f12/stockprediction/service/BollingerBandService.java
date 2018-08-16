package it.f12.stockprediction.service;

import java.util.List;

import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;
import it.f12.stockprediction.util.MathUtil;

@Service
public class BollingerBandService {

	@Autowired
	private QuoteService quoteService;
	
	
	public Double calculateMiddleBand(List<Quote> quotes)
	{
		
		List<Double> list = quoteService.getValues(quotes);
		
		Double avg = MathUtil.average(list);		
		return avg;
	}

	


	
	
	
	public Double calculateUpperBand(List<Quote> quotes)
	{
		return calculateBand(quotes, "u");
	}

	public Double calculateLowerBand(List<Quote> quotes)
	{
		return calculateBand(quotes, "l");
	}
	
	
	
	private Double calculateBand(List<Quote> quotes, String ul)
	{
		Double band = 0.0;
		
		StandardDeviation sd = new StandardDeviation();
		double stddev = sd.evaluate(quoteService.getValuesArray(quotes));
		if(ul.equals("u"))
			band = calculateMiddleBand(quotes) + (stddev * 2);
		else
			band = calculateMiddleBand(quotes) - (stddev * 2);
			
		return band;
	}

	
	
	
	
}
