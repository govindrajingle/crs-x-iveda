<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/css/home-calculator.css">
<link rel="icon" type="image/png" href="/favicon/favicon.png">
<title>G9 | Stock Calculator</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body
	style="display: flex; flex-direction: column; justify-content: center; align-items: center; height: 100vh; margin: 0;">
	<div id="container">
		<h2>Stock Profit/Loss Calculator</h2>
		<form id="calculatorForm">
			<!-- <label for="stockName">Stock Name:</label> <input type="text"
				id="stockName" name="stockName" value="Saitama Organisation"><br> -->
			<label for="buyPrice">Buy Price:</label> <input type="number"
				id="buyPrice" name="buyPrice" step="any" value="113" required><br>
			<label for="sellPrice">Sell Price:</label> <input type="number"
				id="sellPrice" name="sellPrice" step="any" value="134" required><br>
			<label for="investmentAmount">Capital Investment Amount:</label> <input
				type="number" id="investmentAmount" name="investmentAmount"
				step="any" value="180000" required><br>
			<div class="result" id="result"></div>
			<input type="submit" value="Calculate">
			<!-- <input type="button" id="saveData" value="Save Data" style="display: none;"> -->
		</form>
		<!-- <a href="/chart" class="chart-link">Monthly Chart</a> -->
	</div>
	<script src="/js/home-calculator.js"></script>
</body>
</html>
