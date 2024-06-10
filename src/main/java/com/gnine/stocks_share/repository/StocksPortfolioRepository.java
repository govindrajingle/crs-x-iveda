package com.gnine.stocks_share.repository;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gnine.stocks_share.model.StocksPortfolio;

@Repository
public class StocksPortfolioRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveTradeData(StocksPortfolio domain) {
		String sql = "INSERT INTO gnine_stocks_portfolio (stockname, buyprice, buyDate, investmentamount, amountinvested, amountremaining, numberofshares) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Date parsedDate = format.parse(domain.getBuyDate());
			Timestamp timestamp = new Timestamp(parsedDate.getTime());
			jdbcTemplate.update(sql, domain.getStockName(), domain.getBuyPrice(), timestamp, domain.getInvestedAmount(),
					domain.getAmount(), domain.getAmountRemaining(), domain.getNumberOfShares());
		} catch (ParseException | DataAccessException e) {
			e.printStackTrace();
		}
	}
}
