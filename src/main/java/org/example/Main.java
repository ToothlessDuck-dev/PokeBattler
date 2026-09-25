package org.example;

import java.io.File;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Pokedex pokedex = new Pokedex();

        // Laddar sparad data om filen finns, annars skapas seed-data
        File file = new java.io.File("pokedex.txt");

        if (file.exists()){
            PokedexFile.load(pokedex);
        } else {
            pokedex.seedingPokemon();
        }

        boolean running = true;

        // Kör Menu tills användaren stänger programmet
        while (running) {

            System.out.println("\n====== Pokédex =====");
            System.out.println("[1] Show all Pokémon");
            System.out.println("[2] Add Pokémon");
            System.out.println("[3] Edit Pokémon");
            System.out.println("[4] Delete Pokémon");
            System.out.println("[5] Save to file");
            System.out.println("[6] Load from file");
            System.out.println("[7] Reset to seed data");
            System.out.println("[8] Exit");

            int userInput = InputHelper.readIntBetween(scan, "> Choose an option: ", 1, 8);

            switch (userInput) {
                // Visa alla pokémon som finns i pokédexet
                case 1:
                    System.out.println("\n=== All Pokémon ===");

                    // Kollar om Pokédexet är tomt
                    if (pokedex.getPokemon().isEmpty()) {
                        System.out.println("\n\u001B[33mThe Pokédex is empty...\u001B[0m");
                    } else {
                        // Skriver ut Pokémons namn, element och hp
                        for (Pokemon pokemon : pokedex.getPokemon()) {
                            System.out.println(
                                    pokemon.getName() +
                                    " | Element: " + pokemon.getElement() +
                                    " | HP: " + pokemon.getCurrentHp() +
                                    "/" + pokemon.getMaxHp());

                            // Visa alla Attacker Pokémon har
                            for (Attack attack : pokemon.getAttacks()){
                                System.out.println(
                                        "ATTACK: " + attack.getName() +
                                        " | Base Damage: " + attack.getBaseDamage() +
                                        " | Accuracy: " + attack.getAccuracy() +
                                        " | Element: " + attack.getElement());
                            }

                            System.out.println("\n=============================================================================\n");
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
                    System.out.println("\n=== Save to file ===");
                    PokedexFile.save(pokedex);
                    break;

                // Laddar Pokédexet från en fil
                case 6:
                    System.out.println("\n=== Load from file ===");
                    PokedexFile.load(pokedex);
                    break;

                // Återställer Pokédexet till seed-data
                case 7:
                    System.out.println("\n=== Reset to seed data ===");
                    pokedex.seedingPokemon();
                    System.out.println("\nPokédex has been reset to seed data!");
                    break;

                // Stoppar programmet
                case 8:
                    PokedexFile.save(pokedex);
                    running = false;
                    System.out.println("\nGoodbye!!");
                    break;
            }
        }
        scan.close();
    }
}