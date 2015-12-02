package com.stock.services;

import java.util.Map;

import com.stock.model.Trade;

public interface TradeRecordCalculateStockPriceServiceI {

	/*
	 * Method to record Trade
	 */
	public void recordTrade(Trade trade);
	
	/*
	 * Method to calculated stock prices based on trades in last 15 minutes
	 */
	public Map<String,Double> calculateStockPriceForAllStocksForLast15Mins();
}
