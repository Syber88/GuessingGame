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

        int number = Integer.parseInt(scanner.nextLine())
        return 0;
    }



    @Override
    public String askForString() {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public void showOutput() {
        
        
    }
}
