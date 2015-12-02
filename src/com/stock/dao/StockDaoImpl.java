package com.stock.dao;

import java.util.HashMap;
import java.util.Map;

import com.stock.model.Stock;

public class StockDaoImpl implements IStockDao{

	private Map<String, Stock> stockList = new HashMap<String, Stock>();
	
	@Override
	public void saveStock(Stock stock) {
		stockList.put(stock.getSymbol(), stock);	
	}

	@Override
	public Stock getStock(String stockSymbol) {
		return stockList.get(stockSymbol);
	}
}
