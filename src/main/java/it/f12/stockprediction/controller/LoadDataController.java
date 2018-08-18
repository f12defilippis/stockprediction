package it.f12.stockprediction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.f12.stockprediction.entity.orm.Quote;
import it.f12.stockprediction.entity.repository.QuoteRepository;
import it.f12.stockprediction.entity.to.QuoteCsvTO;
import it.f12.stockprediction.service.CsvService;
import it.f12.stockprediction.service.strategies.StochasticPopDropStrategyService;

@Controller
public class LoadDataController {

	@Autowired
	private CsvService csvService;
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	@Autowired
	private StochasticPopDropStrategyService stochasticPopDropStrategyService;
	
	
	@RequestMapping("/load-quote")
	public String loadGeographicalTargeting()
	{
		
		List<QuoteCsvTO> quotesTO = csvService.parseQuoteCsv("stocksdata/acn.us.txt");

		Integer howMany = csvService.loadData(quotesTO);

		
		return String.valueOf(howMany);
	}
	
	@RequestMapping("/checkpop")
	public String checkPopDrop()
	{
		
		List<Quote> quotes = (List<Quote>) quoteRepository.findAll();
		

		for(int i = 100 ; i < quotes.size() ; i++)
		{
			stochasticPopDropStrategyService.check(quotes.get(i));
		}
		
		
		
		return String.valueOf(quotes.size());
	}

	
	
}
