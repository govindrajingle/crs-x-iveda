package com.gnine.stocks_share.schedulers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class GoogleFinanceAPI {
	//@Scheduled(cron = "0 * * ? * *") // Run every minute
	public void fetchStockPriceData() {
		try {
			Document doc = Jsoup.connect("https://www.google.com/finance/quote/EXIDEIND:NSE").get();
			Elements elements = doc.select(".YMlKec.fxKbKc");
			if (!elements.isEmpty()) {
				Element element = elements.first();
				String priceString = element.text();
				// Remove rupees symbol and any other non-numeric characters
				priceString = priceString.replaceAll("[^\\d.]", "");
				// Convert string to BigDecimal
				BigDecimal price = new BigDecimal(priceString);
				System.out.println("Price: " + price);
			} else {
				System.out.println("Price element not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
