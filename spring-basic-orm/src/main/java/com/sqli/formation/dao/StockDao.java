package com.sqli.formation.dao;

import com.sqli.formation.model.Stock;

public interface StockDao {
	
	void save(Stock stock);
	
	void update(Stock stock);
	
	void delete(Stock stock);
	
	Stock findByStockCode(String stockCode);

}
