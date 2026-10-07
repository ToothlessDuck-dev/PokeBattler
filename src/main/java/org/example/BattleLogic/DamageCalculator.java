package org.example.BattleLogic;

import org.example.model.Attack;
import org.example.model.Pokemon;
import java.util.Random;

public class DamageCalculator {

    private static final Random random = new Random();

    public static int calculateDamage(Attack attack, Pokemon opponent){

        double elementMultiplier = ElementEffectiveness.getMultiplier(
                attack.getElement(),
                opponent.getElement()
        );

        double randomFactor = 0.85 + (random.nextDouble() * 0.15);

        double damage = attack.getBaseDamage() * elementMultiplier * randomFactor;

        return Math.max(1, (int) Math.round(damage));
    }
}
