package com.stock.services;

import java.util.List;
import java.util.Map;

import com.stock.model.Stock;

public class GBCECalculateServiceImpl implements GBCECalculateServiceI{
	
	private TradeRecordCalculateStockPriceServiceI stockPriceCalService = null;
	
	public GBCECalculateServiceImpl(TradeRecordCalculateStockPriceServiceI stockPriceCalService) {
		this.stockPriceCalService = stockPriceCalService;				
	}
	
	@Override
	public double calculateGBCE(List<Stock> aStockList){
		double multiplyPrice = 1.0;
		double geometricMean = 0.0;
		Map<String,Double> stockPriceForAllStocks = stockPriceCalService.calculateStockPriceForAllStocksForLast15Mins();
		for(Double stockPrice : stockPriceForAllStocks.values()){
			multiplyPrice *= stockPrice; 
		}
		geometricMean = Math.pow(10, Math.log10(multiplyPrice)/stockPriceForAllStocks.size());		
		return geometricMean;
	}	
}
