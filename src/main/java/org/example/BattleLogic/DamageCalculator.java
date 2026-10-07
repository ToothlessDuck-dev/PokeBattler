package org.example.BattleLogic;

import org.example.model.Attack;
import org.example.model.Pokemon;
import java.util.Random;

public class DamageCalculator {

    // Används för att skapa slumpmässig variation i skadan
    private static final Random random = new Random();

    // Räknar ut hur mycket skada attacken gör
    public static int calculateDamage(Attack attack, Pokemon opponent){

        // Hämtar skade-multiplikatorn baserat på attackens pch motståndarens element
        double elementMultiplier = ElementEffectiveness.getMultiplier(
                attack.getElement(),
                opponent.getElement()
        );

        // Get skapan en slumpmässig faktor mellan 0.85 och 1.0
        double randomFactor = 0.85 + (random.nextDouble() * 0.15);

        // Räknar ut skadan genom att kombinera grundskada, element och slumpfaktor
        double damage = attack.getBaseDamage() * elementMultiplier * randomFactor;

        // Avrundar skadan och ser till att den alltid är minst 1
        return Math.max(1, (int) Math.round(damage));
    }
}
