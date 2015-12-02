package com.stock.services;

import java.util.ArrayList;
import java.util.List;

import com.stock.dao.IStockDao;
import com.stock.dao.ITradeDao;
import com.stock.dao.StockDaoImpl;
import com.stock.dao.TradeDaoImpl;
import com.stock.factory.StockFactory;
import com.stock.factory.TradeFactory;
import com.stock.model.Stock;
import com.stock.model.Trade;
import com.stock.util.StockType;
import com.stock.util.TransactionType;

public abstract class AbstractStockCalculationTest {
	
	protected ITradeDao tradeDao = null;
	protected IStockDao stockDao = null;	
	protected List<Stock> stockList = null;
	
	public AbstractStockCalculationTest() {
		stockDao = new StockDaoImpl();	
		tradeDao = new TradeDaoImpl();
		stockList = new ArrayList<Stock>();
		initStock();
		initTrade();
	}
	
	/*
	 * Method to create stocks using Sample Data from Global Beverage Corporation Exchange (Table 1)
	 * Ticker Price has been assumed as it was not given in the table 
	 */
	private void initStock() {
		stockList.add(StockFactory.createStock(0, 0, 100, "TEA", StockType.COMMON, 101));
		stockList.add(StockFactory.createStock(0, 8, 100, "POP", StockType.COMMON, 110));
		stockList.add(StockFactory.createStock(0, 23, 60, "ALE", StockType.COMMON, 59));
		stockList.add(StockFactory.createStock(2, 8, 100, "GIN", StockType.PREFERRED, 106));
		stockList.add(StockFactory.createStock(0, 13, 250, "JOE", StockType.COMMON, 262));
		stockList.add(StockFactory.createStock(0, 0, 0, "INV", StockType.COMMON, 0));
				
		for(Stock stock : stockList){
			stockDao.saveStock(stock);
		}
	}
	
	/*
	 * Method to create Trades
	 */
	private void initTrade(){
		List<Trade> tradeList = new ArrayList<>();
		tradeList.add(TradeFactory.createTrade(50, TransactionType.SELL, 1000.0, stockDao.getStock("ALE")));
		tradeList.add(TradeFactory.createTrade(20, TransactionType.BUY, 200.0, stockDao.getStock("TEA")));
		tradeList.add(TradeFactory.createTrade(100, TransactionType.SELL, 10005.50, stockDao.getStock("POP")));
		tradeList.add(TradeFactory.createTrade(80, TransactionType.BUY, 6486.0, stockDao.getStock("ALE")));
		tradeList.add(TradeFactory.createTrade(45, TransactionType.SELL, 4000.40, stockDao.getStock("JOE")));
		tradeList.add(TradeFactory.createTrade(125, TransactionType.SELL, 45294.0, stockDao.getStock("GIN")));
		
		for(Trade trade : tradeList){
			tradeDao.saveTrade(trade);
		}
	}

}
