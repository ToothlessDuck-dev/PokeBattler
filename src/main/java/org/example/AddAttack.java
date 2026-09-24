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
                System.out.println("Attack Name cannot be empty. Try again.");
            } else {
                break;
            }
        }

        // Base Damage
        int baseDamage = InputHelper.readIntBetween(scan,
                "Base Damage: ", 1, Integer.MAX_VALUE);

        // Accuracy
        int accuracy = InputHelper.readIntBetween(scan,
                "Accuracy: ", 0, 100);

        // Attack Element
        Element attackElement;

        while (true) {
            System.out.print("Attack Element: ");
            String attackElementInput = scan.nextLine();

            try {
                attackElement = Element.valueOf(attackElementInput.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Element. Try again.");
                System.out.println("Choose between: FIRE, WATER, GRASS, ELECTRIC & NORMAL");
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
