package com.stock.services;

import org.junit.Assert;
import org.junit.Test;

public class CalculateDividendPERatioTest extends AbstractStockCalculationTest{

	protected CalculateDividendPERatioServiceI calcDivPEService = null;
	
	public CalculateDividendPERatioTest() {		
		calcDivPEService = new CalculateDividendPERatioServiceImpl(stockDao);		
	}
	
	/*
	 * Method to test Calculate Dividend Yield for stock of Common type 
	 */
	@Test
	public void testDividendYield_Common() {
		double dividendYield = calcDivPEService.calculateDividendYield("ALE");
		Assert.assertEquals(0.3898305084745763, dividendYield, 0);
	}
	
	/*
	 * Method to test Calculate Dividend Yield for stock of Preferred type 
	 */
	@Test	
	public void testDividendYield_Prefered() {
		double dividendYield = calcDivPEService.calculateDividendYield("GIN");
		Assert.assertEquals(1.8867924528301887, dividendYield, 0);
	}
	
	/*
	 * Method to test exceptional condition while calculating Dividend Yield for random invalid stock 
	 */
	@Test(expected=ArithmeticException.class)	
	public void testDividendYield_Exception() {
		calcDivPEService.calculateDividendYield("INV");		
	}
	
	/*
	 * Method to test Calculate PE Ratio for stock of Common type 
	 */
	@Test
	public void testPERatio_Common() {
		double dividendYield = calcDivPEService.calculatePERatio("ALE");
		Assert.assertEquals(151.3478260869565, dividendYield, 0);
	}
	
	/*
	 * Method to test Calculate PE Ratio for stock of Preferred type 
	 */
	@Test
	public void testPERatio_Prefered() {
		double dividendYield = calcDivPEService.calculatePERatio("GIN");
		Assert.assertEquals(56.18, dividendYield, 0);
	}

}
