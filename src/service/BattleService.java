package service;

import model.Player;
import model.WeatherConditionEnum;

import java.util.Scanner;

public class BattleService {
    public void battleService(Player firstPlayer, Player secondPlayer, int indexOfPokemon1, int indexOfPokemon2) {
        PlayerService playerService = new PlayerService();
        WeatherService weatherService = new WeatherService();
        GameService gameService = new GameService();
        Scanner scanner = new Scanner(System.in);

        boolean battleFinish = false;

        int firstPlayerPokemonInitialDamage = firstPlayer.getCharacter().getPokemonList().get(indexOfPokemon1).getDamage();
        int secondPlayerPokemonInitialDamage = secondPlayer.getCharacter().getPokemonList().get(indexOfPokemon2).getDamage();


        while (!battleFinish) {
            //initial weather setted.
            firstPlayer.getCharacter().getPokemonList().get(indexOfPokemon1).setDamage(firstPlayerPokemonInitialDamage);
            secondPlayer.getCharacter().getPokemonList().get(indexOfPokemon2).setDamage(secondPlayerPokemonInitialDamage);

            WeatherConditionEnum currentWeather = weatherService.randomWeather();
            System.out.println("Now the weather is " + currentWeather);
            weatherService.effectThePowerOfPokemon(firstPlayer, currentWeather);
            weatherService.effectThePowerOfPokemon(secondPlayer, currentWeather);

            // 1. round attack move performed.
            System.out.println(firstPlayer.getName() + " Make your attack move!" + "\n -To make regular attack press 0 " +
                    "\n -To make PokeSpecialAttack press 1  " +
                    "\n -To make CharSpecialAttack press 2" + "\n -To make both press 3");
            int firstAttackMove = scanner.nextInt();
            gameService.makeAttack(firstPlayer, secondPlayer, firstAttackMove);
            System.out.println(secondPlayer.getCharacter().getPokemonList().get(indexOfPokemon2).getHealth());
            battleFinish = gameService.isBattleFinished(firstPlayer, secondPlayer);
            if (battleFinish == true) {
                break;
            }

            System.out.println(secondPlayer.getName() + " Make your attack move!" + "\n -To make regular attack press 0 " +
                    "\n -To make PokeSpecialAttack press 1  " +
                    "\n -To make CharSpecialAttack press 2" + "\n -To make both press 3");
            int secondAttackMove = scanner.nextInt();
            gameService.makeAttack(secondPlayer, firstPlayer, secondAttackMove);
            System.out.println(firstPlayer.getCharacter().getPokemonList().get(indexOfPokemon1).getHealth());
            battleFinish = gameService.isBattleFinished(firstPlayer, secondPlayer);
            if (battleFinish == true) {
                break;
            }

        }


    }

}
