package org.example;

import java.util.Scanner;

public class AddPokemon {

    public static void add(Scanner scan, Pokedex pokedex){

        System.out.println("\n=== Add a Pokémon ===");

        // Läser in Pokémon namnet
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

        // Läser in Pokémon Elementet
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

        // Läser in Max HP
        int maxHp = InputHelper.readIntBetween(scan,
                "Max HP: ", 1, 100);

        // Läser in Current HP
        int currentHP = InputHelper.readIntBetween(scan,
                "Current HP: ", 0, maxHp);

        // Skapar Pokémon
        Pokemon pokemon = new Pokemon(name, element, maxHp, currentHP);

        // Lägger till 1-4 attacker
        boolean addAnotherAttack = true;

        while (pokemon.getAttacks().size() < 4 && addAnotherAttack){

            System.out.println("\n=== Add Attack ===");

            Attack attack = AddAttack.create(scan);
            pokemon.addAttack(attack);
            System.out.println("\nAttack added!");

            // Frågar om användaren vill lägga till en till attack
            if (pokemon.getAttacks().size() < 4){
                addAnotherAttack = InputHelper.readYesNo(
                        scan, "\nAdd another attack? [YES] | [NO]: ");

            }
        }

        // Lägger till Pokémon i Pokédexet
        pokedex.addPokemon(pokemon);
        System.out.println("\n" + pokemon.getName() + " was added to the Pokédex!");
    }
}
