// homepage.js

document.addEventListener("DOMContentLoaded", function() {
	// Make AJAX call to fetch data
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "maxIdRow", true); // Assuming "/maxIdRow" is the endpoint that returns the data
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			var data = JSON.parse(xhr.responseText);
			updateData(data);
		}
	};
	xhr.send();
});

function updateData(data) {
    // Apply typewriter effect to each data point
    typeWriterEffect("totalProfitValue", "\u20B9 " + data.totalProfit.toFixed(2));
    typeWriterEffect("totalTurnoverValue", "\u20B9 " + data.totalTurnover.toFixed(2));
    const fixedDate = new Date('2024-06-07');
    const currentDate = new Date();
    const differenceMs = currentDate - fixedDate;
    const daysDifference = Math.floor(differenceMs / (1000 * 60 * 60 * 24));
    typeWriterEffect("totalTimeValue", daysDifference + " days");
    //typeWriterEffect("totalTimeValue", data.totalTime + " days");
    typeWriterEffect("totalTaxValue", "\u20B9 " + data.totalTax.toFixed(2));
    typeWriterEffect("profitPercentageValue", data.profitPercentage.toFixed(2) + "%");
}

// Typewriter effect
function typeWriterEffect(elementId, text) {
	const element = document.getElementById(elementId);
	//element.classList.add('dodger-blue'); // Add light green color class
	let charIndex = 0;
	element.textContent = ''; // Clear existing content

	function typeWriter() {
		if (charIndex < text.length) {
			element.textContent += text.charAt(charIndex);
			charIndex++;
			setTimeout(typeWriter, 50); // Adjust typing speed here (milliseconds)
		}
	}

	typeWriter();
}
