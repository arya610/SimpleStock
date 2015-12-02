package com.stock.services;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.stock.dao.ITradeDao;
import com.stock.model.Trade;

public class TradeRecordCalculateStockPriceServiceImpl implements TradeRecordCalculateStockPriceServiceI{
	
	private ITradeDao tradeDao = null;
	
	public TradeRecordCalculateStockPriceServiceImpl(ITradeDao tradeDao) {
		this.tradeDao = tradeDao;		
	}
	
	@Override
	public void recordTrade(Trade trade) {
		tradeDao.saveTrade(trade);		
	}
	
	private double calculateStockPriceForGivenStockForLast15Mins(String symbol){
		Calendar now = Calendar.getInstance();
		Date currentTime = now.getTime();
		double stockPriceSum = 0.0;
		long totalNumberOfShares = 0;
	
		for(Trade t : tradeDao.getAllTradesPerStock().get(symbol)){
			if(TimeUnit.MINUTES.toMinutes(currentTime.getTime() - t.getTimeStamp().getTime()) <= 15*60*1000){
				stockPriceSum += t.getNumberOfShares() * t.getPrice();
				totalNumberOfShares += t.getNumberOfShares();
			}
		}	
		
		if(totalNumberOfShares == 0){
			return 0;
		}
		return stockPriceSum/totalNumberOfShares;
	}

	/**
	 * Method to calculate stock price for all stocks traded in last 15 mins.
	 * Please note to simplify, it would ignore stocks which hasn't traded in last 15 mins.
	 */
	@Override
	public Map<String,Double> calculateStockPriceForAllStocksForLast15Mins() {
		
		Map<String,Double> priceForAllStocks = new HashMap<String,Double>(); 
			
		for (String stockName: tradeDao.getAllTradesPerStock().keySet()) {
			double stockPrice = calculateStockPriceForGivenStockForLast15Mins(stockName);
			if (stockPrice > 0){				
				priceForAllStocks.put(stockName, stockPrice);
			}
		}
		return priceForAllStocks;
	}	
}
