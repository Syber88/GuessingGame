package com.guessinggame;

import java.util.Scanner;
import com.guessinggame.domain.Game;
import com.guessinggame.domain.Player;
import com.guessinggame.ui.*;

public class App 
{
    public static void main( String[] args ){
        Scanner scanner = new Scanner(System.in);
        ConsoleUI ui = new ConsoleUI(scanner);

        String name = ui.askForName();

        try {


            Player player = new Player(name);
        } catch(Exception e){

        }
        Player player = new Player(name);
        Game game = new Game(scanner, player);
        game.start();
        /**
         * after breaking from the loop (start) we will return the player all time stats and average wins and losses
         * 
         */

        

        
    }
}
