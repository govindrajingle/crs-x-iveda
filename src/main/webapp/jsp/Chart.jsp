<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Chart Example</title>
<link rel="stylesheet" href="/css/home-calculator.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
</head>
<body>
	<h1>
		Income of
		<%=new java.text.SimpleDateFormat("MMMM").format(new java.util.Date())%></h1>
	<canvas id="myChart"
		style="display: block; margin-left: auto; margin-right: auto; width: 100%; max-width: 1200px;"></canvas>
</body>
<script src="/js/chart.js"></script>
</html>
