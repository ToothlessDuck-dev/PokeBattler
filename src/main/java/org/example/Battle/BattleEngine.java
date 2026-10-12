package org.example.Battle;

import org.example.BattleLogic.AccuracyCheck;
import org.example.BattleLogic.AttackExecutor;
import org.example.BattleLogic.DamageCalculator;
import org.example.Menu.PlayerAttackSelector;
import org.example.model.Attack;
import org.example.model.Pokemon;
import java.util.Scanner;

public class BattleEngine {

    // Pokémon som tillör spelaren
    private Pokemon playerPokemon;

    // Pokémon som tillhör CPU:n
    private Pokemon cpuPokemon;

    private CpuStrategy cpuStrategy;

    // Används för att låta spelaren välja sin attack
    private PlayerAttackSelector playerAttackSelector;

    //
    private AttackExecutor attackExecutor;

    // Skapar en ny strid med spelarens och CPU:ns Pokémon
    public BattleEngine(Pokemon playerPokemon, Pokemon cpuPokemon, CpuStrategy cpuStrategy) {
        this.playerPokemon = playerPokemon;
        this.cpuPokemon = cpuPokemon;
        this.cpuStrategy = cpuStrategy;

        // Skapar menyn som spelaren använder för att välja attack
        this.playerAttackSelector = new PlayerAttackSelector();

        this.attackExecutor = new AttackExecutor();
    }

    // Startar striden
    public void startBattle(Scanner scan) {

        System.out.println("\n====================================");
        System.out.println("           BATTLE STARTED");
        System.out.println("     " + playerPokemon.getName() +
                " vs " + cpuPokemon.getName());
        System.out.println("====================================");

        // Fortsätter tills en av Pokémon har slut på HP
        while (playerPokemon.getCurrentHp() > 0 &&
                cpuPokemon.getCurrentHp() > 0) {

            // Låter spelaren välja sin attack
            System.out.println("\n---------- YOUR TURN ----------");
            Attack playerAttack = playerAttackSelector.chooseAttack(
                    scan, playerPokemon);

            // Utför spelarens attack
            attackExecutor.executeAttack(
                    playerPokemon, cpuPokemon, playerAttack);

            // Kontrollera om CPU:ns Pokémon har besegrats
            if (cpuPokemon.getCurrentHp() <= 0) {
                System.out.println("\n" + cpuPokemon.getName() +
                        " had fainted!");
                break;
            }

            // CPU:n väljer en attack
            System.out.println("\n------- OPPONENT'S TURN -------");
            Attack cpuAttack = cpuStrategy.chooseAttack(cpuPokemon);

            // Kontrollera att CPU:n har en attack
            if (cpuAttack == null) {
                System.out.println("\n" + cpuPokemon.getName() +
                        " has no attacks and cannot continue the battle.");
                return;
            }

            // Utför CPU:ns attack
            attackExecutor.executeAttack(
                    cpuPokemon, playerPokemon, cpuAttack);

            // Kontrollera om spelarens Pokémon har besegrats
            if (playerPokemon.getCurrentHp() <= 0) {
                System.out.println("\n" + playerPokemon.getName() +
                        " has fainted!");
                break;
            }

            //System.out.println("\n--------------------------------");
        }
        // Visar resultatet av striden
        System.out.println("\n====================================");
        System.out.println("          Battle Finished");
        if (playerPokemon.getCurrentHp() <= 0) {
            System.out.println("\n      You have lost the battle!💀");
        } else if (cpuPokemon.getCurrentHp() <= 0) {
            System.out.println("\n      You have won the battle!🎉");
        }

        System.out.println("====================================");
    }
}
