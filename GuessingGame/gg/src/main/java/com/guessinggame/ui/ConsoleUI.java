package com.guessinggame.ui;

import java.util.Scanner;


public class ConsoleUI {
    private Scanner scanner;

    public ConsoleUI(Scanner scanner){
        this.scanner = scanner;
    } 

    public void showMessage(String message){
        System.out.println(message);
    }


}
