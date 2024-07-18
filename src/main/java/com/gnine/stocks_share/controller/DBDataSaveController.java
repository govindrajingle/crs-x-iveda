package com.gnine.stocks_share.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gnine.stocks_share.repository.DBDataSaveRepository;

@RestController
public class DBDataSaveController {

	@Autowired
	DBDataSaveRepository DBDataSaveRepository;
	
	LocalDateTime currentTime = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	String Time = currentTime.format(formatter);

	@GetMapping("/customstockdatastream")
	public BigDecimal streamRandomValues() {
		try {
			System.out.println(Time + "  /customstockdatastream hit");
			return DBDataSaveRepository.fetchStockPriceData();
		} catch (IOException e) {
			e.printStackTrace();
			return BigDecimal.ZERO; 
		}
	}
}
