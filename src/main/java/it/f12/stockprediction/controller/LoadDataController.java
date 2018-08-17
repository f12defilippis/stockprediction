package it.f12.stockprediction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.f12.stockprediction.entity.orm.Quote;
import it.f12.stockprediction.entity.orm.Stock;
import it.f12.stockprediction.entity.repository.QuoteRepository;
import it.f12.stockprediction.entity.to.QuoteCsvTO;
import it.f12.stockprediction.service.CsvService;
import it.f12.stockprediction.util.DateUtil;

@Controller
public class LoadDataController {

	@Autowired
	private CsvService csvService;
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	
	
	@RequestMapping("/load-quote")
	public String loadGeographicalTargeting()
	{
		
		List<QuoteCsvTO> quotesTO = csvService.parseQuoteCsv("stocksdata/acn.us.txt");

		for(QuoteCsvTO to : quotesTO)
		{
			Quote quote = new Quote();
			
			quote.setDateOfQuote( DateUtil.format(to.getDate()) );
			quote.setValue( new Double(to.getClose()) );
			quote.setMaxValue( new Double(to.getHigh()) );
			quote.setMinValue( new Double(to.getLow()) );
			quote.setOpenValue( new Double(to.getOpen()) );
			quote.setVolume( new Double(to.getVolume()) );
			
			quote.setStock(new Stock(1));
			
			quoteRepository.save(quote);
		}
		
		return "OK";
	}
	
	
}
