<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/css/chart-page.css">
<link rel="icon" type="image/png" href="/favicon/favicon.png">
<title>G9 | Live Share Price</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
	<h1>Exide Industries Ltd</h1>
	<div id="priceDisplay"></div>
	<div id="container">
		<canvas id="priceChart"></canvas>
	</div>
	<script>

        const ctx = document.getElementById('priceChart').getContext('2d');
        let labels = [];
        let data = [];
        let myChart = null;

        function updateOrCreateChart() {
            if (myChart !== null) {
                myChart.data.labels = labels;
                myChart.data.datasets[0].data = data;
                myChart.update();
            } else {
                myChart = new Chart(ctx, {
                    type: 'line',
                    data: {
                        labels: labels,
                        datasets: [{
                            label: 'Stock Price',
                            data: data,
                            fill: false,
                            borderColor: 'rgb(75, 192, 192)',
                            tension: 0.1
                        }]
                    },
                    options: {
                        scales: {
                            y: {
                                beginAtZero: false
                            }
                        }
                    }
                });
            }
        }
        function updatePriceDisplay(price, buyPrice, investmentAmount) {
            const priceDisplay = document.getElementById('priceDisplay');
            priceDisplay.textContent = 'Current Price: ' + price.toFixed(2);
            var sellPrice = parseFloat(price); 
            var taxAmount = 370;
            var numberOfSharesRounded = Math.floor(investmentAmount / buyPrice);
            var profitOrLoss = (sellPrice - buyPrice) * numberOfSharesRounded;
            var amountAfterProfitLoss = investmentAmount + profitOrLoss - taxAmount;
            var profitOrLossPercentage;
            var tableContent = "<table><tr><th>Title</th><th>Value</th></tr>";
            if (profitOrLoss >= 0) {
                profitOrLossPercentage = ((sellPrice - buyPrice) / buyPrice) * 100;
                tableContent += "<tr><td>Profit Percentage</td><td>" + profitOrLossPercentage.toFixed(2) + "%</td></tr>";
            } else {
                profitOrLossPercentage = -Math.abs(((buyPrice - sellPrice) / buyPrice) * 100);
                tableContent += "<tr><td>Loss Percentage</td><td>" + profitOrLossPercentage.toFixed(2) + "%</td></tr>";
            }
            tableContent += "<tr><td>Net Gain/Loss</td><td>" + profitOrLoss.toFixed(2) + "</td></tr>";
            tableContent += "<tr><td>Tax</td><td>" + taxAmount.toFixed(2) + "</td></tr>";
            tableContent += "<tr><td>Amount Gain (Net Gain - Tax)</td><td>" + (profitOrLoss - taxAmount).toFixed(2) + "</td></tr>";
            tableContent += "<tr><td>Amount after profit/loss and tax</td><td>" + amountAfterProfitLoss.toFixed(2) + "</td></tr>";
            tableContent += "<tr><td class='" + (investmentAmount < amountAfterProfitLoss ? "white-text" : "red-text") + "'>Amount Invested</td><td class='" + (investmentAmount < amountAfterProfitLoss ? "white-text" : "red-text") + "'>" + (buyPrice * numberOfSharesRounded).toFixed(2) + "</td></tr>";
            tableContent += "</table>";
            priceDisplay.innerHTML = tableContent;
         	// Adding current net gain field
            var currentNetGain = profitOrLoss - taxAmount;
            var netGainElement = document.createElement("div");
            netGainElement.textContent = "Current Net Gain (Tax excluded): " + currentNetGain.toFixed(2);
            netGainElement.style.color = currentNetGain >= 0 ? '#00FF00' : '#FF0000';
            netGainElement.style.textAlign = 'center'; // Align in center
            netGainElement.style.padding = '20px 0'; // Padding top and bottom
            priceDisplay.appendChild(netGainElement);

            // Adding sell price field
            var sellPriceElement = document.createElement("div");
            sellPriceElement.textContent = "Sell Price: " + sellPrice.toFixed(2);
            sellPriceElement.style.color = '#FFFFFF'; // White color
            sellPriceElement.style.textAlign = 'center'; // Align in center
            sellPriceElement.style.padding = '20px 0'; // Padding top and bottom
            priceDisplay.appendChild(sellPriceElement);

        }
        
        fetchStockPriceAndUpdateDisplay();
        setInterval(fetchStockPriceAndUpdateDisplay, 60000); //data per millisecond
        
        function fetchStockPriceAndUpdateDisplay() {
            fetch("/customstockdatastream")
                .then(response => response.text())
                .then(price => {
                    const floatValue = parseFloat(price);
                    data.push(floatValue);
                    labels.push(new Date().toLocaleTimeString('en-US', { hour: 'numeric', minute: 'numeric', second: 'numeric' }));
                    updateOrCreateChart();
                    updatePriceDisplay(floatValue, 530, 10000);
                })
                .catch(error => console.error("Error fetching stock price:", error));
        }
    </script>
</body>


</html>
