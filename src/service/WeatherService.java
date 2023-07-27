package service;

import model.Player;
import model.Pokemon;
import model.Sqiurtle;
import model.WeatherConditionEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherService {
    public WeatherConditionEnum randomWeather() {
        Random random = new Random();
        List<WeatherConditionEnum> weathers = new ArrayList<>();
        for (WeatherConditionEnum weather : WeatherConditionEnum.values()) {
            weathers.add(weather);
        }
        int index = random.nextInt(weathers.size());
        return weathers.get(index);
    }

    public void effectThePowerOfPokemon(Player player, WeatherConditionEnum currentWeather) {
        Pokemon pokemon = player.getCharacter().getPokemonList().get(0);
        if (currentWeather.equals( WeatherConditionEnum.HOT) && pokemon.getName().equals("squirrel")) {
            pokemon.setDamage((pokemon.getDamage()) * 8 / 10);
            System.out.println("Squirtle loose his power due to evaporation of water.New Damage=" + pokemon.getDamage());
        } else if (currentWeather.equals( WeatherConditionEnum.RAİNY )&& pokemon.getName().equals("pikachu")) {
            pokemon.setDamage((pokemon.getDamage()) * 7 / 10);
            System.out.println("Pikachu loose his power due to electric current being affected by rain.New Damage=" + pokemon.getDamage());
        } else if (currentWeather.equals(WeatherConditionEnum.RAİNY) && pokemon.getName().equals( "charmender") ){
            pokemon.setDamage((pokemon.getDamage()) * 9 / 10);
            System.out.println("Charmender loose his power due to the fire being extinguished by the rain. New Damage=" + pokemon.getDamage());
        } else if (currentWeather.equals( WeatherConditionEnum.WİNDY) && pokemon.getName().equals( "balbausar")) {
            pokemon.setDamage((pokemon.getDamage()) * 6 / 10);
            System.out.println("Balbausar loose his power due to the leaves blowing in the wind.New Damage=" + pokemon.getDamage());
        } else if (currentWeather == WeatherConditionEnum.SUNNY) {
            System.out.println("Weather daily sunshine. All pokemon retained their strength.");
        } else {
            System.out.println("wheather is " + currentWeather.name() + pokemon.getName() + " retained his strength.");
        }
    }
}

