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

    public void EffectThePowerOfPokemon(Player player, WeatherConditionEnum currentWeather) {
        Pokemon pokemon = player.getCharacter().getPokemonList().get(0);
        if (currentWeather == WeatherConditionEnum.HOT && pokemon.getName() == "Squirrel") {
            pokemon.setDamage((pokemon.getDamage()) * 8 / 10);
            System.out.println("Squirtle loose his power due to evaporation of water");
        } else if (currentWeather == WeatherConditionEnum.RAİNY && pokemon.getName() == "Pikachu") {
            pokemon.setDamage((pokemon.getDamage()) * 7 / 10);
            System.out.println("Pikachu loose his power due to electric current being affected by rain");
        } else if (currentWeather == WeatherConditionEnum.RAİNY && pokemon.getName() == "Charmender") {
            pokemon.setDamage((pokemon.getDamage()) * 9 / 10);
            System.out.println("Charmender loose his power due to the fire being extinguished by the rain");
        } else if (currentWeather == WeatherConditionEnum.WİNDY && pokemon.getName() == "Balbausar") {
            pokemon.setDamage((pokemon.getDamage()) * 6 / 10);
            System.out.println("Balbausar loose his power due to the leaves blowing in the wind");
        } else if (currentWeather == WeatherConditionEnum.SUNNY) {
            System.out.println("Weather daily sunshine. All pokemon retained their strength.");
        }
    }
}

