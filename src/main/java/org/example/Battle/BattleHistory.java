package org.example.Battle;

import org.example.model.Pokemon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BattleHistory {

    private static final String FILE_NAME = "battle_history.txt";

    // Sparar en avslutad strid i fil
    public static void saveBattle(
            Pokemon playerPokemon,
            Pokemon cpuPokemon,
            String result) {

        if (result == null){
            System.out.println("\n\u001B[33mCould not get battle result information.\u001B[0m");
            return;
        }

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(FILE_NAME, true))) {

            String date = LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            writer.println("Date: " + date);

            writer.println("Your Pokémon: " + playerPokemon.getName() +
                    " | Final HP: " + playerPokemon.getCurrentHp() +
                    "/" + playerPokemon.getMaxHp());

            writer.println("Opponent: " + cpuPokemon.getName() +
                    " | Final HP: " + cpuPokemon.getCurrentHp() +
                    "/" + cpuPokemon.getMaxHp());

            if (result.equalsIgnoreCase("WIN")
                || result.equalsIgnoreCase("VICTORY")){

                writer.println("Result: VICTORY");
            } else if (result.equalsIgnoreCase("LOSS")
                || result.equalsIgnoreCase("DEFEAT")){

                writer.println("Result: DEFEAT");
            } else {
                System.out.println("\n\u001B[33mCould not get battle result information.\u001B[0m");
                return;
            }

            writer.println("\n--------------------------------------------------\n");

            System.out.println("\n      Battle saved to history!");

        } catch (IOException e) {
            System.out.println("\n      Could not save battle history!");
        }
    }

    // Visar alla sparade strider
    public static void showHistory() {

        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            System.out.println("\nNo Battles have been recorded yet.");
            return;
        }

        System.out.println("\n========== BATTLE HISTORY ==========\n");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("\n====================================");

        } catch (IOException e) {
            System.out.println("\nCould not read battle history!");
        }
    }

    // Visar sasmmanlagd statistik för alla sparade strider
    public static void showStatistics(){
        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            System.out.println("\n\u001B[33mNo battles have been recorded\u001B[0m");
            System.out.println("\nTotal battles: 0");
            System.out.println("Wins: 0");
            System.out.println("Losses: 0");
            return;
        }

        int wins = 0;
        int losses = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

            String line;

            while ((line = reader.readLine()) != null){

                if (line.equals("Result: VICTORY")){
                    wins++;
                } else if (line.equals("Result: DEFEAT")){
                    losses++;
                }
            }

            System.out.println("\n========== BATTLE STATISTICS ==========\n");
            System.out.println("Total battles: " + (wins + losses));
            System.out.println("Wins: " + wins);
            System.out.println("Losses: " + losses);
            System.out.println("\n=======================================");
        } catch (IOException e){
            System.out.println("\n\u001B[33mCould not read the battle statistics.\u001B[0m");
        }
    }
}

