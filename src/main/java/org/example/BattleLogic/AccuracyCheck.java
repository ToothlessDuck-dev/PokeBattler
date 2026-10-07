package org.example.BattleLogic;

import org.example.model.Attack;

import java.util.Random;

public class AccuracyCheck {

    private static final Random random = new Random();

    public static boolean didHit(Attack attack){

        int roll = random.nextInt(100) + 1;

        return roll <= attack.getAccuracy();
    }
}
