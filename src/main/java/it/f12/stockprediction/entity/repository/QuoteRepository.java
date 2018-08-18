package it.f12.stockprediction.entity.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.f12.stockprediction.entity.orm.Quote;
import it.f12.stockprediction.entity.orm.Stock;

public interface QuoteRepository extends CrudRepository<Quote, Integer>{

	
	@Query(nativeQuery = true,
            value = "SELECT * FROM Quote a WHERE a.date_of_quote <= :d and a.stock = :pstock ORDER BY a.date_of_quote desc limit :howMany")
	List<Quote> getLastNQuotesUntilDateOfQuote(Date d, Stock pstock, Integer howMany);
	
	
	
}
