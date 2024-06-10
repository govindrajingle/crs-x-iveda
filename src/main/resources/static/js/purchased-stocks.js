$(document).ready(function() {
	$.ajax({
		url: '/getTrades',
		type: 'GET',
		success: function(data) {
			var index = 1; // Initialize counter
			data.forEach(function(trade) {
				var date = new Date(trade.buyDate);
				var formattedDate = date.getDate() + '-' + date.toLocaleString('default', { month: 'long' }) + '-' + date.getFullYear();
				$('#tradesTable').append('<tr><td>' + index + '</td><td>' + trade.stockName + '</td><td id="rupees">' + trade.buyPrice + '</td><td>' + formattedDate + '</td><td id="rupees">' + trade.investmentamount + '</td><td>' + trade.numberOfShares);
				//for delete
				//$('#tradesTable').append('<tr><td>' + index + '</td><td>' + trade.stockName + '</td><td id="rupees">' + trade.buyPrice + '</td><td>' + formattedDate + '</td><td id="rupees">' + trade.investmentamount + '</td><td>' + trade.numberOfShares + '</td><td><button class="delete-button" data-id="' + trade.id + '">Delete</button></td></tr>');
				index++; // Increment counter
			});
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