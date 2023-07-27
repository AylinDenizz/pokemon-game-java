import model.Player;
import model.WeatherConditionEnum;
import service.*;

import javax.xml.transform.Source;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CharacterService characterService = new CharacterService();
        GameService gameService = new GameService();
        WeatherService weatherService = new WeatherService();
        PlayerService playerService = new PlayerService();
        LoadService loadService = new LoadService();

        // game starting
        boolean isStart = false;
        while (isStart) {
            System.out.println("press any key to start the game");
            if (scanner.next().isBlank() == false) {
                isStart = true;
            }
        }
        // choosing first player's character
        System.out.println("Player 1, choose a character! \n 1- Ash \n 2- Broke");
        String player1Character = scanner.next().toLowerCase();
        Player player1 =playerService.choosePlayer("player1", player1Character);


        // choosing second player's character
        System.out.println("Player 2, choose a character! \n 1- Ash \n 2- Broke");
        String player2Character = scanner.next().toLowerCase();
        Player player2 =playerService.choosePlayer("player2", player2Character);


        // choosing first player's pokemon
        System.out.println("Player 1, choose a pokemon! \n 1- Pikachu \n 2- Squirrel \n 2- Balbausar \n 2- Charmender");
        String player1Pokemon = scanner.next().toLowerCase();
        characterService.choosePokemon(player1, player1Pokemon);

        // choosing second player's pokemon
        System.out.println("Player 2, choose a pokemon! \n 1- Pikachu \n 2- Squirrel \n 2- Balbausar \n 2- Charmender");
        String player2Pokemon = scanner.next().toLowerCase();
        characterService.choosePokemon(player2, player2Pokemon);

        // Starting the fight
        System.out.println("Battle will start know !!!");
        boolean battleFinish = false;
        int player1pokemonInitialDamage = player1.getCharacter().getPokemonList().get(0).getDamage();
        int player2pokemonInitialDamage = player2.getCharacter().getPokemonList().get(0).getDamage();

        while(!battleFinish) {
            //initial weather setted.

            WeatherConditionEnum currentWeather = weatherService.randomWeather();
            System.out.println("Now the weather is " + currentWeather);
            weatherService.effectThePowerOfPokemon(player1, currentWeather);
            weatherService.effectThePowerOfPokemon(player2, currentWeather);

            // 1. round attack move performed.
            System.out.println(player1.getName() + "Make your attack move!" + "\n To make regular attack press 0 " +
                    "\n To make PokeSpecialAttack press 1  " +
                    "\n To make CharSpecialAttack press 2" + "\n To make both press 3");
            int firstAttackMove = scanner.nextInt();
            gameService.makeAttack(player1, player2, firstAttackMove);
            System.out.println(player2);

            System.out.println(player2.getName() + "Make your attack move!" + "\n To make regular attack press 0 " +
                    "\n To make PokeSpecialAttack press 1  " +
                    "\n To make CharSpecialAttack press 2" + "\n To make both press 3");
            int secondAttackMove = scanner.nextInt();
            gameService.makeAttack(player2, player1, secondAttackMove);
            System.out.println(player1);

            // is battle finished. Check the health bars.
            if (player1.getCharacter().getPokemonList().get(0).getHealth() <= 0) {
                player1.setWinner(false);
                player2.setWinner(true);
                System.out.println(player1.getName() +  " is the winner");
                battleFinish = true;
            } else if  (player2.getCharacter().getPokemonList().get(0).getHealth() <= 0){
                player1.setWinner(true);
                player2.setWinner(false);
                System.out.println(player2.getName() +  " is the winner");
                battleFinish = true;
            } else {
                System.out.println(player1.getName() + "health is : " + player1.getCharacter().getPokemonList().get(0).getHealth());
                System.out.println(player2.getName() + "health is : " + player2.getCharacter().getPokemonList().get(0).getHealth());

                battleFinish = false;
            }

        }



    }
}