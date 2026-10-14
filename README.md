Pokémon Battler - Pokédex

Beskrivning:

Pokémon Battler är ett konsolbaserad program som bygger vidare på min tidigare Pokédex. Programmet låter användaren
hantera sina Pokémon och deras attacker, HP, namn osv samt delta i en turbaserad strid mot en datorstyrd vild Pokémon.
Alla strider sparas som en textfil (.txt) samt "Battle Statistics" som visas i menyn, den förklarar hur många strider
användaren har gjort och hur många som är en vinst och hur många de förlorade.


Funktioner:

Pokédex - Visar alla Pokémon i Pokédexet och lägger till nya Pokémon. Redigera befintliga Pokémon, ta bort Pokémon och
hantera des attacker. Spara och läs in Pokédexet till en textfil och gör det möjligt att återstå Pokédexet till standa-
rduppsättningen.

Pokémon Battler - Låter användaren välja sina egna Pokémon för en strid emot en slumpmässig vild Pokémon. Jag använder
en coin flip metod för att välja vem som har första draget i striden. Under stridens gång får användaren välja vilken
attack som används, efter användarens tur väljer CPU:n en slumpmässig attack. Beräkna skadan utifrån attackens
grundskada och typens effektivitet. Ifall en Pokémon har en grundskada på 40 och är super effektiv (x2) så är skadan
40 x 2 = 80. men min slumpfaktor i programmet gör så att en attack kan ha olika skada. Alltså ifall slump faktorn
är 0.85 så blir det 80 x 0.85 = 68. Slut skadad är 68. Det ger varje strid lite variation.

Attacking Element - Defending Element - Multiplier

      Fire        x      Grass        =     x2.0
      Water       x      Fire         =     x2.0
      Grass       x      Water        =     x2.0
      Electric    x      Water        =     x2.0
      Fire        x      Water        =     x0.5
      Water       x      Grass        =     x0.5
      Grass       x      Fire         =     x0.5
      Normal      x      Any Type     =     x1.0

    Damage = Base Damage x Type Multiplier x Random Factor

När en Pokémon har 0 HP så avslutas striden, då sparas stridsresultatet och visar resultatet av striden.


övriga funktioner:

Jag la till ett meny val som låter användaren läka en Pokémon så att man kan strida med den igen!


ProjektStruktur:

* org.example - Projektet huvudklass
* org.example.Battle - Stridslogik, datorns strategi och Pokémon pool, stridshistorik och allmän BattleEngine vilket innebär
hur striden fungerar.
* org.example.BattleLogic - Beräkning av träffsäkerhet, skada och typeffektivitet.
* org.example.input - Hanterar användarens input
* org.example.Menu - Funktioner för att välja Pokémon och attacker samt läka Pokémon
* org.example.model - Modeller för Pokémon, attacker och element.
* org.example.pokedex - Tar hand om användarens Pokémon.
* org.example.Main - Main menyn, det användaren ser och kan välja mellan.
