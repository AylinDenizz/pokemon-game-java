import model.Player;
import model.Pokemon;
import model.WeatherConditionEnum;
import service.*;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CharacterService characterService = new CharacterService();
        GameService gameService = new GameService();
        WeatherService weatherService = new WeatherService();
        PlayerService playerService = new PlayerService();
        LoadService loadService = new LoadService();
        BattleService battleService = new BattleService();

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
        Player player1 = playerService.choosePlayer("player1", player1Character);


        // choosing second player's character
        System.out.println("Player 2, choose a character! \n 1- Ash \n 2- Broke");
        String player2Character = scanner.next().toLowerCase();
        Player player2 = playerService.choosePlayer("player2", player2Character);


        // choosing first player's pokemon
        System.out.println("Player 1, choose a pokemon! \n 1- Pikachu \n 2- Squirrel \n 3- Balbausar \n 4- Charmender");
        String player1Pokemon = scanner.next().toLowerCase();
        characterService.choosePokemon(player1, player1Pokemon);

        // choosing second player's pokemon
        System.out.println("Player 2, choose a pokemon! \n 1- Pikachu \n 2- Squirrel \n 3- Balbausar \n 4- Charmender");
        String player2Pokemon = scanner.next().toLowerCase();
        characterService.choosePokemon(player2, player2Pokemon);

        // Starting the fight with random player.
        System.out.println("Battle will start know !!! \n ROUND 1");

        Player firstPlayer = playerService.randomStarter(player1, player2);
        Player secondPlayer = new Player();
        if (firstPlayer.equals(player1)) {
            secondPlayer = player2;
        } else {
            secondPlayer = player1;
        }
        battleService.battleService(firstPlayer, secondPlayer, 0, 0);

        //round 2 starting.The winner of the first round will start first in this round. From now on, they will be
        // called by looser and winner from first round.
        Player winnerPlayer = new Player();
        Player looserPlayer = new Player();
        System.out.println("ROUND 2");
        if (player1.isWinner() == true) {
            winnerPlayer = player1;
            looserPlayer = player2;
        } else {
            winnerPlayer = player2;
            looserPlayer = player1;
        }

        // change pokemons of the players.
        looserPlayer.getCharacter().getPokemonList().get(0).setHealth(500);
        winnerPlayer.getCharacter().getPokemonList().add(looserPlayer.getCharacter().getPokemonList().get(0));
        ArrayList<Pokemon> looserPlayerPokemonList = new ArrayList<>();
        looserPlayerPokemonList.add(loadService.loadPokemons().get(3));
        looserPlayer.getCharacter().setPokemonList(looserPlayerPokemonList);

        //battle service called for attack movements.
        battleService.battleService(winnerPlayer, looserPlayer, 0, 0);
        if (looserPlayer.getCharacter().getPokemonList().get(0).getHealth() <= 0) {
            System.out.println(winnerPlayer.getName() + " is the winner!!!");
        } else if (winnerPlayer.getCharacter().getPokemonList().get(0).getHealth() <= 0) {
            battleService.battleService(winnerPlayer, looserPlayer, 1, 0);
            if (looserPlayer.getCharacter().getPokemonList().get(0).getHealth() <= 0) {
                System.out.println(winnerPlayer.getName() + " is the winner!!!");
            } else {
                System.out.println(looserPlayer.getName() + " is the winner!!!");
            }


        }
    }
}