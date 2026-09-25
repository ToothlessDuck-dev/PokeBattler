package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PokedexFile {

    // Sparar alla Pokémon och deras attacker i en fil
    public static void save(Pokedex pokedex){

        try(PrintWriter write = new PrintWriter(new FileWriter("pokedex.txt"))){

            for (Pokemon pokemon : pokedex.getPokemon()){

                // Skriver Pokémonens information
                write.println(
                        "Name: " + pokemon.getName() + " | " +
                        "Element: " + pokemon.getElement() + " | " +
                        "Max HP: " + pokemon.getMaxHp() + " | " +
                        "Current HP: " + pokemon.getCurrentHp() + " | ");

                for (Attack attack : pokemon.getAttacks()){

                    //Skriver Pokémonens attacker
                    write.println(
                            "ATTACK: " + attack.getName() + " | " +
                            "Base Damage: " + attack.getBaseDamage() + " | " +
                            "Accuracy: " + attack.getAccuracy() + " | " +
                            "Element: " + attack.getElement() + " | ");
                }

                write.println("\n=================================================" +
                        "===================================\n");
            }
            System.out.println("\nPokédex saved successfully!");
        } catch (IOException e){
            System.out.println("\nCould not save the Pokédex!");
        }
    }

    // Läser in Pokémon och deras attacker från filen
    public static void load(Pokedex pokedex){

        try(BufferedReader reader = new BufferedReader(new FileReader("pokedex.txt"))){

            pokedex.getPokemon().clear();

            String line;
            Pokemon currentPokemon = null;

            // Läser filen rad för rad
            while((line = reader.readLine()) != null){

                // Hoppar över tomma rader och avdelare
                if (line.isBlank() || line.startsWith("===")){
                    continue;
                }

                String[] parts = line.split("\\|");

                if (parts[0].trim().startsWith("ATTACK:")){

                    String name = parts[0].trim().replace("ATTACK:", "").trim();
                    int baseDamage = Integer.parseInt(
                            parts[1].trim().replace("Base Damage:", "").trim());
                    int accuracy = Integer.parseInt(
                            parts[2].trim().replace("Accuracy:", "").trim());
                    Element element = Element.valueOf(
                            parts[3].trim().replace("Element: ", "").trim());

                    Attack attack = new Attack(
                            name,
                            baseDamage,
                            accuracy,
                            element);

                    currentPokemon.addAttack(attack);
                } else if(parts[0].trim().startsWith("Name:")){

                    String name = parts[0].trim().replace("Name:", "").trim();
                    Element element = Element.valueOf(
                            parts[1].trim().replace("Element:", "").trim());
                    int maxHp = Integer.parseInt(
                            parts[2].trim().replace("Max HP:", "").trim());
                    int currentHp = Integer.parseInt(
                            parts[3].trim().replace("Current HP:", "").trim());

                    currentPokemon = new Pokemon(
                            name,
                            element,
                            maxHp,
                            currentHp);

                    pokedex.addPokemon(currentPokemon);
                }
            }

            System.out.println("\nPokédex loaded successfully!");

        } catch (IOException e){
            System.out.println("\nCouldn't load the Pokédex!");
        }
    }
}
