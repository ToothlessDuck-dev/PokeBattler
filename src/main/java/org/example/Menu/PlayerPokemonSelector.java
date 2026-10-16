package org.example.Menu;

import org.example.input.InputHelper;
import org.example.model.Pokemon;
import org.example.pokedex.Pokedex;

import java.util.Scanner;

public class PlayerPokemonSelector {

    // Låter spelaren vâlja en Pokémon som kan delta i striden
    public Pokemon choosePokemon(Scanner scan, Pokedex pokedex) {

        System.out.println("\n>>> Choose your Pokémon <<<");

        // Går igenom alla Pokémon i Pokédexet
        for (int i = 0; i < pokedex.getPokemon().size(); i++) {
            Pokemon pokemon = pokedex.getPokemon().get(i);

            // OM Pokémon har mindre än 0 HP visas att den är "Fainted"
            System.out.println(
                    "[" + (i + 1) + "] " + pokemon.getName() +
                            " | HP: " + pokemon.getCurrentHp() +
                            "/" + pokemon.getMaxHp() +
                            (pokemon.getCurrentHp() <= 0 ? " (FAINTED)" : ""));
        }

        // Fortsätter fråga tills spelaren har valt en giltig Pokémon
        while (true) {
            int choice = InputHelper.readIntBetween(scan,
                    "> Pokémon chosen: ",
                    1, pokedex.getPokemon().size());

            Pokemon chosenPokemon = pokedex.getPokemon().get(choice - 1);

            if (chosenPokemon.getCurrentHp() <= 0) {
                System.out.println("\nThis Pokémon had fainted! Choose a different one.");
            } else {
                return chosenPokemon;
            }
        }
    }
}
