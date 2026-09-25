package org.example;

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
            throw new IllegalArgumentException("\n\u001B[33mAttack name cannot be empty!\u001B[0m");
        }

        // baseDamage kan inte vara mindre än 0
        if (baseDamage <= 0){
            throw new IllegalArgumentException("\n\u001B[33mBase Damage must be greater than 0.\u001B[0m");
        }

        // Accuracy behöver vara mellan 1 - 100
        if (accuracy < 1 || accuracy > 100){
            throw new IllegalArgumentException("\n\u001B[33mAccuracy must be between 1 - 100\u001B[0m");
        }

        // En attack behöver en element
        if (element == null){
            throw new IllegalArgumentException("\n\u001B[33mAn Attack needs an Element!\u001B[0m");
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
