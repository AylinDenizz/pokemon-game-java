package service;

import model.Character;
import model.Player;
import model.Pokemon;

import java.util.ArrayList;
import java.util.Random;

public class PlayerService {
    LoadService loadService = new LoadService();

    public Player createPlayer(String name, Character character) {
        Player player = new Player(name, character);
        return player;
    }

    public Player choosePlayer(String name, String playerCharacter) {
        Player player = new Player();

        if (playerCharacter.equals("ash")) {
            player = createPlayer(name, loadService.loadCharacters().get(0));

        } else if (playerCharacter.equals("broke")) {
            player = createPlayer(name, loadService.loadCharacters().get(1));
        } else {
            System.out.println("ERROR! Character doesn't exist.");
        }

        System.out.println(player);
        return player;

    }

    public Player randomStarter(Player player1, Player player2) {
        Random random = new Random();
        Player playerList[] = {player1, player2};
        int index = random.nextInt(2);
        return playerList[index];

    }
}

