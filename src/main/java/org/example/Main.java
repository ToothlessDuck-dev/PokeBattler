package org.example;

import org.example.Battle.BattleEngine;
import org.example.Battle.RandomStrategy;
import org.example.Battle.WildPokemonPool;
import org.example.model.Element;
import org.example.input.InputHelper;
import org.example.model.Attack;
import org.example.model.Pokemon;
import org.example.pokedex.*;
import org.example.Menu.PlayerPokemonSelector;
import org.example.Menu.PokemonHealer;

import java.io.File;
import java.util.Scanner;

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
            System.out.println("[8] Start a Battle");
            System.out.println("[9] Heal Pokémon");
            System.out.println("[10] Exit");

            int userInput = InputHelper.readIntBetween(scan, "> Choose an option: ", 1, 10);

            switch (userInput) {
                // Visa alla pokémon som finns i pokédexet
                case 1:
                    System.out.println("\n=== All Pokémon ===");
                    System.out.println("=============================================================================");

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

                // Startar strid
                case 8:
                    if (pokedex.getPokemon().isEmpty()){
                        System.out.println("\nYou need at least one Pokémon to battle");
                        break;
                    }

                    boolean hasAvailablePokemon = pokedex.getPokemon().stream().
                            anyMatch(pokemon -> pokemon.getCurrentHp() > 0);

                    if (!hasAvailablePokemon){
                        System.out.println("\nYou have no Pokémon available to battle!");
                        break;
                    }

                    Pokemon playerPokemon = new PlayerPokemonSelector().choosePokemon(scan, pokedex);

                    Pokemon cpuPokemon = WildPokemonPool.createWildPokemon();

                    BattleEngine battle = new BattleEngine(
                            playerPokemon,
                            cpuPokemon,
                            new RandomStrategy()
                    );

                    battle.startBattle(scan);
                    break;

                // Läker den valda Pokémonen
                case 9:
                    new PokemonHealer().healPokemon(scan, pokedex);
                    break;

                // Avslutar och sparar fil
                case 10:
                    PokedexFile.save(pokedex);
                    running = false;
                    System.out.println("\nGoodbye!!");
                    break;
            }
        }
        scan.close();
    }
}