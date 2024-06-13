<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/home-calculator.css">
<link rel="icon" type="image/png" href="/favicon/favicon.png">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<title>G9 | Purchased Stocks</title>
</head>
<body>
	<h1>Purchased Stocks</h1>
	<table id="tradesTable">
		<tr>
			<th>Index</th>
			<th>Buy Date</th>
			<th>Stock Name</th>
			<th>Buy Price</th>
			<th>Sell Price</th>
			<th>Profit/Loss %</th>
			<th>Net Gain/Loss</th>
			<th>Total Amount</th>
			<th>Invested Amount</th>
			<th>Number of Shares</th>
			<th>Tax</th>
			<th>Hold Time Days</th>
		</tr>
	</table>
	<script src="/js/purchased-stocks.js"></script>
</body>
</html>