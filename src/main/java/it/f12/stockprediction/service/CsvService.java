package it.f12.stockprediction.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import it.f12.stockprediction.entity.orm.Quote;
import it.f12.stockprediction.entity.orm.Stock;
import it.f12.stockprediction.entity.orm.Timeframe;
import it.f12.stockprediction.entity.repository.QuoteRepository;
import it.f12.stockprediction.entity.to.QuoteCsvTO;
import it.f12.stockprediction.util.DateUtil;

@Service
public class CsvService {

	@Autowired
	private QuoteRepository quoteRepository;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<QuoteCsvTO> parseQuoteCsv(String url)
	{
		InputStream in = this.getClass().getClassLoader()
                .getResourceAsStream(url);
		CSVReader reader = new CSVReader(new BufferedReader(new InputStreamReader(in)));
		ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
		strat.setType(QuoteCsvTO.class);
		String[] columns = new String[] {"date", "open", "high", "low", "close", "volume", "openInt"}; // the fields to bind do in your JavaBean
//Date,Open,High,Low,Close,Volume,OpenInt
		
		strat.setColumnMapping(columns);

		CsvToBean csv = new CsvToBean();
		List<QuoteCsvTO> list = csv.parse(strat, reader);
		return list;
	}
	
	@Transactional
	public Integer loadData(List<QuoteCsvTO> quotesTO)
	{

		for(QuoteCsvTO to : quotesTO)
		{
			Quote quote = new Quote();
			
			quote.setDateOfQuote( DateUtil.format(to.getDate()) );
			quote.setValue( new Double(to.getClose()) );
			quote.setMaxValue( new Double(to.getHigh()) );
			quote.setMinValue( new Double(to.getLow()) );
			quote.setOpenValue( new Double(to.getOpen()) );
			quote.setVolume( new Double(to.getVolume()) );
			quote.setTimeframe(new Timeframe(1));
			
			quote.setStock(new Stock(1));
			
			quoteRepository.save(quote);

			System.out.println("Quote Saved for date: " + to.getDate());
		 
		
		}
		
		return quotesTO.size();		
		
	}
	
	
	
	
}
