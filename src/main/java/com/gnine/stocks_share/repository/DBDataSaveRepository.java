package com.gnine.stocks_share.repository;

import java.io.IOException;
import java.math.BigDecimal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DBDataSaveRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveStockPrice(BigDecimal new_value) {
		String sql = "SELECT update_gnine_stock_price_realtime(?)";
		try {
			jdbcTemplate.update(sql, new_value);
		} catch (DataAccessException e) {
			// Handle exception, log error, etc.
			//e.printStackTrace();
		}
	}

	public BigDecimal fetchStockPriceData() throws IOException {
		Document doc = Jsoup.connect("https://www.google.com/finance/quote/ADANIPOWER:NSE").get();
		Elements elements = doc.select(".YMlKec.fxKbKc");
		if (!elements.isEmpty()) {
			Element element = elements.first();
			String priceString = element.text();
			// Remove rupees symbol and any other non-numeric characters
			priceString = priceString.replaceAll("[^\\d.]", "");
			// Convert string to BigDecimal
			BigDecimal price = new BigDecimal(priceString);
			saveStockPrice(price); // Save the price to the database
			return price;
		} else {
			throw new IOException("Price element not found");
		}
	}
}
