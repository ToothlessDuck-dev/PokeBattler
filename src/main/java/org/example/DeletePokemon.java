package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DeletePokemon {

    public static void delete(Scanner scan, Pokedex pokedex){

        // Kontrollera att Pokédexet inte är tomt
        if (pokedex.getPokemon().isEmpty()){
            System.out.println("The Pokédex is empty!");
            System.out.println("Please add a Pokémon.");
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
                "Choose a Pokémon to delete: ",
                1, pokedex.getPokemon().size());

        // Hämntar Pokémonen som användaren vill välja
        Pokemon selectedPokemon = pokedex.getPokemon().get(choice - 1);

        // Bekräfta användarens val
        boolean confirm = InputHelper.readYesNo(scan,
                "Are you sure you want to delete " +
                        selectedPokemon.getName() +
                        "? [YES] | [NO]: ");

        // Raderar Pokémon
        if (confirm){
            pokedex.getPokemon().remove(selectedPokemon);
            System.out.println(selectedPokemon.getName() + " was deleted!");
        } else {
            System.out.println(selectedPokemon.getName() + " was spared.. this time!");
        }

    }
}
