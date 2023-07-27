package service;

import model.Player;
import model.Pokemon;

public class GameService {

    public void attack(Player attacker, Player defender, boolean isPokeSpecialAttack, boolean isCharSpecialAttack) {
        Pokemon attackingPokemon = attacker.getCharacter().getPokemonList().get(0);
        Pokemon defendingPokemon = defender.getCharacter().getPokemonList().get(0);

        boolean specialAttack = false;
        if (isPokeSpecialAttack && isCharSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainingRights() > 0
                    && attacker.getCharacter().getSpecialPower().getRemainingRights() > 0;
        } else if (isPokeSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainingRights() > 0;
        } else if (isCharSpecialAttack) {
            specialAttack = attacker.getCharacter().getSpecialPower().getRemainingRights() > 0;
        }

        int charRemainingRights = attacker.getCharacter().getSpecialPower().getRemainingRights();

        int damage = 0;
        if (specialAttack) {
            if (isPokeSpecialAttack && isCharSpecialAttack) {
                damage += attackingPokemon.specialAttack();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                attacker.getCharacter().getSpecialPower().setRemainingRights(charRemainingRights - 1);
            } else if (isPokeSpecialAttack) {
                damage += attackingPokemon.specialAttack();
            } else {
                damage += attackingPokemon.getDamage();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                attacker.getCharacter().getSpecialPower().setRemainingRights(charRemainingRights - 1);
            }
        } else {
            if (isPokeSpecialAttack || isCharSpecialAttack) {
            } else {
                damage += attackingPokemon.getDamage();
            }
        }

        defendingPokemon.setHealth(defendingPokemon.getHealth() - damage);
    }

    public void makeAttack( Player attacker, Player defender, int attackMove ) {
        switch (attackMove) {
            case 0:
                attack(attacker, defender ,false, false);
            case 1:
                attack(attacker, defender ,true, false);
            case 2:
                attack(attacker, defender,false, true);
            case 3:
                attack(attacker, defender ,true, true);
        }
    }

    // is battle finished. Check the health bars.
    public boolean isBattleFinished(Player firstPlayer, Player secondPlayer) {
        boolean battleFinish = false;

        if (secondPlayer.getCharacter().getPokemonList().get(0).getHealth() <= 0) {
            firstPlayer.setWinner(true);
            secondPlayer.setWinner(false);
            System.out.println(firstPlayer.getName() +  " is the winner of the first round");
            battleFinish = true;
        } else if  (firstPlayer.getCharacter().getPokemonList().get(0).getHealth() <= 0){
            firstPlayer.setWinner(false);
            secondPlayer.setWinner(true);
            System.out.println(secondPlayer.getName() +  " is the winner of the first round");
            battleFinish = true;
        } else {
            System.out.println(firstPlayer.getName() + "health is : " + firstPlayer.getCharacter().getPokemonList().get(0).getHealth());
            System.out.println(secondPlayer.getName() + "health is : " + secondPlayer.getCharacter().getPokemonList().get(0).getHealth());

            battleFinish = false;
        }
        return  battleFinish;
    }



}
