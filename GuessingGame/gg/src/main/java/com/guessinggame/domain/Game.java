package com.guessinggame.domain;

import java.util.Scanner;
import com.guessinggame.ui.ConsoleUI;
import java.util.Random;

public class Game {
    private int playerWinCount;
    private int playerLossCount;
    private ConsoleUI userInterface;
    private Random random;

    public Game(Scanner scanner){
        this.random = new Random();
        this.playerWinCount = 0;
        this.userInterface = new ConsoleUI(scanner);
    }

    public void start(Scanner scanner){
        while(true){
            try {
                int start = userInterface.askForNumber("Enter the start range");    
                int end = userInterface.askForNumber("Enter the end range");
                int secret = generateSecret(start, end);

                int playerGuess = userInterface.askForNumber("What is your guess?");
                OutCome outcome = getOutcome(secret, playerGuess);
                this.scoreCounter(outcome);
            } catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public int generateSecret(int start, int end){
        return random.nextInt((end - start + 1 ) + start);
    }

    public OutCome getOutcome(int secret, int playerGuess){
        if (playerGuess == secret){
            return OutCome.WIN;
        }
        return OutCome.LOSS;
    }

    private void winIncrement(){
        this.playerWinCount++;
    }

    private void lossIncrement(){
        this.playerLossCount++;
    }
    
    private void scoreCounter(OutCome result){
        if (result == OutCome.LOSS){
            this.winIncrement();
        }
        this.lossIncrement();
    }

    public int getPlayerWinCount(){
        return this.playerWinCount;
    }

    public int getPlayerLossCount(){
        return this.playerLossCount;
    }


}