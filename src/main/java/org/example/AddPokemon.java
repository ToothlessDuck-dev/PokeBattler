package org.example;

import java.util.Scanner;

public class AddPokemon {

    public static void add(Scanner scan, Pokedex pokedex){

        System.out.println("\n=== Add Pokémon ===");

        // Pokémon name
        String name;
        while (true){
            System.out.print("Name: ");
            name = scan.nextLine();

            if (name.isBlank()){
                System.out.println("Name cannot be empty, try again.");
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
                System.out.println("Invalid Element, try again.");
                System.out.println("Choose between: FIRE, WATER, GRASS, ELECTRIC & NORMAL.");
            }
       }

        // Max HP
        int maxHp = InputHelper.readIntBetween(scan,
                "Max HP: ", 1, Integer.MAX_VALUE);

        // Current HP
        int currentHP = InputHelper.readIntBetween(scan,
                "Current HP: ", 0, maxHp);

        // Create the Pokémon
        Pokemon pokemon = new Pokemon(name, element, maxHp, currentHP);

        // Add the Attacks
        boolean addAnotherAttack = true;

        while (pokemon.getAttacks().size() < 4 && addAnotherAttack){

            System.out.println("\n=== Add Attack ===");

            // Attack name
            String attackName;
            while(true){
                System.out.print("Attack Name: ");
                attackName = scan.nextLine();

                if (attackName.isBlank()){
                    System.out.println("Attack Name Cannot be empty. Try again!");
                } else {
                    break;
                }
            }

            // Base Damage
            int baseDamage = InputHelper.readIntBetween(scan,
                    "Base Damage: ", 1,
                    Integer.MAX_VALUE);

            // Accuracy
            int accuracy = InputHelper.readIntBetween(scan,
                    "Accuracy: ", 0, 100);

            // Attack Element
            Element attackElement;
            while(true){
                System.out.print("Attack Element: ");
                String attackElementInput = scan.nextLine();

                try {
                    attackElement = Element.valueOf(
                    attackElementInput.toUpperCase());
                    break;
                } catch (IllegalArgumentException e){
                    System.out.println("Invalid Element. Try Again.");
                    System.out.println("Choose between: FIRE, WATER, GRASS, ELECTRIC and NORMAL.");
                }
            }

            // Create the attack
            Attack attack = new Attack(
                    attackName,
                    baseDamage,
                    accuracy,
                    attackElement);

            // Add attack to the Pokémon
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
        System.out.println(pokemon.getName() + " was added to the Pokédex!");
    }
}
