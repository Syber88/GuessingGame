package com.guessinggame.domain;

import java.util.Scanner;
import com.guessinggame.ui.ConsoleUI;
import java.util.Random;

public class Game {
    private int playerWinCount;
    private int computerWinCount;
    private ConsoleUI userInterface;
    private Scanner scanner;
    private Random random;

    public Game(Scanner scanner){
        this.random = new Random();
        this.playerWinCount = 0;
        this.computerWinCount = 0;
        this.scanner = scanner;
        this.userInterface = new ConsoleUI(scanner);
    }

    public void start(Scanner scanner){
        while(true){
            try {
                int start = userInterface.askForNumber("Enter the start range");    
                int end = userInterface.askForNumber("Enter the end range");
                int secret = generateSecret(start, end);


            } catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public int generateSecret(int start, int end){
        return random.nextInt((end - start + 1 ) + start);
    }


}