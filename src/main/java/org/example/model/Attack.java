package org.example.model;

import org.example.input.ConsoleColors;

public class Attack {

    // Namn för attack
    private String name;

    // Hur mycket damage gör attacken
    private int baseDamage;

    // Chans för träff av attack
    private int accuracy;

    // Vilken typ av attack
    private Element element;

    // Skapar en attack och kontrollerar att all info är giltigt
    public Attack(String name, int baseDamage, int accuracy, Element element){

        // Attack namn kan inte vara tom
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException(ConsoleColors.ERROR + "\nAttack name cannot be empty!" +
                    ConsoleColors.DEFAULT);
        }

        // baseDamage kan inte vara mindre än 0
        if (baseDamage <= 0){
            throw new IllegalArgumentException(ConsoleColors.WARNING + "\nBase Damage must be greater than 0." +
                    ConsoleColors.DEFAULT);
        }

        // Accuracy behöver vara mellan 1 - 100
        if (accuracy < 1 || accuracy > 100){
            throw new IllegalArgumentException(ConsoleColors.WARNING + "\nAccuracy must be between 1 - 100" +
                    ConsoleColors.DEFAULT);
        }

        // En attack behöver en element
        if (element == null){
            throw new IllegalArgumentException(ConsoleColors.ERROR + "\nAn Attack needs an Element!" +
                    ConsoleColors.DEFAULT);
        }

        // Sparar den validerade infon i attack-objektet
        this.name = name;
        this.baseDamage = baseDamage;
        this.accuracy = accuracy;
        this.element = element;
    }

    // Getters som gör det möjligt för andra..
    // klasser att läsa Attack-objektets privata värden
    public String getName(){
        return name;
    }

    public int getBaseDamage(){
        return baseDamage;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public Element getElement() {
        return element;
    }
}
