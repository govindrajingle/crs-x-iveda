<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" type="image/png" href="favicon/favicon.png">
<title>G9 | Trade Chart</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="js/chart.js"></script>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<a href="homepage">Homepage</a>
	<a href="calculator">Calculator</a>
	<a href="tradeinfo">Trade Information</a>
	<div class="main-container">
		<div class="content">
			<%
			java.util.Calendar cal = java.util.Calendar.getInstance();
			int currentMonth = cal.get(java.util.Calendar.MONTH); // Month is zero-based
			String[] monthNames = new java.text.DateFormatSymbols().getMonths();
			String currentMonthName = monthNames[currentMonth];
			%>
<%-- 			<h1>
				Month Chart for
				<%=currentMonthName%>
			</h1> --%>
			<h1>All Trades Chart</h1>

			<canvas id="profitLossChart" width="150" height="50"></canvas>
		</div>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>