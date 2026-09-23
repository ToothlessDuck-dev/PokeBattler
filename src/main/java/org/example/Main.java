package org.example;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Pokedex pokedex = new Pokedex();
        pokedex.seedingPokemon();
        boolean running = true;

        //Kör Menu tills användaren stänger programmet
        while (running) {

            //MENU VAL
            System.out.println("\n====== Pokédex =====");
            System.out.println("[1] Show all Pokémon");
            System.out.println("[2] Add Pokémon");
            System.out.println("[3] Edit Pokémon");
            System.out.println("[4] Delete Pokémon");
            System.out.println("[5] Save to file");
            System.out.println("[6] Load from file");
            System.out.println("[7] Exit");
            System.out.print("Choose and option: ");

            //ANVÄNDARENS VAL
            String val = scan.nextLine();

            switch (val) {
                //Visa alla pokémon som finns i pokédexet
                case "1":
                    System.out.println("\n=== All Pokémon ===");

                    //Kollar om litan är tom
                    if (pokedex.getPokemon().isEmpty()) {
                        System.out.println("The Pokédex is empty...");
                    } else {
                        //Kollar igenom varje pokémon i pokédexet
                        for (Pokemon pokemon : pokedex.getPokemon()) {
                            System.out.println(
                                    pokemon.getName() +
                                            " | Element: " + pokemon.getElement() +
                                            " | HP: " + pokemon.getCurrentHp() +
                                            "/" + pokemon.getMaxHp());
                        }
                    }
                    break;

                //Lägg till en pokémon till pokédexet, namn, element, max hp, current hp
                case "2":
                    System.out.println("\n=== Add Pokémon ===");

                    //POKEMON NAMN

                    String name;

                    while (true){
                        System.out.print("Name: ");
                        name = scan.nextLine();

                        if (name.isBlank()){
                            System.out.println("Name cannot be empty, try again.");
                        } else {
                            break;
                        }
                    }

                    // POKEMON ELEMENT

                    Element element;

                    while (true){
                        System.out.println("Element: ");
                        String chosenElement = scan.nextLine();

                        try{
                            element = Element.valueOf(chosenElement.toUpperCase());
                            break;
                        } catch (IllegalArgumentException e){
                            System.out.println("Invalid Element. Try again.");
                        }
                    }

                    // MAX HP

                    int maxHp;

                    while (true){
                        System.out.print("Max HP: ");

                        try{
                            maxHp = Integer.parseInt(scan.nextLine());

                            if(maxHp <= 0){
                                System.out.println("Max HP must be higher than 0.");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e){
                            System.out.println("Max HP must be a number! Try again.");
                        }
                    }

                    //CURRENT HP

                    int currentHp;

                    while (true){
                        System.out.print("Current HP: ");

                        try{
                            currentHp = Integer.parseInt(scan.nextLine());

                            if (currentHp < 0){
                                System.out.println("Current HP cannot be negative");
                            } else if (currentHp > maxHp){
                                System.out.println("Current HP cannot be higher than the Max HP");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e){
                            System.out.println("Current HP has to be a number! Try again.");
                        }
                    }

                    //SKAPA POKEMON
                    Pokemon pokemon = new Pokemon(name, element, maxHp, currentHp);

                    boolean addAnotherAttack = true;

                    //Pokemon kan ha max 4 attacker
                    while (pokemon.getAttacks().size() < 4 && addAnotherAttack){

                        System.out.println("\n=== Add Attack ===");

                        //ATTACK NAMN
                        String attackName;

                        while (true){
                            System.out.print("Attack Name: ");
                            attackName = scan.nextLine();

                            if (attackName.isBlank()){
                                System.out.println("Attack Name cannot be empty. Try again.");
                            } else {
                                break;
                            }
                        }

                        // BASE DAMAGE
                        int baseDamage;

                        while (true){
                            System.out.print("Base Damage: ");

                            try{
                                baseDamage = Integer.parseInt(scan.nextLine());

                                if (baseDamage < 0){
                                    System.out.println("Base Damage cannot be negative. Try again.");
                                } else{
                                    break;
                                }
                            } catch (NumberFormatException e){
                                System.out.println("Base Damage must be a number! Try again");
                            }
                        }

                        //ACCURACY
                        int accuracy;

                        while (true){
                            System.out.print("Accuracy: ");

                            try{
                                accuracy = Integer.parseInt(scan.nextLine());

                                if (accuracy < 0 || accuracy > 100){
                                    System.out.println("Accuracy has to be between 0 - 100, try again");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e){
                                System.out.println("Accuracy has to be a number, try again!");
                            }
                        }

                        // ATTACK ELEMENT

                        // CREATE THE ATTACK

                        // CHECK FOR MAX AMOUNT OF ATTACKS

                        // ASK USER IF THEY WANT TO ADD ANOTHER ATTACK

                        // UPDATE THE POKEDEX
                    }

                case "3":
                    System.out.println("\n=== Edit Pokémon ===");

                    //Kontrollera att pokédexet inte är tomt
                    if (pokedex.getPokemon().isEmpty()){
                        System.out.println("The Pokédex is empty..");
                        break;
                    }

                    //Visar upp alla pokemon med ett nummer för användaren att välja enkelt
                    for (int i = 0; i < pokedex.getPokemon().size(); i++){
                        System.out.println(
                                "[" + (i + 1) + "] " +
                                pokedex.getPokemon().get(i).getName()
                        );
                    }

                    System.out.print("Choose A Pokémon: ");
                    int choice;

                    //Kontrollera att användaren skrev ett nummer.
                    try{
                        choice = Integer.parseInt(scan.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a number.");
                        break;
                    }

                    //Kontroller at valet finns i listan
                    if (choice < 1 || choice > pokedex.getPokemon().size()){
                        System.out.println("Invalid Pokémon choice.");
                        break;
                    }

                    //Hämtar Pokemon som användaren valde
                    Pokemon selectedPokemon = pokedex.getPokemon().get(choice - 1);
                    System.out.println("\nEditing: " + selectedPokemon.getName());

                    System.out.println("[1] Change Name");
                    System.out.println("[2] Change HP");
                    System.out.println("[3] Change Element");
                    System.out.println("[4] Add Attack");
                    System.out.println("[5] Remove Attack");
                    System.out.println("[6] Back");
                    System.out.print("Choose an option: ");

                    String editChoice = scan.nextLine();

                    switch (editChoice){
                        case "1":
                            System.out.print("\nNew Name: ");
                            String newName = scan.nextLine();

                            if (newName.isBlank()){
                                System.out.println("Name cannot be empty");
                                break;
                            }
                            selectedPokemon.setName(newName);
                            System.out.println("Pokémon name changed to: " + newName);
                            break;

                        case "2":
                            System.out.print("New Max HP: ");
                            int newMaxHp;

                            try{
                                newMaxHp = Integer.parseInt(scan.nextLine());

                                if (newMaxHp <= 0){
                                    System.out.println("Max HP must be greater than 0");
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Max HP must be a number.");
                                break;
                            }

                            System.out.print("New Current HP: ");
                            int newCurrentHp;

                            try {
                                newCurrentHp = Integer.parseInt(scan.nextLine());

                                if (newCurrentHp < 0){
                                    System.out.println("Current HP cannot be negative.");
                                    break;
                                }

                                if (newCurrentHp > newMaxHp){
                                    System.out.println("\nCurrent HP cannot be higher than Max HP.");
                                    break;
                                }
                            } catch (NumberFormatException e){
                                System.out.println("\nCurrent HP must be a number!");
                                break;
                            }

                            selectedPokemon.setMaxHp(newMaxHp);
                            selectedPokemon.setCurrentHp(newCurrentHp);

                            System.out.println("Pokémon HP changed!");

                            break;

                        case "3":
                            System.out.print("\nNew Element: ");
                            String newElementInput = scan.nextLine();

                            Element newElement;

                            try{
                                newElement = Element.valueOf(newElementInput.toUpperCase());
                            } catch (IllegalArgumentException e){
                                System.out.println("Ivalid Element.");
                                break;
                            }

                            selectedPokemon.setElement(newElement);
                            System.out.println("\nPokémon Element Changed to: " + newElement);
                            break;

                        case "4":
                            System.out.println("Add Attack");
                            break;

                        case "5":
                            System.out.println("Remove Attack");
                            break;

                        case "6":
                            break;

                        default:
                            System.out.println("Please Choose A Number From 1-6");
                    }

                    break;

                case "4":
                    System.out.println("\nDelete Pokémon");
                    break;

                case "5":
                    System.out.println("\nSave to file");
                    break;

                case "6":
                    System.out.println("\nLoad from file");
                    break;

                case "7": //Ändra running till false
                    running = false;
                    System.out.println("\nGoodbye!");
                    break;

                default:
                    System.out.println("\nPlease choose a number from 1-7");

            }
        }
        scan.close();
    }
}