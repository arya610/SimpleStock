package com.stock.model;

import com.stock.util.StockType;

public class Stock {
	private String symbol = null;
	private StockType type = null;
	private double lastDividend = 0.0;
	private float fixedDividend = 0.0f;
	private double parValue = 0.0;
	private double tickerPrice = 0.0;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public StockType getType() {
		return type;
	}
	public void setType(StockType type) {
		this.type = type;
	}
	public double getLastDividend() {
		return lastDividend;
	}
	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}
	public float getFixedDividend() {
		return fixedDividend;
	}
	public void setFixedDividend(float fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	public double getParValue() {
		return parValue;
	}
	public void setParValue(double parValue) {
		this.parValue = parValue;
	}
	public double getTickerPrice() {
		return tickerPrice;
	}
	public void setTickerPrice(double tickerPrice) {
		this.tickerPrice = tickerPrice;
	}
	
}
