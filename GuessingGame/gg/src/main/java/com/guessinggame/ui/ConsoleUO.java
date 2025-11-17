package com.guessinggame.ui;

import com.guessinggame.domain.UserOutput;

public class ConsoleUO implements UserOutput{
    


     @Override
    public void showOutput(String message) {
        System.out.println(message);
    }

    public void loadingLoop(){
        try {
            for (int i = 0; i < 5; i++){
                System.out.print(".");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println("Error :" + e.getMessage());
        }
    }
}
