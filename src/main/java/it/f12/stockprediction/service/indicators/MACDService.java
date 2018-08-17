package it.f12.stockprediction.service.indicators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;
import it.f12.stockprediction.service.QuoteService;

@Service
public class MACDService {

	@Autowired
	private QuoteService quoteService;
	
	@Autowired
	private MovingAverageService movingAverageService;
	
	public Double calculate(Quote quote, int lineLowPeriods, int lineHighPeriods, int signalLinePeriods)
	{
		Double macd = 0.0;

		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, signalLinePeriods*2);
		
		List<Double> macdLines = new ArrayList<Double>();

		for(Quote q : quotes)
		{
			macdLines.add(calculateMacdLine(q, lineLowPeriods, lineHighPeriods));
		}
		
		Double signalLine = calculateEMA(macdLines, signalLinePeriods);

		macd = macdLines.get(macdLines.size()-1) - signalLine;
		
		return macd;
	}

	
	private Double calculateEMA(List<Double> macdLines, int howManyPeriods)
	{
		Double ema = 0.0;
		if(macdLines.size() > howManyPeriods)
		{
			Double multiplier = new Double(2) / (new Double(howManyPeriods) + 1.0);

			List<Double> macdLinesUntilYeserday = macdLines.subList(0, macdLines.size()-2);
			
			Double emaYesterday = calculateEMA(macdLinesUntilYeserday, howManyPeriods);
			
			ema = multiplier * (macdLines.get(macdLines.size()-1) - emaYesterday) + emaYesterday;
		
		} else 
		{
			ema = calculateSMA(macdLines, howManyPeriods);
		}
		
		return ema;
	}	
	
	private Double calculateSMA(List<Double> macdLines, int howManyPeriods)
	{
		
		Double sma = 0.0;
		Double sum = 0.0;
		
		
		for(Double q : macdLines)
		{
			sum += q;
		}

		sma = sum / new Double(howManyPeriods);
		
		
		return sma;
	}	
	
	
	
	private Double calculateMacdLine(Quote quote, int lineLowPeriods, int lineHighPeriods)
	{
		Double macdLine = movingAverageService.calculateEMA(quote, lineLowPeriods) - movingAverageService.calculateEMA(quote, lineHighPeriods);
		
		return macdLine;
	}
	
	
	
}
