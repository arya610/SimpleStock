package com.stock.factory;

import com.stock.model.Stock;
import com.stock.util.StockType;

public class StockFactory {
	
	private StockFactory(){		
	}
	
	/*
	 * Method used to create stocks using Factory Design Pattern
	 */
	public static Stock createStock(float fixedDividend, double lastDividend, double parValue, String symbol, StockType type, double tickerPrice) {
		Stock stock = new Stock();
		stock.setFixedDividend(fixedDividend);
		stock.setLastDividend(lastDividend);
		stock.setParValue(parValue);
		stock.setSymbol(symbol);
		stock.setType(type);
		stock.setTickerPrice(tickerPrice);
		return stock;
	}
}
