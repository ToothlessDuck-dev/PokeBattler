package org.example;

import java.util.Scanner;

public class EditPokemon {

    public static void edit(Scanner scan, Pokedex pokedex){

        System.out.println("\n=== Edit Pokémon ===");

        // Kontrollera att Pokédex inte är tomt
        if(pokedex.getPokemon().isEmpty()){
            System.out.println("The Pokédex is empty...");
            return;
        }

        // Visa alla Pokémon
        for (int i = 0; i < pokedex.getPokemon().size(); i++){
            System.out.println(
            "[" + (i + 1) + "]" +
            pokedex.getPokemon().get(i).getName());
        }

        // Välj en Pokémon
        int choice = InputHelper.readIntBetween(scan,
                "> Choose a Pokémon: ",
                1, pokedex.getPokemon().size());

        Pokemon selectedPokemon = pokedex.getPokemon().get(choice - 1);

        System.out.println("\nEditing: " + selectedPokemon.getName());

        System.out.println("\n[1] Change Name");
        System.out.println("[2] Change HP");
        System.out.println("[3] Change Element");
        System.out.println("[4] Add Attack");
        System.out.println("[5] Remove Attack");
        System.out.println("[6] Back");

        String editChoice = InputHelper.readIntBetween(scan,
                "> Choose an option: ",
                1, 6) + "";

        switch (editChoice){

            case "1":
                System.out.print("\nNew Name: ");
                String newName = scan.nextLine();

                if (newName.isBlank()){
                    System.out.println("Name cannot be empty.");
                    break;
                }

                selectedPokemon.setName(newName);
                System.out.println("\nPokémon name changed to: " + newName);
                break;

            case "2":
                int newMaxHp = InputHelper.readIntBetween(scan,
                        "\nNew Max HP: ",
                        1, Integer.MAX_VALUE);

                int newCurrentHp = InputHelper.readIntBetween(scan,
                        "\nNew Current HP: ",
                        0, newMaxHp);

                selectedPokemon.setMaxHp(newMaxHp);
                selectedPokemon.setCurrentHp(newCurrentHp);

                System.out.print("\nPokémon HP changed!\n");
                break;

            case "3":
                System.out.print("\nNew Element: ");
                String newElementInput = scan.nextLine();

                try{
                    Element newElement = Element.valueOf(newElementInput.toUpperCase());
                    selectedPokemon.setElement(newElement);

                    System.out.println("\nPokémon Element changed to: " + newElement);
                } catch (IllegalArgumentException e){
                    System.out.println("\nInvalid Element!");
                    System.out.println("Please choose between: FIRE, WATER, GRASS, ELECTRIC & NORMAL.");
                }
                break;

            case "4":

                // Kontrollera att Pokémon har 4 attacker
                if (selectedPokemon.getAttacks().size() >= 4){
                    System.out.println("This Pokémon already has 4 attacks!");
                    break;
                }

                System.out.println("\n=== Add Attack ===");

                Attack attack = AddAttack.create(scan);
                selectedPokemon.addAttack(attack);

                System.out.println("\nAttack added!");
                break;

            case "5":

                // Kontrollera att Pokémon har attacker
                if (selectedPokemon.getAttacks().isEmpty()){
                    System.out.println("This Pokémon has no attacks.");
                    break;
                }

                System.out.println("\n=== Remove an attack");

                // Visa Pokémons attacker
                for(int i = 0; i < selectedPokemon.getAttacks().size(); i++){
                    System.out.println(
                            "[" + (i + 1) + "] " +
                            selectedPokemon.getAttacks().get(i).getName());
                }

                // Välj attack
                int attackChoice = InputHelper.readIntBetween(scan,
                        "> Choose an attack to remove: ",
                        1, selectedPokemon.getAttacks().size());

                // Hämta attacken samt bekräfta
                Attack selectedAttack = selectedPokemon.getAttacks().get(attackChoice - 1);

                boolean confirm = InputHelper.readYesNo(scan,
                        "\nAre you sure you want to remove " +
                        selectedAttack.getName() +
                        "? [YES] | [NO]: ");

                // Ta bort attacken
                if(confirm){
                    selectedPokemon.removeAttack(selectedAttack);
                    System.out.println("\n" + selectedPokemon.getName() +
                            " has forgotten how to use " +
                            selectedAttack.getName() + ".");
                } else {
                    System.out.println("\n" + selectedPokemon.getName() +
                            " stays strong knowing " +
                            selectedAttack.getName() + ".");
                }
                break;

            case "6":
                break;
        }
    }
}
