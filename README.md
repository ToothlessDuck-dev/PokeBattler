(Jag har redan skrivit en README och lagt till den i uppgiften som en fil, men jag kopierar även in den här för säkerhets skull.)

Pokédex:

Denna projekt är en Pokédex där användaren kan hantera en samling av Pokémon.


Funktioner:

* [1] Visa alla Pokémon
    - Printar ut alla Pokémon som användaren har i sitt Pokédex.

* [2] Lägg till en Pokémon
    - Här kan användaren lägga till en Pokémon, namn, HP och element, samt en attack med Base Damage,
    Accuracy och element. Användaren får också ett val för att lägga till en till attack. Max 4 attacker.

* [3] Redigera en Pokémon
    - Här kan användaren redigera en specifik Pokémon.
        - Ändra namn, HP, element, attack, Base Damage osv.

* [4] Ta bort en Pokémon
    - Här kan användaren ta bort en specifik Pokémon.
        - Användaren får välja vilken Pokémon de vill ta bort, Pokédexet kan ha 0 Pokémon men inte mindre.
        Ifall användaren försöker att ta bort en Pokémon när Pokédexet är tomt får användaren ett meddelande
        som säger att Pokédexet är redan tomt.

* [5] Sparar till fil
    - Sparar Pokédexet som en pokedex.txt fil
        - Ifall användaren ändrar på Pokédexet och sedan går ut från programmer sparas alla ändringar MEN
        användaren måste "ladda från fil" för att fortsätta på deras förra ändringar.

* [6] Ladda från fil
    - Användaren kan ladda up den senaste sparade filen.

* [7] återställ till seedad data
    - återställer programmet till seedad data med de första 6 hårdkodade Pokémon.
        - Spelar ingen roll hur många ändringar användaren gör eller när de sparar filen, ifall
        användaren väljer [7] så återställs programmet till ens seedad data.

* [8] Avsluta
    - Avslutar programmet SAMT sparar programmet till fil.
        - Användaren behöver inte spara filen manuelt för att spara alla ändringar.


Automatisk datahantering:

Ifall det inte finns en sparad data skapas automatiskt 6 fördefinerade Pokémon.
Ifall det finns en sparad fil så öppnas programmet med den senaste sparade ändringarna användaren gjorde.
