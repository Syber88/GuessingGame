package com.guessinggame.ui;

import com.guessinggame.domain.*;
import java.util.Scanner;


public class ConsoleUI implements UserInput{
    private Scanner scanner;

    public ConsoleUI(Scanner scanner){
        this.scanner = scanner;
    } 

    

    @Override
    public int askForNumber(String message) {
        System.out.println(message);
        int number = Integer.parseInt(scanner.nextLine());
        return number;
    }



    @Override
    public String askForString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }



   
}
