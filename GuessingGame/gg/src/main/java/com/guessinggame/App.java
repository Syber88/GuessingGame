package com.guessinggame;

import java.util.Scanner;
import com.guessinggame.domain.Game;

public class App 
{
    public static void main( String[] args ){
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);
        game.start();
    }
}
