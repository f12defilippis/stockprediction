package it.f12.stockprediction.service.indicators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

import it.f12.stockprediction.entity.orm.Quote;
import it.f12.stockprediction.entity.to.VolumeByPriceTO;
import it.f12.stockprediction.service.QuoteService;

@Service
public class VolumeByPriceService {

	@Autowired
	private QuoteService quoteService;
	
	
	public RangeMap<Double, VolumeByPriceTO> calculate(Quote quote, int howManyDays, int howManyRanges)
	{
		List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, howManyDays);
		
		Double maxValue = quoteService.getMaxofQuoteValues(quotes);
		Double minValue = quoteService.getMinofQuoteValues(quotes);
		Double rangeSize = (maxValue - minValue) / (double)howManyRanges;

		RangeMap<Double, VolumeByPriceTO> map = TreeRangeMap.create();
		
		for(int i = 1; i <= howManyRanges ; i++)
		{
			map.put(Range.closed(minValue*(double)i, minValue*(double)i+rangeSize), new VolumeByPriceTO());
		}
		
		for(int j = quotes.size()-1 ; j > 0 ; j--)
		{
			if(quotes.get(j).getValue() >= quotes.get(j-1).getValue())
			{
				map.get(quotes.get(j).getValue()).increase(quotes.get(j).getVolume());
			}else
			{
				map.get(quotes.get(j).getValue()).decrease(quotes.get(j).getVolume());
			}
		}
		
		return map;
	}
	
	
}
