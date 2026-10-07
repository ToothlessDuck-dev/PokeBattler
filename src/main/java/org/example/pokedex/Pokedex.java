package org.example.pokedex;

import org.example.model.Attack;
import org.example.model.Element;
import org.example.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pokedex {

    // Lista med alla Pokémon
    private List<Pokemon> pokemons;

    // Skapar ett tomt Pokédex
    public Pokedex(){
        pokemons = new ArrayList<>();
    }

    // Lägger till en Pokémon i Pokédexet
    public void addPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
    }

    // Getter som gör det möjligt att läsa listan med Pokémon
    public List<Pokemon> getPokemon(){
        return pokemons;
    }

    // Återställer Pokédexet till de fördefinerade Pokémon
    public void seedingPokemon(){

        pokemons.clear();

        // Attacker till seed-data
        Attack thunderbolt = new Attack("Thunderbolt", 55, 90, Element.ELECTRIC);
        Attack electricStab = new Attack("Electric Stab", 20, 100, Element.ELECTRIC);

        Attack flamethrower = new Attack("Flamethrower", 45, 100, Element.FIRE);
        Attack fireBite = new Attack("Fire Bite", 30, 90, Element.FIRE);

        Attack vineWhip = new Attack("Vine Whip", 15, 80, Element.GRASS);
        Attack leafBlower = new Attack("Leaf Blower", 10, 100, Element.GRASS);

        Attack waterGun = new Attack("Water Gun", 60, 90, Element.WATER);
        Attack bubble = new Attack("Bubble", 60, 70, Element.WATER);

        Attack dash = new Attack("Dash", 100, 100, Element.NORMAL);
        Attack bite = new Attack("Bite", 90, 90, Element.NORMAL);

        // Pokémon till seed-data
        Pokemon pikachu = new Pokemon("Pikachu", Element.ELECTRIC, 100, 100);
        pikachu.addAttack(thunderbolt);
        pikachu.addAttack(electricStab);

        Pokemon charizard = new Pokemon("Charizard", Element.FIRE, 100, 100);
        charizard.addAttack(flamethrower);
        charizard.addAttack(fireBite);

        Pokemon bulbasaur = new Pokemon("Bulbasaur", Element.GRASS, 100, 100);
        bulbasaur.addAttack(vineWhip);
        bulbasaur.addAttack(leafBlower);

        Pokemon squirtle = new Pokemon("Squirtle", Element.WATER, 100, 100);
        squirtle.addAttack(waterGun);
        squirtle.addAttack(bubble);

        Pokemon eevee = new Pokemon("Eevee", Element.NORMAL, 100, 100);
        eevee.addAttack(dash);
        eevee.addAttack(bite);

        Pokemon absol = new Pokemon("Absol", Element.NORMAL, 100, 100);
        absol.addAttack(bite);
        absol.addAttack(electricStab);

        // Lägg till Pokémon till Pokédexet
        addPokemon(pikachu);
        addPokemon(charizard);
        addPokemon(bulbasaur);
        addPokemon(eevee);
        addPokemon(absol);
        addPokemon(squirtle);

    }
}
