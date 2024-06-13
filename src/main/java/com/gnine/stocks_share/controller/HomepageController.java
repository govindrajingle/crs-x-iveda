package com.gnine.stocks_share.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

	@RequestMapping("/testpage")
	public String goToTestPage() {
		System.out.println("Test JSP controller Hit");
		return "Test";
	}

	@GetMapping("/checkurl")
	public ResponseEntity<String> checkURL() {
		String urlToCheck = "https://195.3.220.223/finance/quote/EXIDEIND:NSE?__cpo=aHR0cHM6Ly93d3cuZ29vZ2xlLmNvbQ"; // Example URL
		System.out.println("Checking URL connection: " + urlToCheck);
		try {
			URL url = new URL(urlToCheck);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder response = new StringBuilder();
				String line;
				boolean divFound = false;
				boolean withinDiv = false;
				while ((line = reader.readLine()) != null) {
					if (line.contains("<div class=\"YMlKec fxKbKc\">")) {
						divFound = true;
						withinDiv = true;
					} else if (withinDiv && line.contains("</div>")) {
						withinDiv = false;
						break;
					}
					if (withinDiv) {
						response.append(line.trim());
						response.append("\n");
					}
				}
				reader.close();

				if (response.length() > 0) {
					// Extract the value within the div
					String value = extractValueFromResponse(response.toString());
					return ResponseEntity.ok(value);
				} else {
					return ResponseEntity.ok("Element not found");
				}
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("URL is not reachable. Response code: " + responseCode);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
		}
	}

	private String extractValueFromResponse(String response) {
		int startIndex = response.indexOf(">$");
		int endIndex = response.indexOf("</div>", startIndex);
		if (startIndex != -1 && endIndex != -1) {
			return response.substring(startIndex + 2, endIndex);
		} else {
			return "Value not found";
		}
	}

	@RequestMapping("/dashboard")
	public String goToDashboard() {
		return "Dashboard";
	}

	@RequestMapping("/purchasedstocks")
	public String goToPurchasedStocks() {
		return "PurchasedStocks";
	}

	@RequestMapping("/savetrade")
	public String goToSaveTrade() {
		return "SaveTrade";
	}

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
			ub.transferData(domain);
			System.out.println(LocalDateTime.now() + "  data saved to table gnine_stocks_info");
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
		// System.out.println(ub.getTotalProfitOrLossAndPercentageOnCurrentMonth());
		return ub.getTotalProfitOrLossAndPercentageOnCurrentMonth();
	}

	// end
}
