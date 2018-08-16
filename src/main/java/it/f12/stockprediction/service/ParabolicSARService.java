package it.f12.stockprediction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;

@Service
public class ParabolicSARService {

	@Autowired
	private QuoteService quoteService;
	
	public Double calculateRising(Quote quote, int howManyDays)
	{
		return calculate(quote, howManyDays, "r");
	}
	
	public Double calculateFalling(Quote quote, int howManyDays)
	{
		return calculate(quote, howManyDays, "f");
	}
	
	
	
	private Double calculate(Quote quote, int howManyDays, String risingFalling)
	{
		Double sar = quoteService.getSAR(quote,risingFalling);

		if(sar == null)
		{
			List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, howManyDays);
			EpObject epo = new EpObject();
			for(Quote q : quotes)
			{
				EpObject epoInternal = new EpObject();
				epoInternal = calculateEP(quote, howManyDays);
				if(epoInternal.ep > epo.ep)
				{
					epo.ep = epoInternal.ep;
					epo.af = epo.af < 0.2 ? epo.af + 0.02 : epo.af;
				}
			}

			Quote yesterdayQuote = quotes.get(quotes.size()-2);
			EpObject epoYesterday = calculateEP(yesterdayQuote, howManyDays);
			
			Double yesterdaySAR = calculate(yesterdayQuote, howManyDays, risingFalling);

			if(risingFalling.equals("r"))
			{
				sar = yesterdaySAR + epoYesterday.af * (epoYesterday.ep - yesterdaySAR);
			}else
			{
				sar = yesterdaySAR - epoYesterday.af * (epoYesterday.ep - yesterdaySAR);
			}

			
		}
		
		return sar;
	}
	
	private EpObject calculateEP(Quote quote, int howManyDays)
	{
		EpObject epo = new EpObject();
		
		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, howManyDays);
		
		Double max = 0.0;
		for(Quote q : quotes)
		{
			if(q.getMaxValue() > epo.ep)
			{
				epo.ep = q.getMaxValue();
				epo.af = epo.af < 0.2 ? epo.af + 0.02 : epo.af;
			}
		}		
		
		return epo;
	}
	
	
	private class EpObject
	{
		Double ep = 0.0;
		Double af = 0.02;
	}
	
}
