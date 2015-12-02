package com.stock.services;

import java.util.List;

import com.stock.model.Stock;

public interface GBCECalculateServiceI {

	/*
	 * Method used to calculate GBCE All Share Index using geometric mean of prices for all stocks
	 */
	public double calculateGBCE(List<Stock> aStockList);
}
