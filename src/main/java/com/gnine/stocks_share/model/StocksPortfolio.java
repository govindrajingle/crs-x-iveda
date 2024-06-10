package com.gnine.stocks_share.model;

import java.math.BigDecimal;

public class StocksPortfolio {

	private int id;
	private String currentDate;
	private String stockName;
	private int buyPrice;
	private String buyDate;
	private BigDecimal amount;
	private BigDecimal investedAmount;
	private BigDecimal amountinvested;
	private BigDecimal investmentamount;
	private BigDecimal amountRemaining;
	private int numberOfShares;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getInvestedAmount() {
		return investedAmount;
	}

	public void setInvestedAmount(BigDecimal investedAmount) {
		this.investedAmount = investedAmount;
	}

	public BigDecimal getAmountRemaining() {
		return amountRemaining;
	}

	public void setAmountRemaining(BigDecimal amountRemaining) {
		this.amountRemaining = amountRemaining;
	}

	public int getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public BigDecimal getAmountinvested() {
		return amountinvested;
	}

	public void setAmountinvested(BigDecimal amountinvested) {
		this.amountinvested = amountinvested;
	}

	public BigDecimal getInvestmentamount() {
		return investmentamount;
	}

	public void setInvestmentamount(BigDecimal investmentamount) {
		this.investmentamount = investmentamount;
	}

}