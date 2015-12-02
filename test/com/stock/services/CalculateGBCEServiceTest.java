package com.stock.services;

import static org.junit.Assert.*;

import org.junit.Test;

import com.stock.services.GBCECalculateServiceImpl;

public class CalculateGBCEServiceTest extends AbstractStockCalculationTest {
	protected GBCECalculateServiceI calcGbceService = null;
	private TradeRecordCalculateStockPriceServiceI stockPriceCalService = null;
		
	public CalculateGBCEServiceTest(){
		stockPriceCalService = new TradeRecordCalculateStockPriceServiceImpl(tradeDao);
		calcGbceService = new GBCECalculateServiceImpl(stockPriceCalService);
	}

	/*
	 * Method to test Calculate GBCE All Share Index using Geometric mean for all stock prices
	 */
	@Test
	public void testCalcGBCE() {
		double gbcePrice = calcGbceService.calculateGBCE(stockList);
		assertEquals(4366.143847532663, gbcePrice, 0);
	}

}
