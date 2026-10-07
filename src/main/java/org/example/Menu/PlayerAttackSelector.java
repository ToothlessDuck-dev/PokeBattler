package org.example.Menu;

import org.example.input.InputHelper;
import org.example.model.Pokemon;
import org.example.model.Attack;
import java.util.Scanner;

public class PlayerAttackSelector {

    // Låter spelaren välja en attack från sin Pokémon
    public Attack chooseAttack(Scanner scan, Pokemon pokemon){
        System.out.println("\n=== Choose an Attack ===");

        // Visar alla attacker som Pokémonen kan använda
        for (int i = 0; i < pokemon.getAttacks().size(); i++){
            Attack attack = pokemon.getAttacks().get(i);

            System.out.println(
                    (i + 1) + ". " +
                    attack.getName() +
                    " | Damamge: " +
                    attack.getBaseDamage() +
                    " | Accuracy: " +
                    attack.getAccuracy());
        }

        // Låter spelaren välja ett giltigt nummer
        int choice = InputHelper.readIntBetween(
                scan, "Choose an attack: ",
                1, pokemon.getAttacks().size());

        // Returnerar attacken som spelaren valde
        return pokemon.getAttacks().get(choice - 1);
    }
}
