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
<title>G9 | PurchasedStocks</title>
</head>
<body>
	<h1>Purchased Stocks</h1>
	<table id="tradesTable">
		<tr>
			<th>No.</th>
			<th>Stock Name</th>
			<th>Buy Price</th>
			<th>Buy Date</th>
			<th>Invested Amount</th>
			<th>Number of Shares</th>
			<!-- <th>Action</th> -->
		</tr>
	</table>
	<script src="/js/purchased-stocks.js"></script>
</body>
</html>