package service;

import model.Player;
import model.Pokemon;

import java.util.ArrayList;

public class CharacterService {
    LoadService loadService = new LoadService();

    public void choosePokemon(Player player, String player1Pokemon) {
        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();

        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getName().equals(player1Pokemon)) {


            }
        }

    }
}
