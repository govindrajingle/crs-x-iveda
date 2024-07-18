<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/base-layout.css">
<link rel="icon" type="image/png" href="favicon/favicon.png">
<title>G9 | Home Page</title>
<script src="js/homepage.js"></script>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div class="main-container">
		<div class="content">
			<p>Here's your thrilling dossier on your rollercoaster stock
				market journey. Brace yourself for the total investment you've
				generously donated to the market's whims, the epic tale of your
				total 'minimal' profits and losses, and of course, that's all folks!
				Prepare for the laughter... or tears!</p>
			<p>
				Total Profit: <span id="totalProfitValue"></span>
			</p>
			<p>
				Total Turnover: <span id="totalTurnoverValue"></span>
			</p>
			<p>
				Total Time: <span id="totalTimeValue"></span>
			</p>
			<p>
				Total Tax: <span id="totalTaxValue"></span>
			</p>
			<p>
				Profit Percentage: <span id="profitPercentageValue"></span>
			</p>
		</div>
	</div>
	<a href="calculator">Calculator</a>
	<br>
	<br>
	<a href="tradeinfo">Trade information</a>
	<br>
	<br>
	<a href="chart">Chart wise data</a>
	<br>
	<br>
	<%@ include file="Footer.jsp"%>
</body>
</html>
