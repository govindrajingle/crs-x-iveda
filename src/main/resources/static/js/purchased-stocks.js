$(document).ready(function() {
	$.ajax({
		url: '/getTrades',
		type: 'GET',
		success: function(data) {
			if (data && data.length > 0) {
				var index = 1; // Initialize counter
				data.forEach(function(trade) {
					var buyDate = new Date(trade.buydate);
					var formattedBuyDate = buyDate.getDate() + '-' + buyDate.toLocaleString('default', { month: 'long' }) + '-' + buyDate.getFullYear();
					var row = '<tr>' +
						'<td>' + index + '</td>' +
						'<td>' + formattedBuyDate + '</td>' +
						'<td>' + trade.stockname + '</td>' +
						'<td>' + trade.buyprice + '</td>' +
						'<td>' + trade.sellprice + '</td>' +
						'<td>' + trade.profitlosspercentage + '</td>' +
						'<td>' + trade.netgainloss + '</td>' +
						'<td>' + trade.investmentamount + '</td>' +
						'<td>' + trade.amountinvested + '</td>' +
						'<td>' + trade.numberofshares + '</td>' +
						'<td>' + trade.tax + '</td>' +
						'<td>' + trade.holdtimedays + '</td>' +
						'</tr>';
					$('#tradesTable tbody').append(row);
					index++; // Increment counter
					// Add total balance to a new div after the table
					var formattedTotalBalance = '&#8377; ' + trade.balance.toFixed(2); // Assuming balance is a float number
					var totalBalanceRow = '<div style="padding: 20px;">Total Balance: ' + formattedTotalBalance + '</div>';
					$('#tradesTable').after(totalBalanceRow);
				});
			} else {
				console.log('No data received.');
			}
		},
		error: function(xhr, status, error) {
			console.log('Error:', error);
		}
	});

	$(document).on('click', '.delete-button', function() {
		var id = $(this).data('id');
		swal({
			title: "Are you sure?",
			text: "Once deleted, you will not be able to recover this trade data!",
			icon: "warning",
			buttons: true,
			dangerMode: true,
		})
			.then((willDelete) => {
				if (willDelete) {
					$.ajax({
						url: '/deleteTrade',
						type: 'POST',
						data: { id: id },
						success: function() {
							swal("Trade deleted successfully", {
								icon: "success",
							});
							location.reload(); // Reload the page to update the table
						},
						error: function() {
							swal("Error deleting trade", {
								icon: "error",
							});
						}
					});
				}
			});
	});
});