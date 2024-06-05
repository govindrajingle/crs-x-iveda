package com.gnine.stocks_share.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnine.stocks_share.model.EntityGeneral;
import com.gnine.stocks_share.repository.StocksInfoRepository;

@Controller
public class HomepageController {

	@Autowired
	StocksInfoRepository ub;

	// home page code to save data
	@RequestMapping("/homepage")
	public String goToHome() {
		return "HomeCalculator";
	}

	@PostMapping("/calculate")
	public ResponseEntity<String> calculate(@RequestBody String jsonData) {
		ObjectMapper mapper = new ObjectMapper();
		EntityGeneral domain = new EntityGeneral();
		try {
			domain = mapper.readValue(jsonData, EntityGeneral.class);
			// System.out.println(domain.toString());
			ub.transferData(domain);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Data saved to database", HttpStatus.OK);
	}

	// end
	// chart to display
	@RequestMapping("/chart")
	public String goToChart() {
		return "Chart";
	}

	@RequestMapping(value = "/profitorloss", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Map<String, Object>> getProfitOrLossAndPercentageOnCurrentMonth() {
		return ub.getTotalProfitOrLossAndPercentageOnCurrentMonth();
	}

	// end
}