package it.f12.stockprediction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;

@Service
public class KamaService {

	private QuoteService quoteService;
	
	
	public Double calculate(Quote quote)
	{
		Double kama = quoteService.getKama(quote);
		
		if(kama == null)
		{
			//Efficent Ratio
			Double er = calculateChange(quote) / calculateVolatility(quote);
			
			Double multiplierF = new Double(2) / (new Double(2) + 1.0);
			Double multiplierS = new Double(2) / (new Double(2) + 1.0);

			Double scToPower = er * (multiplierF-multiplierS) + multiplierS;
			Double sc =  Math.pow(scToPower, 2.0);
			
			Quote yesterdayQuote = quoteService.getLastNQuotesUntilDateOfQuote(quote, 2).get(0);

			if(yesterdayQuote!=null)
			{
				Double yesterdayKama = calculate(yesterdayQuote);
				kama = yesterdayKama + sc * (quote.getValue() - yesterdayKama);
			}else
			{
				kama = quote.getValue();
			}
			
		}
		
		return kama;
	}
	
	private Double calculateChange(Quote quote)
	{
		Double change = 0.0;
		
		Quote quote10ago = quoteService.getLastNQuotesUntilDateOfQuote(quote, 10).get(0);

		change = Math.abs(quote.getValue() - quote10ago.getValue());
		
		return change;
	}
	
	
	private Double calculateVolatility(Quote quote)
	{
		Double volatility = 0.0;
		
		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, 11);
		
		for(int i = quotes.size()-1 ; i>0 ; i--)
		{
			Double change = quotes.get(i).getValue() - quotes.get(i-1).getValue();
			volatility += Math.abs(change);
		}
		
		return volatility;
	}
	
	
	
}
