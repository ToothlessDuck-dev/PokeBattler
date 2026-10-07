package org.example.BattleLogic;

import org.example.model.Attack;
import org.example.model.Pokemon;

public class AttackExecutor {

    // Utför en attack från en Pokémon mot en annan Pokémon
    public void executeAttack(
            Pokemon attacker, Pokemon defender, Attack attack){

        // Visar vilken attack som används
        System.out.println(
                attacker.getName() +
                " chose " +
                attack.getName() + "!");

        // Kontrollerar om attacken träffar
        if (AccuracyCheck.didHit(attack)){

            // Räknar ut hur mycket skada attacken gör
            int damage = DamageCalculator.calculateDamage(
                    attack, defender);

            // Minska HP
            int newHp = Math.max(
                    0, defender.getCurrentHp() - damage);
            defender.setCurrentHp(newHp);

            System.out.println(
                    attacker.getName() +
                    " dealt " +
                    damage + " damage!");

            System.out.println(
                    defender.getName() +
                    " has " + defender.getCurrentHp() +
                    "/" + defender.getMaxHp() + " HP left!");
        } else {
            System.out.println(
                    attacker.getName() +
                    "'s attack missed!");
        }
    }
}
