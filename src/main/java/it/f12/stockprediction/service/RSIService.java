package it.f12.stockprediction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;

@Service
public class RSIService {

	@Autowired
	private QuoteService quoteService;
	
	
	public Double calculate(Quote quote, int howManyPeriods)
	{
		Double rsi = 0.0;
		
		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, howManyPeriods+1);

		if(quotes.size()<howManyPeriods+1)
			return null;
		
		Double sumLoss = 0.0;
		Double sumGain = 0.0;
		
		for(int i = 1 ; i < quotes.size()-1 ; i++)
		{
			Double todayValue = quotes.get(i).getValue();
			Double yesterdayValue = quotes.get(i-1).getValue();
			
			if(todayValue>yesterdayValue)
			{
				sumGain += todayValue - yesterdayValue;
			}else
			{
				sumLoss += yesterdayValue - todayValue;
			}
			
		}
		
		Double avgLoss = sumLoss / (double)howManyPeriods;
		Double avgGain = sumGain / (double)howManyPeriods;
		
		Double rs = avgGain / avgLoss;

		rsi = avgLoss == 0.0 ? 100 : 100.0 - ( 100.0 / (1.0 + rs ) );
		
		return rsi;
	}
	
	
	
}
