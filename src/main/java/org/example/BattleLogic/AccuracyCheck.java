package org.example.BattleLogic;

import org.example.model.Attack;

import java.util.Random;

public class AccuracyCheck {

    // Används för att skapa ett slumpmässigt tal
    private static final Random random = new Random();

    // Kontrollerar om attacken träffar baserat på attackens accuracy
    public static boolean didHit(Attack attack){

        // Slumpar ett tal mellan 1 och 100
        int roll = random.nextInt(100) + 1;

        // Attacken träffar om slumpvärdet är mindre än eller
        // lika med accuracy
        return roll <= attack.getAccuracy();
    }
}
