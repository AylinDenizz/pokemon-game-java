package service;

import model.Player;
import model.Pokemon;

import java.util.ArrayList;

public class CharacterService {
    LoadService loadService = new LoadService();

    public void choosePokemon(Player player, String player1Pokemon) {
        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();
        System.out.println(pokemonList);
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
            System.out.println(player.getCharacter().getPokemonList());
        }
        System.out.println(player.getName() + " choosed " + player1Pokemon.toLowerCase());
    }

}

