package com.guessinggame.ui;

import com.guessinggame.domain.UserOutput;

public class ConsoleUO implements UserOutput{
    


     @Override
    public void showOutput(String message) {
        System.out.println(message);
    }

    public void loadingLoop(){
        try {
            Thread.sleep(1000);
            for (int i = 0; i < 5; i++){
                System.out.print(".");
            }

        } catch (InterruptedException e){
            System.out.println("Error :" + e.getMessage());
        }
        
    }
}
