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
			let averageProfitOrLossPercentage = items.reduce((acc, item) => acc + item.profitorlosspercentage, 0) / items.length;
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
			type: 'line',
			data: {
				labels: labels,
				datasets: [{
					label: 'Profit %',
					data: profitData,
					additionalData: data, // Add this line to store all data
					backgroundColor: 'rgba(144, 238, 144, 0.2)', // light green for profit
					borderColor: 'rgba(144, 238, 144, 1)', // light green for profit
					borderWidth: 2
				},
				{
					label: 'Loss %',
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
				}
			}
		});
	});
// show extra information on hover
/*tooltips: {
	callbacks: {
		label: function(tooltipItem, data) {
			let dataset = data.datasets[tooltipItem.datasetIndex];
			let currentValue = dataset.data[tooltipItem.index];
			let item = dataset.additionalData[tooltipItem.index]; // assuming you have stored additional data in your dataset
			let customTooltip = [];
			customTooltip.push(`${dataset.label}: ${currentValue}`);
			//customTooltip.push(`Stock Name : ${item.stockname}`);
			customTooltip.push(`Buy Price ₹ ${item.buyprice}`);
			customTooltip.push(`Sell Price ₹ ${item.sellprice}`);
			customTooltip.push(`Investment Amount ₹ ${item.investmentamount}`);
			customTooltip.push(`Total Profit or Loss ₹ ${item.totalprofitorloss}`);
			customTooltip.push(`Amount After Profit or Loss ₹ ${item.amountafterprofitloss}`);
			customTooltip.push(`Amount Invested ₹ ${item.amountinvested}`);
			//customTooltip.push(`Amount Remaining ₹ ${item.amountremaining}`);
			customTooltip.push(`Tax Amount ₹ ${item.taxamount}`);
			customTooltip.push(`Number of Shares: ${item.numberofsharesrounded}`);
			return customTooltip;
		}
	}
}*/
/*}
});
});*/