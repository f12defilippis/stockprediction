package it.f12.stockprediction.service.indicators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.f12.stockprediction.entity.orm.Quote;
import it.f12.stockprediction.entity.to.AdxTO;
import it.f12.stockprediction.service.QuoteService;

@Service
public class ADXService {

	@Autowired
	private QuoteService quoteService;
	
	public Double calculate(Quote quote, int howManyDays)
	{
		Double adx = quoteService.getADX(quote);
		
		if(adx == null)
		{
			List<Quote> quotes = quoteService.getLastNQuotesUntilDateOfQuote(quote, howManyDays*2);
		
			if(quotes.size()<howManyDays*2)
			{
				return null;
			}

			double trhmd = 0.0, dmphmd = 0.0, dmmhmd = 0.0;
			
			
			List<AdxTO> listAdxTo = new ArrayList<AdxTO>();
			for(int i = 1; i < quotes.size() ; i++)
			{
				AdxTO to = new AdxTO();
				
				to.setTrOne(calculateTROne(quotes.get(i), quotes.get(i-1)));

				to.setDmPlusOne(calculateDMOnePlus(quotes.get(i), quotes.get(i-1)));

				to.setDmMinusOne(calculateDMOneMinus(quotes.get(i), quotes.get(i-1)));
				
				if(i<howManyDays)
				{
					trhmd += calculateTROne(quotes.get(i), quotes.get(i-1));
					dmphmd += calculateDMOnePlus(quotes.get(i), quotes.get(i-1));
					dmmhmd += calculateDMOneMinus(quotes.get(i), quotes.get(i-1));
				}else 
				{ 
					if(i==howManyDays)
					{
						to.setTrHMD(trhmd);
						to.setDmPlusHMD(dmphmd);
						to.setDmMinusHMD(dmmhmd);
					}else
					{
						to.setTrHMD(calculateTRorDMHMD(listAdxTo.get(listAdxTo.size()-1).getTrHMD(), to.getTrOne(), howManyDays));
						to.setDmPlusHMD(calculateTRorDMHMD(listAdxTo.get(listAdxTo.size()-1).getDmPlusHMD(), to.getDmPlusOne(), howManyDays));
						to.setDmMinusHMD(calculateTRorDMHMD(listAdxTo.get(listAdxTo.size()-1).getDmMinusHMD(), to.getDmMinusOne(), howManyDays));
					}
					
					to.setDiPlusHMD( 100.0 * to.getDmPlusHMD() / to.getTrHMD() );
					to.setDiMinusHMD( 100.0 * to.getDmMinusHMD() / to.getTrHMD() );

					to.setDiDiffHMD( Math.abs(to.getDiPlusHMD() - to.getDiMinusHMD()) );
					to.setDiSumHMD( to.getDiPlusHMD() - to.getDiMinusHMD() );
					
					to.setDx( 100.0 * to.getDiDiffHMD() / to.getDiSumHMD() );
					
					if(i==howManyDays*2)
					{
						adx = 0.0;
						for(int j = howManyDays * 2 - 2 ; j > howManyDays * 2 - 2 - howManyDays ; j--)
						{
							adx += listAdxTo.get(j).getDx();
						}
						to.setAdx(adx);
					}
					
				}
			}
		}

		return adx;
	}

	private Double calculateTROne(Quote today, Quote yesterday)
	{
		Double tr = today.getMaxValue()-today.getMinValue();
		
		Double highClose = Math.abs(today.getMaxValue()-yesterday.getValue());
		Double lowClose = Math.abs(today.getMinValue()-yesterday.getValue());
		
		tr = highClose > tr ? (lowClose > highClose ? lowClose : highClose) : tr;
		
		return tr;
	}
	
	private Double calculateDMOnePlus(Quote today, Quote yesterday)
	{
		Double dmOnePlus = 0.0;
		
		if(today.getMaxValue() - yesterday.getMaxValue() > yesterday.getMinValue() - today.getMinValue())
		{
			dmOnePlus = today.getMaxValue() - yesterday.getMaxValue() > 0 ? today.getMaxValue() - yesterday.getMaxValue() : 0.0;
		}
		
		return dmOnePlus;
	}
	
	private Double calculateDMOneMinus(Quote today, Quote yesterday)
	{
		Double dmOneMinus = 0.0;
		
		if(today.getMaxValue() - yesterday.getMaxValue() < yesterday.getMinValue() - today.getMinValue())
		{
			dmOneMinus = yesterday.getMinValue() - today.getMinValue() > 0 ? yesterday.getMinValue() - today.getMinValue() : 0.0;
		}
		
		return dmOneMinus;
	}

	private Double calculateTRorDMHMD(Double yesterdayTRHMD, Double trOne, int howMayDays)
	{
		Double trHMD = yesterdayTRHMD - ( yesterdayTRHMD / (double)howMayDays ) + trOne;
		
		return trHMD;
	}
	
	
}
