package com.stock.services;

public interface CalculateDividendPERatioServiceI {
	/*
	 * Method to calculate Dividend Yield
	 */
	public double calculateDividendYield(String stockSymbol);
	
	/*
	 * Method to calculate PE Ratio
	 */
	public double calculatePERatio(String stockSymbol);
}
