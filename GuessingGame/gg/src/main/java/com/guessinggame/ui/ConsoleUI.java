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
