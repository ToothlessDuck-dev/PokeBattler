package org.example.Battle;

import org.example.model.Pokemon;
import org.example.model.Attack;

public interface CpuStrategy {

    // Väljer vilken attack CPU:n ska använda
    Attack chooseAttack(Pokemon pokemon);
}
