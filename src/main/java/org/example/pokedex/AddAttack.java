package org.example.pokedex;

import org.example.input.ConsoleColors;
import org.example.input.InputHelper;
import org.example.model.Attack;
import org.example.model.Element;

import java.util.Scanner;

public class AddAttack {

    public static Attack create(Scanner scan) {

        // Läser in attackens namn
        String attackName;
        while (true) {

            System.out.print("Attack Name: ");
            attackName = scan.nextLine();

            if (attackName.isBlank()) {
                System.out.println(ConsoleColors.WARNING + "\nAttack Name cannot be empty. Try again." +
                        ConsoleColors.DEFAULT);
            } else {
                break;
            }
        }

        // Läser in base damage
        int baseDamage = InputHelper.readIntBetween(scan,
                "Base Damage: ", 1, 100);

        // Läser in Accuracy
        int accuracy = InputHelper.readIntBetween(scan,
                "Accuracy: ", 1, 100);

        // Läser in attackens element
        Element attackElement;

        while (true) {
            System.out.print("Attack Element: ");
            String attackElementInput = scan.nextLine();

            try {
                attackElement = Element.valueOf(attackElementInput.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ConsoleColors.ERROR + "\nInvalid Element, try again." + ConsoleColors.DEFAULT);
                System.out.println(ConsoleColors.WARNING + "Choose between: " + ConsoleColors.DEFAULT +
                        "\u001B[34mWATER\u001B[0m, " +
                        "\u001B[31mFIRE\u001B[0m, " +
                        "\u001B[32mGRASS\u001B[0m, " +
                        "\u001B[33mELECTRIC\u001B[0m " +
                        "& \u001B[97mNORMAL.\n\u001B[0m");
            }
        }

        // Skapar attacken
        return new Attack(
                attackName,
                baseDamage,
                accuracy,
                attackElement);
    }
}
