package com.stock.services;

import com.stock.dao.IStockDao;
import com.stock.model.Stock;
import com.stock.util.StockType;

public class CalculateDividendPERatioServiceImpl implements CalculateDividendPERatioServiceI{
	
	private IStockDao stockDao = null;
	
	public CalculateDividendPERatioServiceImpl(IStockDao stockDao) {
		this.stockDao = stockDao;
	}
	
	@Override
	public double calculateDividendYield(String stockSymbol){
		Stock stock = stockDao.getStock(stockSymbol);
		double dividendYield = 0.0;
		if(stock.getTickerPrice()<=0){
			throw new ArithmeticException("Ticker Value is Zero or less!");
		}
		if(stock.getType() == StockType.COMMON){
			dividendYield = stock.getLastDividend()/stock.getTickerPrice();
		}
		else if(stock.getType() == StockType.PREFERRED){
			dividendYield = stock.getFixedDividend()*stock.getParValue()/stock.getTickerPrice();
		}
		return dividendYield;
	}
	
	@Override
	public double calculatePERatio(String stockSymbol){
		Stock stock = stockDao.getStock(stockSymbol);		
		double peRatio = 0.0;
		double dividendYield = calculateDividendYield(stockSymbol);
		peRatio = stock.getTickerPrice()/dividendYield;
		return peRatio;
	}
}


