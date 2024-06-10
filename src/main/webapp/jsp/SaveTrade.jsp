<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/home-calculator.css">
<link rel="icon" type="image/png" href="/favicon/favicon.png">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<title>G9 | Save Trade</title>
</head>
<body style="display: flex; flex-direction: column; justify-content: center; align-items: center; height: 100vh; margin: 0;">
    <h1>Save Your Trade</h1>
    <form id="saveyourtrade">
        <label for="stockName">Stock Name:</label> <input type="text" id="stockName" name="stockName" required><br>
        <label for="buyPrice">Buy Price:</label> <input type="number" id="buyPrice" name="buyPrice" step="any" required><br>
        <label for="buyDate">Buy Date:</label> <input type="date" id="buyDate" name="buyDate" required><br>
        <label for="amount">Amount:</label> <input type="number" id="amount" name="amount" required><br>
        <input type="submit" value="Save Trade">
       <a href="purchasedstocks">Fetch Data</a>
    </form>
    <script src="/js/save-trade.js"></script>
</body>
</html>