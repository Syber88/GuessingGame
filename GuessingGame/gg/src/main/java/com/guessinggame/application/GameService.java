package com.guessinggame.application;

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
            player = loadPlayer(player);
            
            while (true) {
                Range range = getValidRangeFromUser();
                if (range == null) break; // User quit
                
                playRound(player, range);
            }
            repository.save(player);
        } catch (Exception e) {
            uo.showOutput("Error starting game: " + e.getMessage());
        }
    }

    private Player loadPlayer(Player player) {
        Player loadedPlayer = repository.load(player.getName());
        if (loadedPlayer != null){
            player = loadedPlayer;
            uo.showOutput("Welcome back, " + player.getName() + " !");
            return loadedPlayer;
        } else {
            uo.showOutput("New player: " + player.getName());
            return player;
        }
    }

    private Range getValidRangeFromUser() {
        int start = ui.askForNumber("Enter start range (Negative number quits):");
        if (start < 0) return null;
        
        int end = ui.askForNumber("Enter the end range (Negative number quits):");
        if (end < 0) return null;
        
        if (start >= end) {
            uo.showOutput("The start of the range should not be greater than the end");
            return getValidRangeFromUser();
        }
        /*could have used a record but project is build on java 11, so a new class was created */
        return new Range(start, end);
    }

    private void playRound(Player player, Range range) {
        uo.showOutput("Generating secret");
        uo.loadingLoop();
        
        int secret = generator.generateSecretNumber(range.start(), range.end());
        playGuessingGame(player, secret, range);
    }

    private void playGuessingGame(Player player, int secret, Range range) {
        int tries = 4;
        
        while (tries > 0) {
            int guess = getValidGuess(range);
            
            OutCome outcome = rules.getOutcome(secret, guess);
            if (outcome == OutCome.WIN) {
                player.recordWin();
                uo.showOutput("Congratulations! You won!");
                return;
            }
            
            tries--;
            if (tries > 0) {
                uo.showOutput("Wrong! You have " + tries + " tries left!");
            }
        }
        
        player.recordLoss();
        uo.showOutput("Game over! The secret number was: " + secret);
    }

    private int getValidGuess(Range range) {
        while (true) {
            int guess = ui.askForNumber("What is your guess?");
            if (!rules.isOutOfRange(guess, range.start(), range.end())) {
                return guess;
            }
            uo.showOutput("Please pick a number within the range <" + 
                        range.start() + "-" + range.end() + ">");
        }
    }
}
