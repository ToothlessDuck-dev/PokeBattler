package org.example.Battle;

import org.example.Menu.PlayerAttackSelector;
import org.example.model.Pokemon;

public class BattleEngine {

    // Pokémon som tillör spelaren
    private Pokemon playerPokemon;

    // Pokémon som tillhör CPU:n
    private Pokemon cpuPokemon;

    private CpuStrategy cpuStrategy;

    // Används för att låta spelaren välja sin attack
    private PlayerAttackSelector playerAttackSelector;

    // Skapar en ny strid med spelarens och CPU:ns Pokémon
    public BattleEngine(Pokemon playerPokemon, Pokemon cpuPokemon, CpuStrategy cpuStrategy){
        this.playerPokemon = playerPokemon;
        this.cpuPokemon = cpuPokemon;
        this.cpuStrategy = cpuStrategy;

        // Skapar menyn som spelaren använder för att välja attack
        this.playerAttackSelector = new PlayerAttackSelector();
    }

    // Startar striden
    public void startBattle(){

    }
}
