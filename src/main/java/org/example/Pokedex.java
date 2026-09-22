package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pokedex {

    //Lista med alla Pokémon i Pokédexet
    private List<Pokemon> pokemons;

    //Tom Pokédex
    public Pokedex(){
        pokemons = new ArrayList<>();
    }

    //Lägger till en Pokémon i Pokédexet
    public void addPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
    }

    //Denna kod gör det möjligt att läsa listan med Pokémon
    public List<Pokemon> getPokemon(){
        return pokemons;
    }
}
