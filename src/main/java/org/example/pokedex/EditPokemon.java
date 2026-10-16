package org.example.pokedex;

import org.example.input.ConsoleColors;
import org.example.input.InputHelper;
import org.example.model.Attack;
import org.example.model.Element;
import org.example.model.Pokemon;

import java.util.Scanner;

public class EditPokemon {

    public static void edit(Scanner scan, Pokedex pokedex){

        System.out.println("\n=== Edit Pokémon ===");

        // Kontrollera att Pokédex inte är tomt
        if(pokedex.getPokemon().isEmpty()){
            System.out.println(ConsoleColors.WARNING + "\nThe Pokédex is empty" + ConsoleColors.DEFAULT);
            System.out.println(ConsoleColors.WARNING + "Please add a Pokémon.\n" + ConsoleColors.DEFAULT);
            return;
        }

        // Visa alla Pokémon
        for (int i = 0; i < pokedex.getPokemon().size(); i++){
            System.out.println(
            "[" + (i + 1) + "] " +
            pokedex.getPokemon().get(i).getName());
        }

        // Välj en Pokémon
        int choice = InputHelper.readIntBetween(scan,
                "> Choose a Pokémon: ",
                1, pokedex.getPokemon().size());

        Pokemon selectedPokemon = pokedex.getPokemon().get(choice - 1);

        System.out.println("\n>>> Editing: " + selectedPokemon.getName() + " <<<");

        System.out.println("[1] Change Name");
        System.out.println("[2] Change HP");
        System.out.println("[3] Change Element");
        System.out.println("[4] Add Attack");
        System.out.println("[5] Remove Attack");
        System.out.println("[6] Back");

        int editChoice = InputHelper.readIntBetween(scan,
                "> Choose an option: ",
                1, 6);

        switch (editChoice){

            case 1:
                System.out.print("\nNew Name: ");
                String newName = scan.nextLine();

                if (newName.isBlank()){
                    System.out.println(ConsoleColors.WARNING + "\nName cannot be empty.\n" + ConsoleColors.DEFAULT);
                    break;
                }

                selectedPokemon.setName(newName);
                System.out.println("\n----------------------------------------");
                System.out.println(ConsoleColors.SUCCESS + "     Pokémon name changed to: " +
                        ConsoleColors.DEFAULT + newName);
                System.out.println("----------------------------------------\n");
                break;

            case 2:
                int newMaxHp = InputHelper.readIntBetween(scan,
                        "\nNew Max HP: ",
                        1, 100);

                int newCurrentHp = InputHelper.readIntBetween(scan,
                        "New Current HP: ",
                        0, newMaxHp);

                selectedPokemon.setMaxHp(newMaxHp);
                selectedPokemon.setCurrentHp(newCurrentHp);

                System.out.println("\n----------------------------------------");
                System.out.println(ConsoleColors.SUCCESS + "          Pokémon HP changed!" + ConsoleColors.DEFAULT);
                System.out.println("----------------------------------------\n");
                break;

            case 3:
                while (true) {
                    System.out.print("\nNew Element: ");
                    String newElementInput = scan.nextLine();

                    try {
                        Element newElement = Element.valueOf(newElementInput.toUpperCase());
                        selectedPokemon.setElement(newElement);

                        System.out.println("\n----------------------------------------");
                        System.out.println(ConsoleColors.SUCCESS + "   Pokémon Element changed to: " +
                                ConsoleColors.DEFAULT + newElement);
                        System.out.println("----------------------------------------\n");
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(ConsoleColors.ERROR + "\nInvalid Element, try again." + ConsoleColors.DEFAULT);
                        System.out.println("\u001B[31mChoose between: " +
                                "\u001B[34mWATER\u001B[0m, " +
                                "\u001B[31mFIRE\u001B[0m, " +
                                "\u001B[32mGRASS\u001B[0m, " +
                                "\u001B[33mELECTRIC\u001B[0m " +
                                "& \u001B[97mNORMAL.\u001B[0m");
                    }
                }
                break;

            case 4:

                // Kontrollera att Pokémon redan har 4 attacker
                if (selectedPokemon.getAttacks().size() >= 4){
                    System.out.println(ConsoleColors.WARNING + "\nThis Pokémon already has 4 attacks!" + ConsoleColors.DEFAULT);
                    break;
                }

                System.out.println("\n=== Add Attack ===");

                Attack attack = AddAttack.create(scan);
                selectedPokemon.addAttack(attack);

                System.out.println("\n----------------------------------------");
                System.out.println(ConsoleColors.SUCCESS + "              " +
                        "Attack added!" + ConsoleColors.DEFAULT);
                System.out.println("----------------------------------------\n");
                break;

            case 5:

                // Kontrollera att Pokémon har attacker
                if (selectedPokemon.getAttacks().size() <= 1){
                    System.out.println(ConsoleColors.WARNING + "\nThis Pokémon must have at least 1 attack.\n" +
                            ConsoleColors.DEFAULT);
                    break;
                }

                System.out.println("\n=== Remove an attack ===");

                // Visa Pokémons attacker
                for(int i = 0; i < selectedPokemon.getAttacks().size(); i++){
                    System.out.println(
                            "[" + (i + 1) + "] " +
                            selectedPokemon.getAttacks().get(i).getName());
                }

                // Välj vilken attack som ska tas bort
                int attackChoice = InputHelper.readIntBetween(scan,
                        "> Choose an attack to remove: ",
                        1, selectedPokemon.getAttacks().size());

                // Hämtar attacken och bekräftar att användaren vill ta bort den
                Attack selectedAttack = selectedPokemon.getAttacks().get(attackChoice - 1);

                boolean confirm = InputHelper.readYesNo(scan,
                        "\n> Are you sure you want to remove " +
                        selectedAttack.getName() +
                        "? [YES] | [NO]: ");

                // Ta bort attacken
                if(confirm){
                    selectedPokemon.removeAttack(selectedAttack);
                    System.out.println("\n----------------------------------------");
                    System.out.println(" " + selectedPokemon.getName() +
                            " has forgotten how to use " +
                            selectedAttack.getName() + ".");
                    System.out.println("----------------------------------------\n");
                } else {
                    System.out.println("\n----------------------------------------");
                    System.out.println("  " + selectedPokemon.getName() +
                            " stays strong knowing " +
                            selectedAttack.getName() + ".");
                    System.out.println("----------------------------------------\n");
                }
                break;

            case 6:
                System.out.println("");
                break;
        }
    }
}
