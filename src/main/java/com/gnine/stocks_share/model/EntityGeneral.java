package com.gnine.stocks_share.model;

import java.math.BigDecimal;

public class EntityGeneral {

	private String stockName;
	private BigDecimal buyPrice;
	private BigDecimal sellPrice;
	private BigDecimal investmentAmount;
	private BigDecimal totalProfitOrLoss;
	private BigDecimal amountAfterProfitLoss;
	private BigDecimal amountInvested;
	private BigDecimal amountRemaining;
	private BigDecimal taxAmount;
	private BigDecimal profitOrLossPercentage;
	private int numberOfSharesRounded;

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

	@Override
	public String toString() {
		return "EntityGeneral [stockName=" + stockName + ", buyPrice=" + buyPrice + ", sellPrice=" + sellPrice
				+ ", investmentAmount=" + investmentAmount + ", totalProfitOrLoss=" + totalProfitOrLoss
				+ ", amountAfterProfitLoss=" + amountAfterProfitLoss + ", amountInvested=" + amountInvested
				+ ", amountRemaining=" + amountRemaining + ", taxAmount=" + taxAmount + ", profitOrLossPercentage="
				+ profitOrLossPercentage + ", numberOfSharesRounded=" + numberOfSharesRounded + "]";
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

	public BigDecimal getInvestmentAmount() {
		return investmentAmount;
	}

	public void setInvestmentAmount(BigDecimal investmentAmount) {
		this.investmentAmount = investmentAmount;
	}

	public BigDecimal getTotalProfitOrLoss() {
		return totalProfitOrLoss;
	}

	public void setTotalProfitOrLoss(BigDecimal totalProfitOrLoss) {
		this.totalProfitOrLoss = totalProfitOrLoss;
	}

	public BigDecimal getAmountAfterProfitLoss() {
		return amountAfterProfitLoss;
	}

	public void setAmountAfterProfitLoss(BigDecimal amountAfterProfitLoss) {
		this.amountAfterProfitLoss = amountAfterProfitLoss;
	}

	public BigDecimal getAmountInvested() {
		return amountInvested;
	}

	public void setAmountInvested(BigDecimal amountInvested) {
		this.amountInvested = amountInvested;
	}

	public BigDecimal getAmountRemaining() {
		return amountRemaining;
	}

	public void setAmountRemaining(BigDecimal amountRemaining) {
		this.amountRemaining = amountRemaining;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public int getNumberOfSharesRounded() {
		return numberOfSharesRounded;
	}

	public void setNumberOfSharesRounded(int numberOfSharesRounded) {
		this.numberOfSharesRounded = numberOfSharesRounded;
	}

	public BigDecimal getProfitOrLossPercentage() {
		return profitOrLossPercentage;
	}

	public void setProfitOrLossPercentage(BigDecimal profitOrLossPercentage) {
		this.profitOrLossPercentage = profitOrLossPercentage;
	}

}