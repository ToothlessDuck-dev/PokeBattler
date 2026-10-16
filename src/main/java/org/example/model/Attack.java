package org.example.model;

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
            throw new IllegalArgumentException("\nAttack name cannot be empty!");
        }

        // baseDamage kan inte vara mindre än 0
        if (baseDamage <= 0){
            throw new IllegalArgumentException("\nBase Damage must be greater than 0.");
        }

        // Accuracy behöver vara mellan 1 - 100
        if (accuracy < 1 || accuracy > 100){
            throw new IllegalArgumentException("\nAccuracy must be between 1 - 100");
        }

        // En attack behöver en element
        if (element == null){
            throw new IllegalArgumentException("\nAn Attack needs an Element!");
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
