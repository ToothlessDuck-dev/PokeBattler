package org.example.Menu;

import org.example.input.InputHelper;
import org.example.model.Pokemon;
import org.example.model.Attack;
import java.util.Scanner;

public class PlayerAttackSelector {

    // Låter spelaren välja en attack från sin Pokémon
    public Attack chooseAttack(Scanner scan, Pokemon pokemon){

        // Visar alla attacker som Pokémonen kan använda
        System.out.println("\nChoose an attack for " + pokemon.getName() + ":");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < pokemon.getAttacks().size(); i++){
            Attack attack = pokemon.getAttacks().get(i);

            System.out.printf(
                    "[%d] %-14s | Damage: %3d | Accuracy: %3d%%%n",
                    i + 1, attack.getName(), attack.getBaseDamage(),
                    attack.getAccuracy()
            );
        }

        System.out.println("---------------------------------------------------");

        // Låter spelaren välja ett giltigt nummer
        int choice = InputHelper.readIntBetween(
                scan, "> Choice: ",
                1, pokemon.getAttacks().size());

        // Returnerar attacken som spelaren valde
        return pokemon.getAttacks().get(choice - 1);
    }
}
