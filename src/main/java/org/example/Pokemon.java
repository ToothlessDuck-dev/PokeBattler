package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    //Pokémons namn
    private String name;

    //Pokémon element
    private Element element;

    private int maxHp;

    private int currentHp;

    //En lista med attacker pokémon kan använda
    private List<Attack> attacks;

    //Skapar en ny Pokémon med basic information och en tom attack lista
    //Kolla ifall det är giltig information
    public Pokemon(String name, Element element, int maxHp, int currentHp){

        //Ifall Pokémon namnet är tomt
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Pokémon name cannot be empty!");
        }

        //currentHp kan inte vara negativt
        if (currentHp < 0){
            throw new IllegalArgumentException("The Current HP cannot be negative!");
        }

        //currentHp kan inte vara högre än maxHp
        if (currentHp > maxHp){
            throw new IllegalArgumentException("The Current HP cannot be higher than the Max HP");
        }

        this.name = name;
        this.element = element;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.attacks = new ArrayList<>();
    }

    //Metoder för att göra det möjligt för andra..
    // klasser att läsa Pokémons privata värden
    public String getName(){
        return name;
    }

    public Element getElement(){
        return element;
    }

    public int getMaxHp(){
        return maxHp;
    }

    public int getCurrentHp(){
        return currentHp;
    }

    public List<Attack> getAttacks(){
        return attacks;
    }
}

