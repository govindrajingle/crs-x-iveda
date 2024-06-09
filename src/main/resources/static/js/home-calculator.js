var formData = {};

document.getElementById('calculatorForm').addEventListener('submit', function(event) {
	event.preventDefault();
	var buyPrice = parseFloat(document.getElementById('buyPrice').value);
	var sellPrice = parseFloat(document.getElementById('sellPrice').value);
	var investmentAmount = parseFloat(document.getElementById('investmentAmount').value);
	var resultElement = document.getElementById('result');
	var taxAmount = 370;
	//var numberOfShares = investmentAmount / buyPrice;
	var numberOfSharesRounded = Math.floor(investmentAmount / buyPrice);
	var profitOrLoss = (sellPrice - buyPrice) * numberOfSharesRounded;
	var amountAfterProfitLoss = investmentAmount + profitOrLoss - taxAmount;
	var tableContent = "<table><tr><th>Title</th><th>Value</th></tr>";


	var profitOrLossPercentage;

	if (profitOrLoss >= 0) {
		profitOrLossPercentage = ((sellPrice - buyPrice) / buyPrice) * 100;
		tableContent += "<tr><td>Profit Percentage</td><td class='profit'>" + profitOrLossPercentage.toFixed(2) + "%</td></tr>";
	} else {
		profitOrLossPercentage = -Math.abs(((buyPrice - sellPrice) / buyPrice) * 100);
		tableContent += "<tr><td>Loss Percentage</td><td class='loss'>" + profitOrLossPercentage.toFixed(2) + "%</td></tr>";
	}

	tableContent += "<tr><td>Net Gain/Loss</td><td>₹ " + profitOrLoss.toFixed(2) + "</td></tr>";
	tableContent += "<tr><td>Amount after profit/loss and tax</td><td>&#8377 " + amountAfterProfitLoss.toFixed(2) + "</td></tr>";
	tableContent += "<tr><td class='white-text'>Amount Invested</td><td class='white-text'>&#8377 " + (buyPrice * numberOfSharesRounded).toFixed(2) + "</td></tr>";
	tableContent += "<tr><td class='white-text'>Amount Remaining</td><td class='white-text'>&#8377 " + (investmentAmount - (buyPrice * numberOfSharesRounded)).toFixed(2) + "</td></tr>";
	tableContent += "<tr><td class='white-text'>Number of Shares</td><td class='white-text'>" + numberOfSharesRounded.toFixed(2) + "</td></tr>";
	tableContent += "<tr><td class='red-text'>Tax Amount</td><td class='red-text'>&#8377 " + taxAmount.toFixed(2) + "</td></tr>";
	tableContent += "</table>";

	resultElement.innerHTML = tableContent;

	// Change color of amount after profit/loss based on condition
	resultElement.style.color = amountAfterProfitLoss >= investmentAmount ? '#00FF00' : '#FF0000';

	formData = {
		stockName: document.getElementById("stockName").value,
		buyPrice: parseFloat(document.getElementById("buyPrice").value),
		sellPrice: parseFloat(document.getElementById("sellPrice").value),
		investmentAmount: parseFloat(document.getElementById("investmentAmount").value),
		totalProfitOrLoss: profitOrLoss,
		amountAfterProfitLoss: amountAfterProfitLoss,
		amountInvested: (buyPrice * numberOfSharesRounded),
		amountRemaining: (investmentAmount - (buyPrice * numberOfSharesRounded)),
		taxAmount: taxAmount,
		numberOfSharesRounded: numberOfSharesRounded,
		profitOrLossPercentage: profitOrLossPercentage
	};

	// Display the "Save Data" button after calculation
	document.getElementById('saveData').style.display = 'block';

});

document.getElementById('saveData').addEventListener('click', function() {
	swal({
		title: "Are you sure?",
		text: "Once saved, you will not be able to change the data!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willSave) => {
			if (willSave) {
				fetch('/calculate', {
					method: 'POST',
					headers: {
						'Content-Type': 'application/json'
					},
					body: JSON.stringify(formData)
				})
					.then(response => response.text())
					.then(data => {
						swal("Your data has been saved!", {
							icon: "success",
						}).then(() => {
							location.reload(); // Refresh the page
						});
					})
					.catch(error => {
						console.error('Error:', error);
						swal("Error!", "There was an error saving your data. Please try again.", "error");
					});
			} else {
				swal("Your data is not saved!");
			}
		});
});

