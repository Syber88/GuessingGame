package com.guessinggame.domain;

import java.util.Scanner;
import com.guessinggame.ui.ConsoleUI;
import java.util.Random;

public class Game {
    
    private ConsoleUI userInterface;
    private Random random;

    public Game(Scanner scanner){
        this.random = new Random();
        
        this.userInterface = new ConsoleUI(scanner);
    }

    

        


    
}