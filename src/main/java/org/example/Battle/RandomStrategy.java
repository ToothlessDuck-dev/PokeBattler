package org.example.Battle;

import org.example.model.Attack;
import org.example.model.Pokemon;
import java.util.Random;

public class RandomStrategy implements CpuStrategy {

    private final Random random = new Random();

    // Väljer en slumpmässig attack frå Pokémonens attacker
    @Override
    public Attack chooseAttack(Pokemon pokemon){

        // Om Pokémon inte har några attacker kan ingen attack väljas
        if (pokemon.getAttacks().isEmpty()){
            return null;
        }

        // Slumpar fram ett index från Pokémonens lista med attacker
        int index = random.nextInt(pokemon.getAttacks().size());

        // Returnerar attacken på det slumpade indexet
        return  pokemon.getAttacks().get(index);
    }
}
