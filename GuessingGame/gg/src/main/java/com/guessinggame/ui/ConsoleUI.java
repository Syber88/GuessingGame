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

    public int askForNumber(){
        while (true){
            System.out.println("Enter a number");
            try {
                int number = Integer.parseInt(this.scanner.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Enter a proper number");
            }
            
        }
    }


}
