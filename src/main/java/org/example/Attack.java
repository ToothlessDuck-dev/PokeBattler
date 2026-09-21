package org.example;

public class Attack {

    //Namn för attack
    private String name;

    //Hur mycket damage gör attacken
    private int baseDamage;

    //Chans för träff av attack
    private int accuracy;

    //Vilken typ av attack
    private Element element;

    //Format vid skapandet av en attack
    public Attack(String name, int baseDamage, int accuracy, Element element){
        this.name = name;
        this.baseDamage = baseDamage;
        this.accuracy = accuracy;
        this.element = element;
    }

    //Metoder för att göra det möjligt för andra..
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
