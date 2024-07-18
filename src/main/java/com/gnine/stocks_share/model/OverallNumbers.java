package com.gnine.stocks_share.model;

import java.math.BigDecimal;
import java.util.Date;

public class OverallNumbers {

	@Override
	public String toString() {
		return "OverallNumbers [id=" + id + ", currentDate=" + currentDate + ", totalProfit=" + totalProfit
				+ ", totalTurnover=" + totalTurnover + ", totalTime=" + totalTime + ", totalTax=" + totalTax
				+ ", totalAmountGain=" + totalAmountGain + ", profitPercentage=" + profitPercentage + "]";
	}

	private Long id;

	private Date currentDate;
	private BigDecimal totalProfit;
	private BigDecimal totalTurnover;
	private BigDecimal totalTime;
	private BigDecimal totalTax;
	private BigDecimal totalAmountGain;
	private BigDecimal profitPercentage;

	public BigDecimal getProfitPercentage() {
		return profitPercentage;
	}

	public void setProfitPercentage(BigDecimal profitPercentage) {
		this.profitPercentage = profitPercentage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public BigDecimal getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(BigDecimal totalProfit) {
		this.totalProfit = totalProfit;
	}

	public BigDecimal getTotalTurnover() {
		return totalTurnover;
	}

	public void setTotalTurnover(BigDecimal totalTurnover) {
		this.totalTurnover = totalTurnover;
	}

	public BigDecimal getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(BigDecimal totalTime) {
		this.totalTime = totalTime;
	}

	public BigDecimal getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

	public BigDecimal getTotalAmountGain() {
		return totalAmountGain;
	}

	public void setTotalAmountGain(BigDecimal totalAmountGain) {
		this.totalAmountGain = totalAmountGain;
	}
}
