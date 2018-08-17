package it.f12.stockprediction.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import it.f12.stockprediction.entity.to.QuoteCsvTO;

@Service
public class CsvService {

	
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
	
	
}
