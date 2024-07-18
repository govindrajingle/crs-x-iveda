package com.gnine.stocks_share.repository;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gnine.stocks_share.model.EntityGeneral;

@Repository
public class DBDataFetchRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void transferData(EntityGeneral domain) {
		String sql = "INSERT INTO gnine_stocks_info (stockName, buyPrice, sellPrice, investmentAmount, totalProfitOrLoss, amountAfterProfitLoss, amountInvested, amountRemaining, taxAmount, numberOfSharesRounded, profitOrLossPercentage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			jdbcTemplate.update(sql, domain.getStockName(), domain.getBuyPrice(), domain.getSellPrice(),
					domain.getInvestmentAmount(), domain.getTotalProfitOrLoss(), domain.getAmountAfterProfitLoss(),
					domain.getAmountInvested(), domain.getAmountRemaining(), domain.getTaxAmount(),
					domain.getNumberOfSharesRounded(), domain.getProfitOrLossPercentage());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	public Double getRealTimePrice() {
		String sql = "SELECT value FROM gnine_stock_price_realtime ORDER BY created_at DESC LIMIT 1";
		System.out.println(jdbcTemplate.queryForObject(sql, Double.class));
		return jdbcTemplate.queryForObject(sql, Double.class);
	}

	public List<Map<String, Object>> getTotalProfitOrLossAndPercentageOnCurrentMonth() {
		YearMonth currentMonth = YearMonth.now();
		String sql = "select * from gnine_stocks_portfolio";
		try {
			return jdbcTemplate.queryForList(sql);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

}
