package com.guessinggame.ui;

import com.guessinggame.domain.*;
import java.util.Scanner;


public class ConsoleUI implements UserInput, UserOutput{
    private Scanner scanner;

    public ConsoleUI(Scanner scanner){
        this.scanner = scanner;
    } 

    

    @Override
    public int askForNumber(String message) {
        showOutput(message);
        int number = Integer.parseInt(scanner.nextLine());
        return number;
    }



    @Override
    public String askForString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }



    @Override
    public void showOutput(String message) {
        System.out.println(message);
    }
}
