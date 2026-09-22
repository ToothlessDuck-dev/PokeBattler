package org.example;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Pokedex pokedex = new Pokedex();
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

            switch (val){
                //CASE 1: LÄGG TILL ELEMENT, HP ETC TILL ELSE/FOR*
                case "1":
                    System.out.println("\n=== All Pokémon ===");

                    if (pokedex.getPokemon().isEmpty()){
                        System.out.println("The Pokédex is empty...");
                    }
                    else{
                        for  (Pokemon pokemon : pokedex.getPokemon()){
                            System.out.println();
                        }
                    }
                    break;

                case "2":
                    System.out.println("\nAdd Pokémon");
                    break;

                case "3":
                    System.out.println("\nEdit Pokémon");
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