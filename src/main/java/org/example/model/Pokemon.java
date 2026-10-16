package org.example.model;

import org.example.input.ConsoleColors;

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
            throw new IllegalArgumentException(ConsoleColors.ERROR + "\nPokémon name cannot be empty!" +
                    ConsoleColors.DEFAULT);
        }

        // maxHp kan inte vara mindre än 0
        if (maxHp <= 0){
            throw new IllegalArgumentException(ConsoleColors.ERROR + "\nThe Max HP must be greater than 0!" +
                    ConsoleColors.DEFAULT);
        }

        // currentHp kan inte vara negativt
        if (currentHp < 0){
            throw new IllegalArgumentException(ConsoleColors.ERROR + "\nThe Current HP cannot be negative!" +
                    ConsoleColors.DEFAULT);
        }

        // currentHp kan inte vara högre än maxHp
        if (currentHp > maxHp){
            throw new IllegalArgumentException(ConsoleColors.ERROR + "\nThe Current HP cannot be higher than the Max HP." +
                    ConsoleColors.DEFAULT);
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
            throw new IllegalArgumentException(ConsoleColors.ERROR + "\nPokémon name cannot be empty!" +
                    ConsoleColors.DEFAULT);
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
            throw new IllegalArgumentException(ConsoleColors.ERROR + "\nMax HP must be greater than 0!" +
                    ConsoleColors.DEFAULT);
        }
        this.maxHp = maxHp;
    }

    public int getCurrentHp(){
        return currentHp;
    }

    public void setCurrentHp(int currentHp){

        // Current HP kan inte vara negativt
        if (currentHp < 0){
            throw new IllegalArgumentException(ConsoleColors.ERROR + "\nThe Current HP cannot be negative!" +
                    ConsoleColors.DEFAULT);
        }

        // Current HP kan inte vara högre än Max HP
        if (currentHp > maxHp){
            throw new IllegalArgumentException(ConsoleColors.ERROR + "\nThe Current HP cannot be higher than Max HP!" +
                    ConsoleColors.DEFAULT);
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
            throw new IllegalArgumentException(ConsoleColors.WARNING + "\nA Pokémon cannot have more than 4 attacks!" +
                ConsoleColors.DEFAULT);
        }
        // Pokémon ingen tom attack
        if (attack == null){
            throw new IllegalArgumentException(ConsoleColors.ERROR + "\nAttack cannot be empty!" + ConsoleColors.DEFAULT);
        }
        attacks.add(attack);
    }

    public void removeAttack(Attack attack){

        // En Pokémon måste alltid ha minst 1 attack
        if(attacks.size() <= 1){
            throw new IllegalArgumentException(ConsoleColors.ERROR +
                    "\nA Pokémon must have at least 1 attack!" + ConsoleColors.DEFAULT);
        }

        attacks.remove(attack);
    }
}

