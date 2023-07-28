package service;

import model.Player;
import model.Pokemon;

public class GameService {

    public void attack(Player attacker, Player defender, boolean isPokeSpecialAttack, boolean isCharSpecialAttack, int indexofAtacker, int indexofDefending ) {
        Pokemon attackingPokemon = attacker.getCharacter().getPokemonList().get(indexofAtacker);
        Pokemon defendingPokemon = defender.getCharacter().getPokemonList().get(indexofDefending);

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

    public void makeAttack(Player attacker, Player defender, int attackMove, int indexofAtacker, int indexofDefending) {
        if (attackMove == 0) {
            attack(attacker, defender, false, false, indexofAtacker, indexofDefending);
        } else if (attackMove == 1) {
            attack(attacker, defender, true, false, indexofAtacker, indexofDefending);
        } else if (attackMove == 2) {
            attack(attacker, defender, false, true, indexofAtacker, indexofDefending);
        } else if (attackMove == 3) {
            attack(attacker, defender, true, true,  indexofAtacker, indexofDefending);
        }
    }



    // is battle finished. Check the health bars.
    public boolean isBattleFinished(Player firstPlayer, Player secondPlayer, int indexOfFirstPokemon, int indexOfSecondPokemon) {
        boolean battleFinish = false;

        if (secondPlayer.getCharacter().getPokemonList().get(indexOfSecondPokemon).getHealth() <= 0) {
            firstPlayer.setWinner(true);
            secondPlayer.setWinner(false);
            System.out.println(firstPlayer.getName() + " is the winner of this round");
            battleFinish = true;
        } else if (firstPlayer.getCharacter().getPokemonList().get(indexOfFirstPokemon).getHealth() <= 0) {
            firstPlayer.setWinner(false);
            secondPlayer.setWinner(true);
            System.out.println(secondPlayer.getName() + " is the winner of this round");
            battleFinish = true;
        } else {
            System.out.println(firstPlayer.getCharacter().getPokemonList().get(indexOfFirstPokemon) + " health is : " + firstPlayer.getCharacter().getPokemonList().get(indexOfFirstPokemon).getHealth());
            System.out.println(secondPlayer.getCharacter().getPokemonList().get(indexOfSecondPokemon) + " health is : " + secondPlayer.getCharacter().getPokemonList().get(indexOfSecondPokemon).getHealth());

            battleFinish = false;
        }
        return battleFinish;
    }


}
