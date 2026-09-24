package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    // Pokémons namn
    private String name;

    // Pokémon element
    private Element element;

    // Pokémon max hp
    private int maxHp;

    // Pokémons nuvarande hp
    private int currentHp;

    // En lista med attacker pokémon kan använda
    private List<Attack> attacks;

    // Skapar en ny Pokémon med basic information och en tom attack lista
    // Kolla ifall det är giltig information
    public Pokemon(String name, Element element, int maxHp, int currentHp){

        //Ifall Pokémon namnet är tomt
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Pokémon name cannot be empty!");
        }

        //maxHp kan inte vara mindre än 0
        if (maxHp <= 0){
            throw new IllegalArgumentException("The Max HP must be greater than 0!");
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
    //ÄNDRA NAMN
    public void setName(String name){

        //Pokemon namn kan inte vara tomt
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Pokémon name cannot be empty!");
        }
        this.name = name;
    }

    public Element getElement(){
        return element;
    }
    //ÄNDRA POKEMONS ELEMENT
    public void setElement(Element element){
        this.element = element;
    }

    public int getMaxHp(){
        return maxHp;
    }
    //ÄNDRA HP
    public void setMaxHp(int maxHp){

        //Max HP kan inte vara mindre än 0
        if (maxHp <= 0){
            throw new IllegalArgumentException("Max HP must be greater than 0!");
        }
        this.maxHp = maxHp;
    }

    public int getCurrentHp(){
        return currentHp;
    }
    //Ändra Pokemons current HP
    public void setCurrentHp(int currentHp){

        //Current HP kan inte vara negativt
        if (currentHp < 0){
            throw new IllegalArgumentException("The Current HP cannot be negative!");
        }

        //Current HP kan inte vara högre än Max HP
        if (currentHp > maxHp){
            throw new IllegalArgumentException("The Current HP cannot be higher than Max HP!");
        }
        this.currentHp = currentHp;
    }

    public List<Attack> getAttacks(){
        return attacks;
    }

    //Lägger till en attack till Pokémon
    public void addAttack(Attack attack){
        //Pokémon max 4 attacker
        if (attacks.size() >= 4){
            throw new IllegalArgumentException("A Pokémon cannot have more than 4 attacks!");
        }
        //Pokémon ingen tom attack
        if (attack == null){
            throw new IllegalArgumentException("Attack cannot be empty!");
        }
        attacks.add(attack);
    }

    public void removeAttack(Attack attack){
        attacks.remove(attack);
    }
}

