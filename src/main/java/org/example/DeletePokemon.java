package org.example;

import java.util.Scanner;

public class DeletePokemon {

    public static void delete(Scanner scan, Pokedex pokedex){

        System.out.println("\n=== Set free a Pokémon ===");

        // Kontrollera att Pokédexet inte är tomt
        if(pokedex.getPokemon().isEmpty()){
            System.out.println("\n\u001B[33mThe Pokédex is empty...\u001B[0m");
            System.out.println("\u001B[33mPlease add a Pokémon.\u001B[0m");
            return;
        }

        // Visa alla Pokémon
        for (int i = 0; i < pokedex.getPokemon().size(); i++){
            System.out.println(
                    "[" + (i + 1) + "] " +
                    pokedex.getPokemon().get(i).getName());
        }

        // Låt användaren välja en Pokémon
        int choice = InputHelper.readIntBetween(scan,
                "Choose a Pokémon to remove from your party: ",
                1, pokedex.getPokemon().size());

        // Hämntar Pokémonen som användaren har valt
        Pokemon selectedPokemon = pokedex.getPokemon().get(choice - 1);

        // Bekräfta användarens val
        boolean confirm = InputHelper.readYesNo(scan,
                "\nAre you sure you want to delete " +
                        selectedPokemon.getName() +
                        "? [YES] | [NO]: ");

        // Tar bort Pokémon från Pokédexet
        if (confirm){
            pokedex.getPokemon().remove(selectedPokemon);
            System.out.println("\n" + selectedPokemon.getName() + " was set free!");
        } else {
            System.out.println("\n" + selectedPokemon.getName() + " was spared.. this time!");
        }

    }
}
