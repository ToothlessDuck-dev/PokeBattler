package org.example.Menu;

import org.example.input.InputHelper;
import org.example.model.Pokemon;
import org.example.pokedex.Pokedex;

import java.util.Scanner;

public class PokemonHealer {

    // Låter användaren välja vilken Pokémon som ska läkas
    public void healPokemon(Scanner scan, Pokedex pokedex){

        // Kontrollera att Pokédexet inte är tomt
        if (pokedex.getPokemon().isEmpty()){
            System.out.println("\nYou have no Pokémon to heal!");
            return;
        }
    }
}
