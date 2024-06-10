// save-trade.js
document.getElementById('saveyourtrade').addEventListener('submit', function(event) {
	event.preventDefault(); // Prevent the form from submitting normally

	var stockName = document.getElementById('stockName').value;
	var buyPrice = parseFloat(document.getElementById('buyPrice').value); // Convert to number
	var buyDate = new Date(document.getElementById('buyDate').value);
	var amount = parseFloat(document.getElementById('amount').value); // Convert to number

	// Format date as dd-mm-yyyy
	var day = String(buyDate.getDate()).padStart(2, '0');
	var month = String(buyDate.getMonth() + 1).padStart(2, '0'); // Months are 0-based in JavaScript
	var year = buyDate.getFullYear();
	var formattedBuyDate = day + '-' + month + '-' + year;
	var numberOfShares = Math.floor(amount / buyPrice); // Calculate number of shares
	var investedAmount = numberOfShares * buyPrice; // Calculate invested amount
	var amountRemaining = amount - investedAmount; // Calculate remaining amount

	var data = {
		stockName: stockName,
		buyPrice: buyPrice,
		buyDate: formattedBuyDate,
		amount: amount,
		numberOfShares: numberOfShares, // Add number of shares to data
		investedAmount: investedAmount, // Add invested amount to data
		amountRemaining: amountRemaining // Add remaining amount to data
	};

	Swal.fire({
		title: 'Are you sure?',
		text: "You are about to save the trade data.",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Yes, save it!'
	}).then((result) => {
		if (result.isConfirmed) {
			var xhr = new XMLHttpRequest();
			xhr.open('POST', '/savetradedata', true);
			xhr.setRequestHeader('Content-Type', 'application/json');
			xhr.send(JSON.stringify(data));

			xhr.onload = function() {
				if (xhr.status === 200) {
					Swal.fire(
						'Success!',
						'Trade saved successfully',
						'success'
					);
					// Clear input fields
					document.getElementById('saveyourtrade').reset();
				} else {
					Swal.fire(
						'Error!',
						'Error saving trade',
						'error'
					);
				}
			};
		}
	});
});