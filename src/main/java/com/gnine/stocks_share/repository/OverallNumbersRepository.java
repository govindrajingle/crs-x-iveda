package com.gnine.stocks_share.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OverallNumbersRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


}
