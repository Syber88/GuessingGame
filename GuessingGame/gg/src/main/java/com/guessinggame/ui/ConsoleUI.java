package com.guessinggame.ui;

import com.guessinggame.domain.*;
import java.util.Scanner;


public class ConsoleUI implements UserInput, UserOutput{
    private Scanner scanner;

    public ConsoleUI(Scanner scanner){
        this.scanner = scanner;
    } 

    

    @Override
    public int askForNumber() {
        // TODO Auto-generated method stub
        return 0;
    }



    @Override
    public String askForString() {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public void showOutput() {
        // TODO Auto-generated method stub
        
    }



    // public void showMessage(String message){
    //     System.out.println(message);
    // }

    // public void showMessage(int wins, int losses){
    //     String inGameScores = "Wins: " + wins + "\nLosses: " + losses;
    //     showMessage(inGameScores);
    // }   

    // public int askForNumber(String message){
    //     while (true){
    //         showMessage(message);
    //         try {
    //             int number = Integer.parseInt(this.scanner.nextLine());
    //             return number;
    //         } catch (NumberFormatException e) {
    //             showMessage("Enter a proper number");
    //         }
    //     }
    // }

    // public String askForName(){
    //     showMessage("What is your name? ");
    //     String name = scanner.nextLine();
    //     name = name.toLowerCase();
    //     return name;
    // }

    // public void loadingMessageLoop(int number) throws InterruptedException{
    //     for (int i = 0; i < number ; i++){
    //         Thread.sleep(1000);
    //         System.out.print(".");
    //     }
    // }
}
