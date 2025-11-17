package com.guessinggame.application;

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
            Player loadedPlayer = repository.load(player.getName());
            if (loadedPlayer != null){
                player = loadedPlayer;
                uo.showOutput("Welcome back, " + player.getName() + " !");
            } else {
                uo.showOutput("New player: " + player.getName());
            }

            boolean running = true;
            while (running){
                int start = ui.askForNumber("Enter start range (Negative number quits):");
                if ( start < 0 ) break;

                int end = ui.askForNumber("Enter the end range (Negative number quits):");
                if (end < 0) break;

                if (start >= end){
                    uo.showOutput("The start of the range should not be greateer than the end");
                    continue;
                }

                uo.showOutput("Generating secret");
                /*
                 * loading screen type of situation here
                 */
                uo.loadingLoop();
                int secret = generator.generateSecretNumber(start, end);

                int guess = ui.askForNumber("\nWhat is your guess?");
                while (rules.isOutOfRange(guess, start, end)){
                    uo.showOutput("Please pick a number within the range <" + start + "-" + end + ">");
                    guess = ui.askForNumber("What is your guess?");
                }

                OutCome outcome = rules.getOutcome(secret, guess);
                uo.showOutput(outcome.getMessage());
                if (outcome == OutCome.WIN){
                    player.recordWin();
                } else {
                    player.recordLoss();
                }
            }

            repository.save(player);

        } catch (Exception e){
            uo.showOutput("Error: " + e.getMessage());
        }
    }
}
