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

            if (result.equals("result")) {
                writer.println("Result: VICTORY");
            } else {
                writer.println("Result: DEFEAT");
            }

            writer.println("--------------------------------------------------\n");

            System.out.println("\nBattle saved to history!");

        } catch (IOException e) {
            System.out.println("\nCould not save battle history!");
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

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("\n====================================");

        } catch (IOException e) {
            System.out.println("\nCould not read battle history!");
        }
    }
}

