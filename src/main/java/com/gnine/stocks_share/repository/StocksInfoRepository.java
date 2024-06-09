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
public class StocksInfoRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void transferData(EntityGeneral domain) {
	    String sql = "INSERT INTO gnine_stocks_info (stockName, buyPrice, sellPrice, investmentAmount, totalProfitOrLoss, amountAfterProfitLoss, amountInvested, amountRemaining, taxAmount, numberOfSharesRounded, profitOrLossPercentage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try {
	        jdbcTemplate.update(sql, domain.getStockName(), domain.getBuyPrice(), domain.getSellPrice(), domain.getInvestmentAmount(), domain.getTotalProfitOrLoss(), domain.getAmountAfterProfitLoss(), domain.getAmountInvested(), domain.getAmountRemaining(), domain.getTaxAmount(), domain.getNumberOfSharesRounded(), domain.getProfitOrLossPercentage());
	    } catch (DataAccessException e) {
	        e.printStackTrace();
	    }
	}
	
	public List<Map<String, Object>> getTotalProfitOrLossAndPercentageOnCurrentMonth() {
        YearMonth currentMonth = YearMonth.now();
      //complete information on hover
      //String sql = "SELECT current_date, SUM(profitOrLossPercentage) as profitOrLossPercentage, stockName, SUM(buyPrice) as buyPrice, SUM(sellPrice) as sellPrice, SUM(investmentAmount) as investmentAmount, SUM(totalProfitOrLoss) as totalProfitOrLoss, SUM(amountAfterProfitLoss) as amountAfterProfitLoss, SUM(amountInvested) as amountInvested, SUM(amountRemaining) as amountRemaining, SUM(taxAmount) as taxAmount, SUM(numberOfSharesRounded) as numberOfSharesRounded FROM gnine_stocks_info WHERE EXTRACT(YEAR FROM current_date) = ? AND EXTRACT(MONTH FROM current_date) = ? GROUP BY current_date, stockName";
        
        String sql = "SELECT current_date, stockName, buyPrice, sellPrice, investmentAmount, totalProfitOrLoss, amountAfterProfitLoss, amountInvested, amountRemaining, taxAmount, numberOfSharesRounded, profitOrLossPercentage FROM gnine_stocks_info WHERE EXTRACT(YEAR FROM current_date) = ? AND EXTRACT(MONTH FROM current_date) = ?";
        try {
            return jdbcTemplate.queryForList(sql, new Object[]{currentMonth.getYear(), currentMonth.getMonthValue()});
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
