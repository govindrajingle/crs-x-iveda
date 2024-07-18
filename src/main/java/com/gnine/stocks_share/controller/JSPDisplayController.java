package com.gnine.stocks_share.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSPDisplayController {
	LocalDateTime currentTime = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	String Time = currentTime.format(formatter);

	@RequestMapping("/calculator")
	public String goToCalculateorPage() {
		System.out.println(Time + "  Calculator JSP Called");
		return "Calculator";
	}

	@RequestMapping("/homepage")
	public String goToHomePage() {
		System.out.println(Time + "  Homepage JSP Called");
		return "Homepage";
	}

	@RequestMapping("/tradeinfo")
	public String goToPurchasedStocksPage() {
		System.out.println(Time + "  PurchasedStocks JSP Called");
		return "PurchasedStocks";
	}

	@RequestMapping("/testpage")
	public String goToTestPage() {
		System.out.println("Test JSP controller Hit");
		return "Test";
	}

	@RequestMapping("/chart")
	public String goToChartPage() {
		return "Chart";
	}
	
	@RequestMapping("/returnlive")
	public String goToReturnLivePage() {
		return "LiveReturn";
	}
	
	@RequestMapping("/interest")
	public String goToInterest() {
		System.out.println(Time + "  Interest JSP Called");
		return "Interest";
	}
}
