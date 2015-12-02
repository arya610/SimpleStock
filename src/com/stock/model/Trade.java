package com.stock.model;

import java.util.Date;
import java.util.UUID;

import com.stock.util.TransactionType;

public class Trade {
	private UUID id = null;
	private Date timeStamp = null;
	private long numberOfShares = 0L;
	private TransactionType buySellIndicator = null;
	private double price = 0.0;
	private Stock stock = null;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public long getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(long numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	public TransactionType getBuySellIndicator() {
		return buySellIndicator;
	}
	public void setBuySellIndicator(TransactionType buySellIndicator) {
		this.buySellIndicator = buySellIndicator;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}	
}
