package it.f12.stockprediction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;

@Service
public class ADLService {

	@Autowired
	private QuoteService quoteService;
	
	
	public Double calculate(Quote quote)
	{
		Double adl = quoteService.getADL(quote);

		if(adl==null)
		{
			Double moneyFlowMultiplier = ((quote.getValue()  -  quote.getMinValue()) - (quote.getMaxValue() - quote.getValue())) /(quote.getMaxValue() - quote.getMinValue());
			Double moneyFlowVolume = moneyFlowMultiplier * quote.getVolume();
			
			Double yesterdayAdl = calculate(quoteService.getLastNQuotesUntilDateOfQuote(quote, 2).get(0));
			
			adl = yesterdayAdl + moneyFlowVolume;
		}
		
		return adl;
	}
	
	
}
