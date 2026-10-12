package org.example.Menu;

import org.example.input.InputHelper;
import org.example.model.Pokemon;
import org.example.pokedex.Pokedex;

import java.util.Scanner;

public class PokemonHealer {

    // Låter användaren välja vilken Pokémon som ska läkas
    public void healPokemon(Scanner scan, Pokedex pokedex) {

        // Kontrollera att Pokédexet inte är tomt
        if (pokedex.getPokemon().isEmpty()) {
            System.out.println("\n\u001B[33mYou have no Pokémon to heal!\u001B[0m");
            return;
        }

        // Visar alla Pokémon och deras nuvarande HP
        System.out.println("\n=== Heal Pokémon ===");

        for (int i = 0; i < pokedex.getPokemon().size(); i++) {
            Pokemon pokemon = pokedex.getPokemon().get(i);

            System.out.println(
                    "[" + (i + 1) + "] " + pokemon.getName()
                            + " | HP: " + pokemon.getCurrentHp()
                            + "/" + pokemon.getMaxHp()
            );
        }

        // Låter användaren välja en Pokémon
        int choice = InputHelper.readIntBetween(scan, "\n> Choose a Pokémon to heal: ",
                1, pokedex.getPokemon().size());

        // Hämntar den valda Pokémonen
        Pokemon chosenPokemon = pokedex.getPokemon().get(choice - 1);

        // Kontrollera om Pokémonen redan har full HP
        if (chosenPokemon.getCurrentHp() == chosenPokemon.getMaxHp()) {
            System.out.println("\n" + chosenPokemon.getName() +
                    " \u001B[33malready has full HP!\u001B[0m");
        } else {
            // återställer Pokémons HP till dess Maxvärde
            chosenPokemon.setCurrentHp(chosenPokemon.getMaxHp());

            // Bekräfta att Pokémonen har läkts
            System.out.println("\n" + chosenPokemon.getName() +
                    " has been fully healed!");
            System.out.println("\nHP: " + chosenPokemon.getCurrentHp() +
                    "/" + chosenPokemon.getMaxHp());
        }
    }
}
