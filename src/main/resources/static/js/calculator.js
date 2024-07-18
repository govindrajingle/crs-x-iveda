document.addEventListener('DOMContentLoaded', function() {
	document.getElementById('calculatorForm').addEventListener('submit', function(event) {
		event.preventDefault(); // Prevent form submission
		var buyPrice = parseFloat(document.getElementById('buyPrice').value);
		var sellPrice = parseFloat(document.getElementById('sellPrice').value);
		var investmentAmount = parseFloat(document.getElementById('investmentAmount').value);
		var orderType = document.getElementById('orderType').value.trim().toUpperCase();
		var resultElement = document.getElementById('result');
		var numberOfShares = Math.floor(investmentAmount / buyPrice);
		var turnover = (buyPrice * numberOfShares) + (sellPrice * numberOfShares);
		var additionalAmount;
		if (orderType === 'MIS') {
			additionalAmount = turnover * 0.03 / 100;
		} else if (orderType === 'CIN') {
			additionalAmount = turnover * (0.11 / 100) + (0.012 % turnover);
		}
		var grossIncome = (sellPrice - buyPrice) * numberOfShares;
		var netIncome = grossIncome - additionalAmount;
		var percentageReturn = (netIncome / investmentAmount) * 100;
		var profitLossClass = netIncome >= 0 ? 'profit' : 'loss';
		var popup = document.getElementById('popup');
		var popupContent = document.getElementById('popup-content');
		popupContent.innerHTML = `
            <p>Order Type: ${orderType}</p>
            <p>Number of Shares: ${numberOfShares}</p>
            <p>Turnover: ${turnover.toFixed(2)}</p>
            <p>Tax: ${additionalAmount.toFixed(2)}</p>
            <p>Net Income: ${netIncome.toFixed(2)}</p>
            <p>Percentage Return: ${percentageReturn.toFixed(2)}%</p>
        `;
		var mainContainer = document.querySelector('.main-container');
		mainContainer.classList.add('blur-background');
		var popup = document.getElementById('popup');
		popup.classList.add('show-popup');

		// Add event listener to remove blur when clicking anywhere on the page
		document.addEventListener('click', function(event) {
			var isClickInsidePopup = popup.contains(event.target);
			if (!isClickInsidePopup) {
				mainContainer.classList.remove('blur-background');
				popup.classList.remove('show-popup');
			}
		});
	});
});
