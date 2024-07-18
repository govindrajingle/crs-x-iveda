<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/base-layout.css">
<link rel="stylesheet" href="css/calculator.css">
<link rel="icon" type="image/png" href="favicon/favicon.png">
<title>G9 | Calculator</title>
<script src="js/calculator.js"></script>
</head>
<body>
	<div id="popup" class="popup">
		<div id="popup-content" class="popup-content"></div>
	</div>
	<div class="main-container">
		<%@ include file="Header.jsp"%>
		<div id="navLinks">
			<a href="homepage">Homepage</a> <a href="tradeinfo">Trade
				Information</a> <a href="chart">All Trades Chart</a>
		</div>

		<div class="content">
			<h2>Stock Profit/Loss Calculator</h2>
			<form id="calculatorForm">
				<label for="buyPrice">Buy Price:</label> <input type="number"
					id="buyPrice" name="buyPrice" step="any"
					placeholder="Enter buy price" required><br> <label
					for="sellPrice">Sell Price:</label> <input type="number"
					id="sellPrice" name="sellPrice" step="any"
					placeholder="Enter sell price" required><br> <label
					for="investmentAmount">Amount:</label> <input type="number"
					id="investmentAmount" name="investmentAmount" step="any"
					value="180000" required><br> <label for="orderType">Order
					Type:</label> <select id="orderType" name="orderType">
					<option value="MIS">MIS</option>
					<option value="CIN" selected>CIN</option>
				</select><br> <input type="submit" value="Calculate">
			</form>
		</div>
		<%@ include file="Footer.jsp"%>
	</div>
</body>
</html>
