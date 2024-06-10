package com.gnine.stocks_share.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnine.stocks_share.misc.GlobalStringVariables;
import com.gnine.stocks_share.model.StocksPortfolio;
import com.gnine.stocks_share.repository.StocksPortfolioRepository;

@RestController
public class RestControllerClass {

	@Autowired
	StocksPortfolioRepository sp;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/getTrades", method = RequestMethod.GET)
	public List<StocksPortfolio> getTrades() {
		String sql = "select id, stockname, buyprice, investmentamount, numberofshares, buydate from gnine_stocks_portfolio";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StocksPortfolio.class));
	}

	@RequestMapping(value = "/deleteTrade", method = RequestMethod.POST)
	public void deleteTrade(@RequestParam("id") int id) {
		String sql = "DELETE FROM gnine_stocks_portfolio WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	@GetMapping("/hello")
	public String hello(HttpServletRequest request) {
		System.out.println(LocalDateTime.now() + " server hit with browser ");
		return GlobalStringVariables.stringAsHtml;
	}

	@PostMapping("/savetradedata")
	public ResponseEntity<String> saveTradeData(@RequestBody String jsonData) {
		ObjectMapper mapper = new ObjectMapper();
		StocksPortfolio domain = new StocksPortfolio();
		try {
			domain = mapper.readValue(jsonData, StocksPortfolio.class);
			sp.saveTradeData(domain);
			System.out.println(LocalDateTime.now() + "  data saved to table gnine_stocks_portfolio");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Data saved to database", HttpStatus.OK);
	}
}
