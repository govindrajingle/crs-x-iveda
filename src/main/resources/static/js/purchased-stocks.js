$(document).ready(function() {
	$(document).ready(function() {
		$.ajax({
			url: 'getTrades',
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
							'<td>' + trade.profitlosspercentage + '</td>' +
							'<td>' + '&#8377; ' + trade.netgainloss + '</td>' +
							'<td><button class="expand-details-button">+</button></td>' +
							'</tr>';
						var detailsRow = '<tr class="details-row" style="display: none;">' +
							'<td colspan="6" style="padding: 10px;">' + // Spanning all columns with some padding
							'<div style="border: 1px solid #ccc; padding: 10px; display: flex;">' + // Outer container with border and padding
							'<div style="flex: 1; text-align: left;">' + // Left container with flex-grow: 1 and left alignment
							'<div style="margin-bottom: 5px;">Buy Price:</div>' +
							'<div style="margin-bottom: 5px;">Sell Price:</div>' +
							'<div style="margin-bottom: 5px;">Total Amount:</div>' +
							'<div style="margin-bottom: 5px;">Invested Amount:</div>' +
							'<div style="margin-bottom: 5px;">Number of Shares:</div>' +
							'<div style="margin-bottom: 5px;">Tax:</div>' +
							'<div style="margin-bottom: 5px;">Hold Time Days:</div>' +
							'</div>' + // End of left container
							'<div style="flex: 1; text-align: right;">' + // Right container with flex-grow: 1 and right alignment
							'<div style="margin-bottom: 5px;">' + '&#8377; ' + trade.buyprice + '</div>' +
							'<div style="margin-bottom: 5px;">' + '&#8377; ' + trade.sellprice + '</div>' +
							'<div style="margin-bottom: 5px;">' + '&#8377; ' + trade.investmentamount + '</div>' +
							'<div style="margin-bottom: 5px;">' + '&#8377; ' + trade.amountinvested + '</div>' +
							'<div style="margin-bottom: 5px;">' + trade.numberofshares + '</div>' +
							'<div style="margin-bottom: 5px;">' + '&#8377; ' + trade.tax + '</div>' +
							'<div style="margin-bottom: 5px;">' + trade.holdtimedays + '</div>' +
							'</div>' + // End of right container
							'</div>' + // End of outer container
							'</td>' +
							'</tr>';




						$('#tradesTable tbody').append(row + detailsRow);
						index++; // Increment counter
						// Add total balance to a new div after the table
						var formattedTotalBalance = '&#8377; ' + trade.balance.toFixed(2); // Assuming balance is a float number
						var totalBalanceRow = '<div id="totalBalance" style="padding: 20px; cursor: pointer; display: none;">Total Balance: ' + formattedTotalBalance + '</div>';
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

		$(document).on('click', '.expand-details-button', function() {
			var $detailsRow = $(this).closest('tr').next('.details-row');
			$detailsRow.toggle(); // Toggle visibility of the details row

			// Toggle the text content of the button between '+' and '-'
			var buttonText = $(this).text().trim();
			$(this).text(buttonText === '+' ? '-' : '+');
		});

	});
});