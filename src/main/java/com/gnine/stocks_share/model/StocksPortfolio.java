package com.gnine.stocks_share.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StocksPortfolio {
	private int id;
	private String stockname;
	private BigDecimal buyprice;
	private BigDecimal investmentamount;
	private int numberofshares;
	private LocalDateTime buydate;
	private int sellprice;
	private BigDecimal profitlosspercentage;
	private BigDecimal tax;
	private BigDecimal netgainloss;
	private int holdtimedays;
	private BigDecimal amountinvested;
	private BigDecimal balance;
	
	
	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAmountinvested() {
		return amountinvested;
	}

	public void setAmountinvested(BigDecimal amountinvested) {
		this.amountinvested = amountinvested;
	}

	public String getStockname() {
		return stockname;
	}

	public void setStockname(String stockname) {
		this.stockname = stockname;
	}

	public BigDecimal getBuyprice() {
		return buyprice;
	}

	public void setBuyprice(BigDecimal buyprice) {
		this.buyprice = buyprice;
	}

	public BigDecimal getInvestmentamount() {
		return investmentamount;
	}

	public void setInvestmentamount(BigDecimal investmentamount) {
		this.investmentamount = investmentamount;
	}

	public int getNumberofshares() {
		return numberofshares;
	}

	public void setNumberofshares(int numberofshares) {
		this.numberofshares = numberofshares;
	}

	public LocalDateTime getBuydate() {
		return buydate;
	}

	public void setBuydate(LocalDateTime buydate) {
		this.buydate = buydate;
	}

	public int getSellprice() {
		return sellprice;
	}

	public void setSellprice(int sellprice) {
		this.sellprice = sellprice;
	}

	public BigDecimal getProfitlosspercentage() {
		return profitlosspercentage;
	}

	public void setProfitlosspercentage(BigDecimal profitlosspercentage) {
		this.profitlosspercentage = profitlosspercentage;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getNetgainloss() {
		return netgainloss;
	}

	public void setNetgainloss(BigDecimal netgainloss) {
		this.netgainloss = netgainloss;
	}

	public int getHoldtimedays() {
		return holdtimedays;
	}

	public void setHoldtimedays(int holdtimedays) {
		this.holdtimedays = holdtimedays;
	}

	@Override
	public String toString() {
		return "StocksPortfolio [stockname=" + stockname + ", buyprice=" + buyprice + ", investmentamount="
				+ investmentamount + ", numberofshares=" + numberofshares + ", buydate=" + buydate + ", sellprice="
				+ sellprice + ", profitlosspercentage=" + profitlosspercentage + ", tax=" + tax + ", netgainloss="
				+ netgainloss + ", holdtimedays=" + holdtimedays + "]";
	}

}
