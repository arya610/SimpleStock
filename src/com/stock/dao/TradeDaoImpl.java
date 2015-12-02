package com.stock.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stock.model.Trade;


public class TradeDaoImpl implements ITradeDao{
	
	private Map<String,List<Trade>> listOfTradesForStocks = new HashMap<>();
	
	@Override
	public void saveTrade(Trade trade) {
		List<Trade> tradeList = listOfTradesForStocks.get(trade.getStock().getSymbol());
		if(tradeList == null) {
			tradeList = new ArrayList<Trade>();			
		}
		tradeList.add(trade);
		listOfTradesForStocks.put(trade.getStock().getSymbol(), tradeList);
	}
	
	@Override
	public Map<String,List<Trade>> getAllTradesPerStock() {		
		return listOfTradesForStocks;
	}			
}
