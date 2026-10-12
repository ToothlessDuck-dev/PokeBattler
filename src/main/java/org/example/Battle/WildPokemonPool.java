package org.example.Battle;

import org.example.model.Attack;
import org.example.model.Element;
import org.example.model.Pokemon;

import java.util.Random;

public class WildPokemonPool {

    private static final Random random = new Random();

    public static Pokemon createWildPokemon() {

        // Tillgänliga Pokemon
        Pokemon[] wildPokemon = {
                new Pokemon("Wild Manectric", Element.ELECTRIC, 100, 100),
                new Pokemon("Wild Blaziken", Element.FIRE, 100, 100),
                new Pokemon("Wild Bayleef", Element.GRASS, 100, 100),
                new Pokemon("Wild Psyduck", Element.WATER, 100, 100),
                new Pokemon("Wild Slaking", Element.NORMAL, 100, 100)
        };

        // Manectric's attacker
        wildPokemon[0].addAttack(
                new Attack("Thunderbolt", 55, 90, Element.ELECTRIC));
        wildPokemon[0].addAttack(
                new Attack("Electric Stab", 30, 100, Element.ELECTRIC));

        // Blaziken's attacker
        wildPokemon[1].addAttack(
                new Attack("Fire Breath", 60, 100, Element.FIRE));
        wildPokemon[1].addAttack(
                new Attack("Scortching Touch", 40, 80, Element.FIRE));

        // Bayleef's attacker
        wildPokemon[2].addAttack(
                new Attack("Binding Vines", 70, 100, Element.GRASS));
        wildPokemon[2].addAttack(
                new Attack("Sprouting Seeds", 50, 80, Element.GRASS));

        //Psyduck's attacker
        wildPokemon[3].addAttack(
                new Attack("Acid Rain", 100, 100, Element.WATER));
        wildPokemon[3].addAttack(
                new Attack("Bubble", 30, 90, Element.WATER));

        // Slaking's attacker
        wildPokemon[4].addAttack(
                new Attack("Dash", 100, 70, Element.NORMAL));
        wildPokemon[4].addAttack(
                new Attack("Bite", 60,100, Element.NORMAL));

        // Returnerar en slumpmässig vild Pokémon
        return wildPokemon[random.nextInt(wildPokemon.length)];

    }
}
