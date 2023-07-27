package service;

import model.*;
import model.Character;

import java.util.ArrayList;

public class LoadService {
    public ArrayList<Character> loadCharacters(){
        SpecialPower strategy1 = new Strategy("Strategy", 50, 1);
        SpecialPower strategy2 = new Strategy("Strategy II", 30, 2);

        Character ash = new Ash("Ash", strategy1, null);
        Character brooke = new Brooke("Brooke", strategy2, null);

        ArrayList<Character> characterList = new ArrayList<>();
        characterList.add(ash);
        characterList.add(brooke);
        return characterList;
    }

    public ArrayList<Pokemon> loadPokemons(){
        SpecialPower electricity = new Electricity("Electricty", 20, 3);
        SpecialPower water = new Water("Water", 50, 4);
        SpecialPower fire = new Fire("Fire", 30, 2);
        SpecialPower earth = new Earth("Earth", 60, 3);

        Pokemon pokemon1 = new Pikachu("pikachu", 500, 80, TypeEnum.ELECTRICY, electricity);
        Pokemon pokemon2 = new Sqiurtle("squirrel", 500, 50, TypeEnum.WATER, water);
        Pokemon pokemon3 = new Charmander("charmender", 500, 70, TypeEnum.FIRE, fire);
        Pokemon pokemon4 = new Balbausar("balbausar", 500, 40, TypeEnum.EARTH, earth);

        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);
        pokemonList.add(pokemon3);
        pokemonList.add(pokemon4);

        return pokemonList;
    }
}
