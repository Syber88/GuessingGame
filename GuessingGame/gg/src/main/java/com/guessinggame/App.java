package com.guessinggame;

import java.util.Scanner;
import com.guessinggame.domain.Game;
import com.guessinggame.domain.Player;
import com.guessinggame.persistence.PlayerScoreHistory;
import com.guessinggame.ui.*;
import java.util.Map;

public class App 
{
    public static void main( String[] args ){
        Scanner scanner = new Scanner(System.in);
        ConsoleUI ui = new ConsoleUI(scanner);
        PlayerScoreHistory history = new PlayerScoreHistory();

        String name = ui.askForName();
        String fileName = history.getFileName();

        if (history.playerExists(name, fileName)){
            Map<String, Map<String, Integer>> data = history.readPlayerHistoryFile(fileName);
            
        }
        


            Player player = new Player(name);
        
        Player player = new Player(name);
        Game game = new Game(scanner, player);
        game.start();
        /**
         * after breaking from the loop (start) we will return the player all time stats and average wins and losses
         * 
         */

        

        
    }
}
