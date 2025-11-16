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
            Player loadedPlayer = repository.load(player.getName());
            if (loadedPlayer != null){
                player = loadedPlayer;
                uo.showOutput("Welcome back, " + player.getName() + " !");
            } else {
                uo.showOutput("New player: " + player.getName());
            }

            boolean running = true;
            while (running){
                ui.askForNumber();
            }

        } catch (Exception e){
            uo.showOutput("Error: " + e.getMessage());
        }
    }
}
