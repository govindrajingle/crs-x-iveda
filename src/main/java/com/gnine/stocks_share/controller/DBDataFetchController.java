package com.gnine.stocks_share.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gnine.stocks_share.repository.DBDataFetchRepository;

@Controller
public class DBDataFetchController {
	LocalDateTime currentTime = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	String Time = currentTime.format(formatter);

	@Autowired
	DBDataFetchRepository DBDataFetchRepository;

	@RequestMapping(value = "/profitorloss", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Map<String, Object>> getProfitOrLossAndPercentageOnCurrentMonth() {
		System.out.println(Time + "  /profitorloss Controller Hit");
		return DBDataFetchRepository.getTotalProfitOrLossAndPercentageOnCurrentMonth();
	}

	@GetMapping("/pricedb")
	public Double getRealTimePriceDB() {
		System.out.println("Controller Hit");
		return DBDataFetchRepository.getRealTimePrice();
	}

}
