package com.guessinggame.application;

import java.util.Scanner;
import com.guessinggame.domain.OutCome;
import com.guessinggame.domain.*;

public class GameService {
    private final UserInput ui;
    private final UserOutput uo;
    private final SecretNumberGenerator generator;
    private final GameRules rules;
    private final PlayerStatsRepository repository;

    public GameService(UserInput ui, 
                        UserOutput uo, 
                        SecretNumberGenerator generator, 
                        GameRules rules, 
                        PlayerStatsRepository repository) {
        this.ui = ui;
        this.uo = uo;
        this.generator = generator;
        this.rules = rules;
        this.repository = repository;
    }


    

    public void startGame(Player player){
        try {

        } catch (Exception e)

        while(true){
            try {
                int start = userInterface.askForNumber("Enter the start range: (Negative number quits game)");
                Thread.sleep(1000);    
                int end = userInterface.askForNumber("Enter the end range: (Negative number quits game)");
                Thread.sleep(1000);

                if (start < 0 || end < 0){
                    userInterface.showMessage("GoodBye!");
                    break;
                }
                userInterface.showMessage("\nGenerating secret");
                userInterface.loadingMessageLoop(5);
                int secret = generateSecret(start, end);

                int playerGuess = userInterface.askForNumber("\nWhat is your guess?");
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
}
