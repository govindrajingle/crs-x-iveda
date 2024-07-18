$(document).ready(function() {
	$.ajax({
		url: 'profitorloss',
		method: 'GET',
		success: function(data) {
			renderChart(data);
		}
	});
});

function renderChart(data) {
	var daysInMonth = getDaysInCurrentMonth();
	var labels = Array.from({ length: daysInMonth }, (_, i) => i + 1); // Array of days in current month
	var values = new Array(daysInMonth).fill(0); // Array to hold profit/loss percentages for each day
	var remainingData = [];
	// Process the data
	data.forEach(function(item) {
		var currentDate = new Date(item.currentdate);
		var currentMonth = currentDate.getMonth();
		var currentDateOfMonth = currentDate.getDate();
		var remaining = {
			'stockname':item.stockname,
			'currentdate': item.currentdate,
			'buyprice': item.buyprice,
			'investmentamount': item.investmentamount,
			'amountinvested': item.amountinvested,
			'amountremaining': item.amountremaining,
			'numberofshares': item.numberofshares,
			'buydate': item.buydate,
			'sellprice': item.sellprice,
			'tax': item.tax,
			'netgainloss': item.netgainloss,
			'holdtimedays': item.holdtimedays,
			'balance': item.balance
		};
		remainingData.push(remaining);
		// Only include data for the current month
		if (currentMonth === new Date().getMonth()) {
			// Update values array with profit/loss percentage for the current day
			values[currentDateOfMonth - 1] += item.profitlosspercentage;
		}
	});

	var ctx = document.getElementById('profitLossChart').getContext('2d');
	var chart = new Chart(ctx, {
		type: 'bar', // Change chart type to line
		data: {
			labels: labels,
			datasets: [{
				label: 'Daily Profit/Loss Percentage',
				data: values,
				backgroundColor: 'rgba(75, 192, 192, 0.2)',
				borderColor: 'rgba(75, 192, 192, 1)',
				borderWidth: 1,
				fill: false // Ensure the line chart is not filled
			}]
		},
		options: {
			scales: {
				x: {
					title: {
						display: true,
						text: 'Day of the Month'
					}
				},
				y: {
					title: {
						display: true,
						text: 'Total Profit/Loss Percentage'
					},
					beginAtZero: true
				}
			},
			plugins: {
				tooltip: {
					callbacks: {
						label: function(context) {
							var index = context.dataIndex;
							// Construct the tooltip label using the remaining data
							return `Profit: ${context.raw.toFixed(2)}%`;
						}
					}
				}
			}
		}
	});
}

// Function to get the number of days in the current month
function getDaysInCurrentMonth() {
	var now = new Date();
	return new Date(now.getFullYear(), now.getMonth() + 1, 0).getDate();
}
