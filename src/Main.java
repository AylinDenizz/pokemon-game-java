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
        WeatherConditionEnum currentWeather = weatherService.randomWeather();
        System.out.println("Know the weather is " + currentWeather);

        weatherService.effectThePowerOfPokemon(player1, currentWeather);
        weatherService.effectThePowerOfPokemon(player2, currentWeather);



    }
}