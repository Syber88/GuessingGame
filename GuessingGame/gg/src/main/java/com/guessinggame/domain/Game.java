package guessinggame.domain;

import java.util.Scanner;
import com.guessinggame.ui.ConsoleUI;

public class Game {
    private int playerWinCount;
    private int computerWinCount;
    private ConsoleUI userInterface;
    private Scanner scanner;

    public Game(Scanner scanner){
        this.playerWinCount = 0;
        this.computerWinCount = 0;
        this.scanner = scanner;
        this.userInterface = new ConsoleUI(scanner);
    }

    public void start(Scanner scanner){
        while(true){
            try {
                showMessage("Enter the start range");    
                int start = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the end range");   
                int end = Integer.parseInt(scanner.nextLine());

            } catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }



        }
    }


}