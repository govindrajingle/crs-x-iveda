fetch('/profitorloss')
	.then(response => response.json())
	.then(data => {
		let groupedData = data.reduce((acc, item) => {
			let date = new Date(item.current_date).toLocaleDateString('en-GB', { day: '2-digit', month: 'long' });
			if (!acc[date]) {
				acc[date] = [];
			}
			acc[date].push(item);
			return acc;
		}, {});

		let averagedData = Object.keys(groupedData).map(date => {
			let items = groupedData[date];
			let averageProfitOrLossPercentage = items.reduce((acc, item) => {
				let percentage = item.sellprice < item.buyprice ? -item.profitorlosspercentage : item.profitorlosspercentage;
				return acc + percentage;
			}, 0) / items.length;
			return {
				date: date,
				profitorlosspercentage: Number(averageProfitOrLossPercentage.toFixed(2)), // Format to 2 decimal places
			};
		});

		let labels = averagedData.map(item => item.date); // Use 'date' property directly
		let profitOrLossPercentage = averagedData.map(item => item.profitorlosspercentage);
		let profitData = profitOrLossPercentage.map(value => value >= 0 ? value : null);
		let lossData = profitOrLossPercentage.map(value => value < 0 ? value : null);
		let ctx = document.getElementById('myChart').getContext('2d');
		let myChart = new Chart(ctx, {
			type: 'bar',
			data: {
				labels: labels,
				datasets: [{
					label: 'Profit ',
					data: profitData,
					additionalData: data, // Add this line to store all data
					backgroundColor: 'rgba(144, 238, 144, 0.2)', // light green for profit
					borderColor: 'rgba(144, 238, 144, 1)', // light green for profit
					borderWidth: 2
				},
				{
					label: 'Loss ',
					data: lossData,
					additionalData: data, // Add this line to store all data
					backgroundColor: 'rgba(255, 99, 71, 0.2)', // light red for loss
					borderColor: 'rgba(255, 99, 71, 1)', // light red for loss
					borderWidth: 2
				}]
			},
			options: {
				scales: {
					y: {
						beginAtZero: true,
						ticks: {
							callback: function(value, index, values) {
								return value + '%'; // Add '%' symbol to y-axis labels
							}
						}
					}
				},
				tooltips: {
					callbacks: {
						label: function(tooltipItem, data) {
							let item = data.datasets[tooltipItem.datasetIndex].additionalData[tooltipItem.index];
							return [
								'Stock Name: ' + item.stockname,
								'Buy Price: ' + item.buyprice,
								'Sell Price: ' + item.sellprice,
								'Profit/Loss Percentage: ' + item.profitorlosspercentage,
								'Total Profit or Loss: ' + item.totalprofitorloss,
								'Amount After Profit/Loss: ' + item.amountafterprofitloss,
								'Amount Invested: ' + item.amountinvested,
								'Tax Amount: ' + item.taxamount,
								'Number of Shares: ' + item.numberofsharesrounded
							];
						}
					}
				}
			}
		});
	});