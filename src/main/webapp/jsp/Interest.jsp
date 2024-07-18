<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/base-layout.css">
<link rel="icon" type="image/png" href="favicon/favicon.png">
<title>G9 | Mutual Fund Return</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

table, th, td {
	border: 1px solid black;
}

th, td {
	padding: 10px;
	text-align: center;
}

th {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div id="navLinks">
		<a href="homepage">Homepage</a> <a href="calculator">Calculator</a> <a
			href="chart">All Trades Chart</a>
	</div>
	<h2>Bank Interest Calculator for (1% pm)</h2>

	<table>
		<thead>
			<tr>
				<th>Month</th>
				<th>Initial Amount</th>
				<th>Interest</th>
				<!-- <th>Monthly Deposit</th>
                <th>Capital Amount</th> -->
				<th>Final Amount</th>
			</tr>
		</thead>
		<tbody>
			<%
			// Bank details
			int initialAmount = 185000;
			int monthlyDeposit = 25000;
			double annualInterestRate = 0.12;
			int months = 12; // 1 year period

			// Array of month names starting from June 2024
			String[] monthNames = { "June 2024", "July 2024", "August 2024", "September 2024", "October 2024", "November 2024",
					"December 2024", "January 2025", "February 2025", "March 2025", "April 2025", "May 2025" };

			// Calculate and populate the table
			double capital = initialAmount;
			double totalInterest = 0;

			for (int month = 0; month < months; month++) {
				// Calculate interest for the current month
				double monthlyInterest = capital * (annualInterestRate / 12);
				totalInterest += monthlyInterest;

				// Calculate final amount after adding interest and monthly deposit
				double finalAmount = capital + monthlyInterest + monthlyDeposit;

				// Print table row
			%>
			<tr>
				<td><%=monthNames[month]%></td>
				<td><%=initialAmount%></td>
				<td><%=String.format("%.2f", monthlyInterest)%></td>
				<%-- <td><%= monthlyDeposit %></td> --%>
				<%-- <td><%= String.format("%.2f", capital) %></td> --%>
				<td><%=String.format("%.2f", finalAmount)%></td>
			</tr>
			<%
			// Update capital amount for next iteration
			capital = finalAmount;
			initialAmount += monthlyDeposit;
			}
			%>
		</tbody>
	</table>

	<p>
		Total Interest Earned:
		<%=String.format("%.2f", totalInterest)%></p>

	<%@ include file="Footer.jsp"%>
</body>
</html>
