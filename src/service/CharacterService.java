package service;

import model.Player;
import model.Pokemon;

import java.util.ArrayList;

public class CharacterService {
    LoadService loadService = new LoadService();

    public void choosePokemon(Player player, String player1Pokemon) {
        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getName().equals(player1Pokemon.toLowerCase())) {
                if (player.getCharacter().getPokemonList() != null) {
                    player.getCharacter().getPokemonList().add(pokemon);
                } else {
                    ArrayList<Pokemon> pokemonListInPlayer = new ArrayList<>();
                    pokemonListInPlayer.add(pokemon);
                    player.getCharacter().setPokemonList(pokemonListInPlayer);
                }
            }
        }
        System.out.println(player.getName() + " choosed " + player1Pokemon.toLowerCase());
        System.out.println(player + " pokemon list has: " +  player.getCharacter().getPokemonList());
    }

}

