package org.example;

import java.util.Scanner;

public class AddPokemon {

    public static void add(Scanner scan, Pokedex pokedex){

        System.out.println("\n=== Add a Pokémon ===");

        // Pokémon name
        String name;
        while (true){
            System.out.print("Name: ");
            name = scan.nextLine();

            if (name.isBlank()){
                System.out.println("\n\u001B[31mName cannot be empty, try again.\n\u001B[0m");
            } else {
                break;
            }
        }

        // Pokémon Element
        Element element;
        while (true){
            System.out.print("Element: ");
            String chosenElement = scan.nextLine();

            try {
                element = Element.valueOf(chosenElement.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\n\u001B[31mInvalid Element, try again.\u001B[0m");
                System.out.println("\u001B[31mChoose between: " +
                        "\u001B[34mWATER\u001B[0m, " +
                        "\u001B[31mFIRE\u001B[0m, " +
                        "\u001B[32mGRASS\u001B[0m, " +
                        "\u001B[33mELECTRIC\u001B[0m " +
                        "& \u001B[97mNORMAL.\n\u001B[0m");
            }
       }

        // Max HP
        int maxHp = InputHelper.readIntBetween(scan,
                "Max HP: ", 1, 100);

        // Current HP
        int currentHP = InputHelper.readIntBetween(scan,
                "Current HP: ", 0, maxHp);

        // Create the Pokémon
        Pokemon pokemon = new Pokemon(name, element, maxHp, currentHP);

        // Add the Attacks
        boolean addAnotherAttack = true;

        while (pokemon.getAttacks().size() < 4 && addAnotherAttack){

            System.out.println("\n=== Add Attack ===");

            Attack attack = AddAttack.create(scan);
            pokemon.addAttack(attack);
            System.out.println("\nAttack added!");

            // Add another attack?
            if (pokemon.getAttacks().size() < 4){
                addAnotherAttack = InputHelper.readYesNo(
                        scan, "\nAdd another attack? [YES] | [NO]: ");

            }
        }

        // Add the Pokémon to the Pokédex
        pokedex.addPokemon(pokemon);
        System.out.println("\n" + pokemon.getName() + " was added to the Pokédex!");
    }
}
