<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/base-layout.css">
<link rel="stylesheet" href="css/purchased-stocks.css">
<link rel="icon" type="image/png" href="favicon/favicon.png">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="js/purchased-stocks.js"></script>
<title>G9 | All Trades</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div id="navLinks">
		<a href="homepage">Homepage</a> <a href="calculator">Calculator</a> <a
			href="chart">All Trades Chart</a>
	</div>
	<div class="main-container">
		<div class="content">
			<h1>Purchased Stocks</h1>
			<table id="tradesTable"
				style="border-collapse: collapse; width: 100%;">
				<thead>
					<tr>
						<th>Index</th>
						<th>Buy Date</th>
						<th>Stock Name</th>
						<th>Profit/Loss %</th>
						<th>Net Gain/Loss</th>
						<th>Show More</th>
					</tr>
				</thead>
				<tbody>
					<!-- Table rows will be dynamically added here -->
				</tbody>
			</table>
		</div>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>