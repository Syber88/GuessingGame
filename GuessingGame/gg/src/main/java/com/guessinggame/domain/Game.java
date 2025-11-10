package com.guessinggame.domain;

import java.util.Scanner;
import com.guessinggame.ui.ConsoleUI;
import java.util.Random;

public class Game {
    private Player player;
    private int playerWinCount;
    private int playerLossCount;
    private ConsoleUI userInterface;
    private Random random;

    public Game(Scanner scanner, Player player){
        this.player = player;
        this.random = new Random();
        this.playerWinCount = 0;
        this.playerLossCount = 0;
        this.userInterface = new ConsoleUI(scanner);
    }

    public void start(){
        userInterface.showMessage("GREETINGS " + player.getName());
        while(true){
            try {
                int start = userInterface.askForNumber("Enter the start range: (Negative number quits game)");    
                int end = userInterface.askForNumber("Enter the end range: (Negative number quits game)");

                if (start < 0 || end < 0){
                    userInterface.showMessage("GoodBye!");
                    break;
                }

                int secret = generateSecret(start, end);

                int playerGuess = userInterface.askForNumber("What is your guess?");
                while (isOutOfRange(playerGuess, start, end)) {
                    userInterface.showMessage(
                        "Please enter a number within the range <" + start + "-" + end + ">."
                    );
                    playerGuess = userInterface.askForNumber("Try again:");
                }
                
                OutCome outcome = getOutcome(secret, playerGuess);
                this.scoreCounter(outcome);
                userInterface.showMessage(this.getPlayerWinCount(), this.getPlayerLossCount());
            } catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public int generateSecret(int start, int end){
        return random.nextInt((end - start + 1 ) + start);
    }

        public boolean isOutOfRange(int playerGuess, int startRange, int endRange){
            if (playerGuess < startRange || playerGuess > endRange){
                return true;
            }
            return false;
        }

    public OutCome getOutcome(int secret, int playerGuess){
        if (playerGuess == secret){
            userInterface.showMessage(OutCome.WIN.getMessage());
            return OutCome.WIN;
        }
        userInterface.showMessage(OutCome.LOSS.getMessage());
        return OutCome.LOSS;
    }

    private void winIncrement(){
        this.playerWinCount++;
    }

    private void lossIncrement(){
        this.playerLossCount++;
    }
    
    public void scoreCounter(OutCome result){
        if (result == OutCome.WIN){
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