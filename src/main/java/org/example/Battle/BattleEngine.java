package org.example.Battle;

import org.example.BattleLogic.AccuracyCheck;
import org.example.BattleLogic.AttackExecutor;
import org.example.BattleLogic.DamageCalculator;
import org.example.Menu.PlayerAttackSelector;
import org.example.model.Attack;
import org.example.model.Pokemon;
import org.example.Battle.BattleHistory;

import java.util.Scanner;
import java.util.Random;

public class BattleEngine {

    // slumpmässig start till striden
    private boolean firstMove() {
        return new Random().nextBoolean();
    }

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

        // Slumpmässig faktor som väljer vem som har första attacken.
        boolean playerTurn = firstMove();

        while (playerPokemon.getCurrentHp() > 0 &&
                cpuPokemon.getCurrentHp() > 0) {

            if (playerTurn){
                //spelarens tur
                System.out.println("\n---------- YOUR TURN ----------");

                Attack playerAttack = playerAttackSelector.chooseAttack(scan, playerPokemon);

                attackExecutor.executeAttack(
                        playerPokemon, cpuPokemon, playerAttack);

                if(cpuPokemon.getCurrentHp() <= 0){
                    System.out.println("\n" + cpuPokemon.getName() + " has fainted!");
                    break;
                }
            } else {
                // CPU:ns tur
                System.out.println("\n------- OPPONENT'S TURN -------");

                Attack cpuAttack = cpuStrategy.chooseAttack(cpuPokemon);

                if (cpuAttack == null){
                    System.out.println("\n" + cpuPokemon.getName() +
                            " \n\u001B[33mhas no attacks and cannot continue the battle.\u001B[0m");
                    break;
                }

                // Utför CPU:ns attack
                attackExecutor.executeAttack(cpuPokemon, playerPokemon, cpuAttack);

                // Kontrollera om användarens Pokémon har besegrats
                if (playerPokemon.getCurrentHp() <= 0){
                    System.out.println("\n" + playerPokemon.getName() + " has fainted!");
                    break;
                }
            }

            // Byter tur efter varje attack
            playerTurn = !playerTurn;
        }

        // Visar och sparar resultatet av striden
        System.out.println("\n====================================");
        System.out.println("          Battle Finished");

        if (playerPokemon.getCurrentHp() <= 0) {
            System.out.println("\n      You have lost the battle!💀");

            BattleHistory.saveBattle(playerPokemon, cpuPokemon, "LOSS");

        } else if (cpuPokemon.getCurrentHp() <= 0) {
            System.out.println("\n      You have won the battle!🎉");

            BattleHistory.saveBattle(playerPokemon, cpuPokemon, "WIN");
        }

        System.out.println("====================================");
    }
}
