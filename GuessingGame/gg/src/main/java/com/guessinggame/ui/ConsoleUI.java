package com.guessinggame.ui;

import java.util.Scanner;


public class ConsoleUI {
    private Scanner scanner;

    public ConsoleUI(Scanner scanner){
        this.scanner = scanner;
    } 

    public void showMessage(String message){
        System.out.println(message);
    }

    public void showMessage(int wins, int losses){
        String inGameScores = "Wins: " + wins + "\nLosses: " + losses;
        showMessage(inGameScores);
    }   

    public int askForNumber(String message){
        while (true){
            showMessage(message);
            try {
                int number = Integer.parseInt(this.scanner.nextLine());
                return number;
            } catch (NumberFormatException e) {
                showMessage("Enter a proper number");
            }
        }
    }


}
