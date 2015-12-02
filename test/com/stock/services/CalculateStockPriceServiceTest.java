package com.stock.services;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

public class CalculateStockPriceServiceTest extends AbstractStockCalculationTest{
	
	protected TradeRecordCalculateStockPriceServiceI calcStockPriceService = null;
	
	public CalculateStockPriceServiceTest(){
		calcStockPriceService = new TradeRecordCalculateStockPriceServiceImpl(tradeDao);
	}

	/*
	 * Method to test Calculate Stock Prices for all stocks based  on trades, recorded in last 15 minutes 
	 */
	@Test
	public void testCalcStockPriceforAllStocks() {
		Map<String,Double> stockPriceList = calcStockPriceService.calculateStockPriceForAllStocksForLast15Mins();
		assertEquals("{POP=10005.5, TEA=200.0, JOE=4000.4, ALE=4376.0, GIN=45294.0}", stockPriceList.toString());
	}
}
