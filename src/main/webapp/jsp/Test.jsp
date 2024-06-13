<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Random Pokémon Name</title>
<link rel="stylesheet" href="/css/home-calculator.css">
<link rel="icon" type="image/png" href="/favicon/favicon.png">
<script>
function getRandomPokemonName() {
  fetch('https://pokeapi.co/api/v2/pokemon?limit=1000')
    .then(response => response.json())
    .then(data => {
      const randomIndex = Math.floor(Math.random() * data.results.length);
      const randomPokemon = data.results[randomIndex];
      document.getElementById('pokemonName').innerText = randomPokemon.name;
    })
    .catch(error => {
      console.error('Error fetching random Pokémon:', error);
    });
}
</script>
</head>
<body>

<h1>Random Pokemon Name:</h1>
<button id="fetchData"onclick="getRandomPokemonName()">Get Random Pokémon Name</button>
<p id="pokemonName"></p>
</body>
</html>
