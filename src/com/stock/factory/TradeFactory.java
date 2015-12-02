package com.stock.factory;

import java.util.Calendar;
import java.util.UUID;

import com.stock.model.Stock;
import com.stock.model.Trade;
import com.stock.util.TransactionType;

public class TradeFactory {
	
	private TradeFactory(){		
	}
	
	/*
	 * Method used to record Trades using Factory Design Pattern
	 */
	public static Trade createTrade(long numberOfShares, TransactionType buySellIndicator, Double price, Stock stock) {
		Trade trade = new Trade();
		UUID id = UUID.randomUUID();
		trade.setId(id); 
		Calendar now = Calendar.getInstance();
		trade.setTimeStamp(now.getTime());
		trade.setNumberOfShares(numberOfShares);
		trade.setBuySellIndicator(buySellIndicator);
		trade.setPrice(price);
		trade.setStock(stock);
		return trade;
	}
}
