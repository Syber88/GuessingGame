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
        Player player = new Player(name);
        Game game = new Game(scanner, player);
        game.start();

        

        
    }
}
