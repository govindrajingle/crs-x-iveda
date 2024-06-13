package com.gnine.stocks_share.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gnine.stocks_share.model.StocksPortfolio;

@Repository
public class StocksPortfolioRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveTradeData(StocksPortfolio domain) {

	}
}
