package org.example;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Pokedex pokedex = new Pokedex();
        pokedex.seedingPokemon();
        boolean running = true;

        // Kör Menu tills användaren stänger programmet
        while (running) {

            // MENU VAL
            System.out.println("\n====== Pokédex =====");
            System.out.println("[1] Show all Pokémon"); // WORKS
            System.out.println("[2] Add Pokémon"); // WORKS?
            System.out.println("[3] Edit Pokémon"); // WORKS?
            System.out.println("[4] Delete Pokémon"); // WORKS?
            System.out.println("[5] Save to file"); // ADD
            System.out.println("[6] Load from file"); // ADD
            System.out.println("[7] Exit"); // WORKS

            // ANVÄNDARENS VAL
            int userInput = InputHelper.readIntBetween(scan, "> Choose an option: ", 1, 7);

            switch (userInput) {
                // Visa alla pokémon som finns i pokédexet
                case 1:
                    System.out.println("\n=== All Pokémon ===");

                    // Kollar om Pokédexet är tomt
                    if (pokedex.getPokemon().isEmpty()) {
                        System.out.println("The Pokédex is empty...");
                    } else {
                        // Skriver ut Pokémons namn, element och hp
                        for (Pokemon pokemon : pokedex.getPokemon()) {
                            System.out.println(
                                    pokemon.getName() +
                                    " | Element: " + pokemon.getElement() +
                                    " | HP: " + pokemon.getCurrentHp() +
                                    "/" + pokemon.getMaxHp());
                        }
                    }
                    break;

                // Lägger till en ny Pokémon till Pokédexet
                case 2:
                    AddPokemon.add(scan,pokedex);
                    break;

                // Ändrar information om en Pokémon
                case 3:
                    EditPokemon.edit(scan, pokedex);
                    break;

                // Ta bort en Pokémon
                case 4:
                    DeletePokemon.delete(scan, pokedex);
                    break;

                // Sparar Pokédexet i en fil
                case 5:
                    System.out.println("\nSave to file");
                    break;

                // Laddar Pokédexet från en fil
                case 6:
                    System.out.println("\nLoad from file");
                    break;

                // Stoppar programmet
                case 7:
                    running = false;
                    System.out.println("\nGoodbye!");
                    break;

                // INGEN DEFAULT eftersom att jag har userInput (InputHelper)
                // som kollar så att användaren skriver in rätt val
            }
        }
        scan.close();
    }
}