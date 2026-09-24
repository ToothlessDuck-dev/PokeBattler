package org.example;

import java.util.Scanner;

public class AddAttack {

    public static Attack create(Scanner scan) {

        //Attack Name
        String attackName;
        while (true) {

            System.out.print("Attack Name: ");
            attackName = scan.nextLine();

            if (attackName.isBlank()) {
                System.out.println("\n\u001B[33mAttack Name cannot be empty. Try again.\u001B[0m");
            } else {
                break;
            }
        }

        // Base Damage
        int baseDamage = InputHelper.readIntBetween(scan,
                "Base Damage: ", 1, 100);

        // Accuracy
        int accuracy = InputHelper.readIntBetween(scan,
                "Accuracy: ", 1, 100);

        // Attack Element
        Element attackElement;

        while (true) {
            System.out.print("Attack Element: ");
            String attackElementInput = scan.nextLine();

            try {
                attackElement = Element.valueOf(attackElementInput.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("\n\u001B[31mInvalid Element, try again.\u001B[0m");
                System.out.println("\u001B[31mChoose between: " +
                        "\u001B[34mWATER\u001B[0m, " +
                        "\u001B[31mFIRE\u001B[0m, " +
                        "\u001B[32mGRASS\u001B[0m, " +
                        "\u001B[33mELECTRIC\u001B[0m " +
                        "& \u001B[97mNORMAL.\n\u001B[0m");
            }
        }

        // Create the attack
        return new Attack(
                attackName,
                baseDamage,
                accuracy,
                attackElement);
    }
}
