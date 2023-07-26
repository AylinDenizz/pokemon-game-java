package service;

import model.Character;
import model.Player;
import model.Pokemon;

import java.util.ArrayList;

public class PlayerService {
    LoadService loadService = new LoadService();

    public Player createPlayer(String name, Character character) {
        Player player = new Player(name, character);
        return player;
    }

    public Player choosePlayer(String name, String playerCharacter) {
        Player player = new Player();

        if (playerCharacter.equals("ash") ) {
            player = createPlayer(name, loadService.loadCharacters().get(0));
        } else if (playerCharacter.equals("broke")) {
            player = createPlayer(name, loadService.loadCharacters().get(1));
        } else {
            System.out.println("ERROR! Character doesn't exist.");
        }
        System.out.println(player);
        return player;
    }




}
