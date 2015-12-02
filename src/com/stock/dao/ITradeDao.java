package com.stock.dao;

import java.util.List;
import java.util.Map;

import com.stock.model.Trade;

public interface ITradeDao {
	/*
	 * Method to record Trade with timestamp, quantity of shares, buy/sell indicator and price
	 */
	public void saveTrade(Trade trade);	
	
	/*
	 * Method to fetch all Trades for a given stock 
	 */
	public Map<String, List<Trade>> getAllTradesPerStock();	
	
}
