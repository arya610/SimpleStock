package com.stock.dao;

import com.stock.model.Stock;

public interface IStockDao {
	/*
	 * Method to save stocks
	 */
	public void saveStock(Stock stock);	
	
	/*
	 * Method to return saved stocks
	 */
	public Stock getStock(String stockSymbol);		
}
