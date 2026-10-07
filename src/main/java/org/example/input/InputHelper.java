package org.example.input;

import java.util.Scanner;

public class InputHelper {

   // Läser in ett heltal till användaren skriver ett giltigt tal.
   public static int readInt(Scanner scan, String prompt){

       while (true){
           System.out.print(prompt);

           try{
               return Integer.parseInt(scan.nextLine());
           } catch (NumberFormatException e){
               System.out.println("\n\u001B[31mPlease enter a valid number.\n\u001B[0m");
           }
       }
   }

   // Läser in ett heltal mellan min & max
    public static int readIntBetween(Scanner scan, String prompt, int min, int max){

       while (true){
           int number = readInt(scan, prompt);

           if (number >= min && number <= max){
               return number;
           }

           System.out.println("\n\u001B[31mPlease enter a number between " + min + " and " + max + ".\u001B[0m\n");
       }
    }

    // Validerar "Yes" eller "No" från användaren
    public static boolean readYesNo(Scanner scan, String prompt){

       while (true){
           System.out.print(prompt);
           String input = scan.nextLine().trim().toLowerCase();

           if (input.equals("yes")){
               return true;
           }

           if (input.equals("no")){
               return false;
           }

           System.out.println("\n\u001B[33mPlease enter Yes or No.\n\u001B[0m");
       }
    }

}
