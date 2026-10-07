package org.example.model;

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

    // Skapar en ny Pokémon och kontrollera att informationen är giltig
    public Pokemon(String name, Element element, int maxHp, int currentHp){

        // Pokémon namnet kan inte vara tomt
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("\n\u001B[31mPokémon name cannot be empty!\u001B[0m");
        }

        // maxHp kan inte vara mindre än 0
        if (maxHp <= 0){
            throw new IllegalArgumentException("\n\u001B[31mThe Max HP must be greater than 0!\u001B[0m");
        }

        // currentHp kan inte vara negativt
        if (currentHp < 0){
            throw new IllegalArgumentException("\n\u001B[31mThe Current HP cannot be negative!\u001B[0m");
        }

        // currentHp kan inte vara högre än maxHp
        if (currentHp > maxHp){
            throw new IllegalArgumentException("\n\u001B[31mThe Current HP cannot be higher than the Max HP.\u001B[0m");
        }

        this.name = name;
        this.element = element;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.attacks = new ArrayList<>();
    }

    // Getters som gör det möjligt för andra..
    // klasser att läsa Pokémons privata värden
    public String getName(){
        return name;
    }
    //ÄNDRA NAMN
    public void setName(String name){

        // Pokemon namn kan inte vara tomt
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("\n\u001B[31mPokémon name cannot be empty!\u001b[0m");
        }
        this.name = name;
    }

    public Element getElement(){
        return element;
    }

    public void setElement(Element element){
        this.element = element;
    }

    public int getMaxHp(){
        return maxHp;
    }

    public void setMaxHp(int maxHp){

        // Max HP kan inte vara mindre än 0
        if (maxHp <= 0){
            throw new IllegalArgumentException("\n\u001B[31mMax HP must be greater than 0!\u001B[0m");
        }
        this.maxHp = maxHp;
    }

    public int getCurrentHp(){
        return currentHp;
    }

    public void setCurrentHp(int currentHp){

        // Current HP kan inte vara negativt
        if (currentHp < 0){
            throw new IllegalArgumentException("\n\u001B[31mThe Current HP cannot be negative!\u001B[0m");
        }

        // Current HP kan inte vara högre än Max HP
        if (currentHp > maxHp){
            throw new IllegalArgumentException("\n\u001B[31mThe Current HP cannot be higher than Max HP!\u001B[0m");
        }
        this.currentHp = currentHp;
    }

    public List<Attack> getAttacks(){
        return attacks;
    }

    // Lägger till en attack till Pokémon
    public void addAttack(Attack attack){
        //Pokémon max 4 attacker
        if (attacks.size() >= 4){
            throw new IllegalArgumentException("\n\u001B[31mA Pokémon cannot have more than 4 attacks!\u001B[0m");
        }
        // Pokémon ingen tom attack
        if (attack == null){
            throw new IllegalArgumentException("\n\u001B[31mAttack cannot be empty!\u001B[0m");
        }
        attacks.add(attack);
    }

    public void removeAttack(Attack attack){

        // En Pokémon måste alltid ha minst 1 attack
        if(attacks.size() <= 1){
            throw new IllegalArgumentException(
                    "\n\u001B[33mA Pokémon must have at least 1 attack!\u001B[0m");
        }

        attacks.remove(attack);
    }
}

