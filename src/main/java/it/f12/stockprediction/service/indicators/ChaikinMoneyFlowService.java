package it.f12.stockprediction.service.indicators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;
import it.f12.stockprediction.service.QuoteService;

@Service
public class ChaikinMoneyFlowService {

	@Autowired
	private QuoteService quoteService;
	
	public Double calculate(Quote quote, int howManyDays)
	{
		Double cmf = 0.0;
		
		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, howManyDays);
		
		Double totalMoneyFlowVolume = 0.0;
		Double totalVolume = 0.0;
		
		
		for(Quote q : quotes)
		{
			totalMoneyFlowVolume += calculateMoneyFlowVolume(quote);
			totalVolume += quote.getVolume();
		}
		
		cmf = totalMoneyFlowVolume / totalVolume;
		
		return cmf;
	}
	
	
	private Double calculateMoneyFlowVolume(Quote quote)
	{
		Double moneyFLowMultiplier = ((quote.getValue()  -  quote.getMinValue()) - (quote.getMaxValue() - quote.getValue())) /(quote.getMaxValue() - quote.getMinValue()); 
		
		return moneyFLowMultiplier * quote.getVolume();
	}
	
}
