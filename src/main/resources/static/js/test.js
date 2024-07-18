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