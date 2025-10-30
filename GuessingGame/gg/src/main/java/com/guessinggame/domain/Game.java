package guessinggame.domain;

import java.util.Scanner;

public class Game {
    private int playerWinCount;
    private int computerWinCount;

    public Game(){
        this.playerWinCount = 0;
        this.computerWinCount = 0;
    }

    public void start(Scanner scanner){
        while(true){
            try {
                System.out.println("Enter the start range");    
                int start = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the end range");   
                int end = Integer.parseInt(scanner.nextLine());

            } catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }

            

        }
    }


}