package com.guessinggame;

import java.util.Scanner;

import com.guessinggame.application.GameService;
import com.guessinggame.domain.GameRules;
import com.guessinggame.domain.Player;
import com.guessinggame.domain.PlayerStatsRepository;
import com.guessinggame.domain.ScoreTracker;
import com.guessinggame.domain.SecretNumberGenerator;
import com.guessinggame.domain.UserInput;
import com.guessinggame.domain.UserOutput;
import com.guessinggame.infrastructure.JsonPlayerStatsRepository;
import com.guessinggame.infrastructure.RandomSecretNumberGenerator;
import com.guessinggame.ui.ConsoleUI;
import com.guessinggame.ui.ConsoleUO;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInput ui = new ConsoleUI(scanner);
        UserOutput uo = new ConsoleUO();
        SecretNumberGenerator generator = new RandomSecretNumberGenerator();
        GameRules rules = new GameRules();
        PlayerStatsRepository repository = new JsonPlayerStatsRepository();

        GameService service = new GameService(ui, uo, generator, rules, repository);

        String name = ui.askForString("What is your name?");
        Player player = new Player(name, new ScoreTracker());

        service.startGame(player);

    }

}
