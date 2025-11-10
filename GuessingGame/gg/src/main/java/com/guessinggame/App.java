package com.guessinggame;

import java.util.Scanner;
import com.guessinggame.domain.Game;
import com.guessinggame.domain.Player;
import com.guessinggame.persistence.PlayerScoreHistory;
import com.guessinggame.ui.*;

public class App 
{
    public static void main( String[] args ) throws Exception{
        Scanner scanner = new Scanner(System.in);
        ConsoleUI ui = new ConsoleUI(scanner);
        PlayerScoreHistory history = new PlayerScoreHistory();

        String name = ui.askForName();
        Player player = new Player(name);
        String fileName = history.getFileName();

        if (history.playerExists(name, fileName)){
            ui.showMessage("Welcome back, Old friend");
            player = history.loadPlayerStats(player, fileName);
        }
        
        
        // Player player = new Player(name);
        Game game = new Game(scanner, player);
        history.showAllTimePlayerStats(player, ui);
        game.start();
        history.saveStats(player, fileName, game);
        /**
         * after breaking from the loop (start) we will return the player all time stats and average wins and losses
         * 
         */

        

        
    }
}
