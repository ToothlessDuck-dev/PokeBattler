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

        System.out.println("\n=== Battle Started ===");
        System.out.println(playerPokemon.getName() +
                " vs " + cpuPokemon.getName());

        // Låter spelaren välja sin attack
        Attack playerAttack = playerAttackSelector.chooseAttack(
                scan, playerPokemon);

        // Utför spelarens attack
        attackExecutor.executeAttack(
                playerPokemon, cpuPokemon, playerAttack);

        // CPU:n väljer en attack
        Attack cpuAttack = cpuStrategy.chooseAttack(cpuPokemon);

        // Kontrollera att CPU:n har en attack
        if (cpuAttack == null) {
            System.out.println(cpuPokemon.getName() +
                    " has no attacks and cannot continue the battle.");
            return;
        }

        // Utför CPU:ns attack
        attackExecutor.executeAttack(
                cpuPokemon, playerPokemon, cpuAttack);
    }
}
