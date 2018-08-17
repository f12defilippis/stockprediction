package it.f12.stockprediction.service.indicators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;
import it.f12.stockprediction.entity.to.PivotPointTO;
import it.f12.stockprediction.service.QuoteService;

@Service
public class PivotPointsService {

	@Autowired
	private QuoteService quoteService;
		
	public PivotPointTO calculate(Quote quote)
	{
		PivotPointTO ret = new PivotPointTO();

		List<Quote> quotes = quoteService.getPreviousMonthQuotes(quote);
		
		Double high = quoteService.getMaxofMaxValues(quotes);
		Double low = quoteService.getMinofMinValues(quotes);
		Double close = quotes.get(quotes.size()-1).getValue();
		
		Double pivotPoint = (high+low+close)/3.0;
		ret.setPivotPoint(pivotPoint);

		ret.setStandardSupport1((pivotPoint*2.0)-high);
		ret.setStandardSupport2(pivotPoint-(high-low));
		
		ret.setStandardResistance1((pivotPoint*2.0)-low);
		ret.setStandardResistance2(pivotPoint+(high-low));

		
		ret.setFibonacciResistance3(pivotPoint+(high-low));
		ret.setFibonacciSupport3(pivotPoint-(high-low));
		
		ret.setFibonacciResistance2( pivotPoint + (0.618 * (high-low)) );
		ret.setFibonacciSupport2( pivotPoint - (0.618 * (high-low)) );
		
		ret.setFibonacciResistance1( pivotPoint + (0.382 * (high-low)) );
		ret.setFibonacciSupport1( pivotPoint - (0.382 * (high-low)) );

		
		Double x = 0.0;
		
		if(quote.getValue() < quote.getOpenValue())
		{
			x = high + (2.0 * low) + close;
		}else if(quote.getValue() > quote.getOpenValue())
		{
			x = (2.0 * high) + low + close;
		}else
		{
			x = high + low + (2 * close);
		}
		
		ret.setDemarkPivotPoint(x/4.0);
		ret.setDemarkSupport( x/2.0 - high );
		ret.setDemarkResistance( x/2.0 - low );
		
		return ret;
	}
	
	
}
