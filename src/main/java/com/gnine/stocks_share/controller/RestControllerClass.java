package com.gnine.stocks_share.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

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

	/*
	 * @GetMapping("/customstockdatastream") public BigDecimal streamRandomValues()
	 * { try { return fetchStockPriceData(); } catch (IOException e) {
	 * e.printStackTrace(); } return null; }
	 * 
	 * public BigDecimal fetchStockPriceData() throws IOException { Document doc =
	 * Jsoup.connect("https://www.google.com/finance/quote/ADANIPOWER:NSE").get();
	 * // Document doc = Jsoup.connect(
	 * "https://195.3.220.223/finance/quote/EXIDEIND:NSE?__cpo=aHR0cHM6Ly93d3cuZ29vZ2xlLmNvbQ"
	 * ).get(); Elements elements = doc.select(".YMlKec.fxKbKc"); if
	 * (!elements.isEmpty()) { Element element = elements.first(); String
	 * priceString = element.text(); // Remove rupees symbol and any other
	 * non-numeric characters priceString = priceString.replaceAll("[^\\d.]", "");
	 * // Convert string to BigDecimal return new BigDecimal(priceString); } else {
	 * throw new IOException("Price element not found"); } }
	 */

	@RequestMapping(value = "/getTrades", method = RequestMethod.GET)
	public List<StocksPortfolio> getTrades() {
		String sql = "SELECT id, stockname, buyprice, investmentamount, numberofshares, buydate, sellprice, profitlosspercentage, tax, netgainloss, holdtimedays, amountinvested, (SELECT balance FROM gnine_stocks_portfolio WHERE id = (SELECT MAX(id) FROM gnine_stocks_portfolio)) AS balance FROM gnine_stocks_portfolio";
		List<StocksPortfolio> trades = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StocksPortfolio.class));
//		for (StocksPortfolio trade : trades) {
//			System.out.println(trade.toString()); // Assuming you have overridden toString() in StocksPortfolio class
//		}
		return trades;
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
