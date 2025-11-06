package com.guessinggame.persistence;

import com.guessinggame.domain.*;
import java.io.File;
import java.io.IOException;

public class PlayerScoreHistory {
    private Player player;
    private String fileName = "PlayerScoreHistory.json";

    public PlayerScoreHistory(Player player){
        this.player = player;
        File file = new File(fileName);

        try {
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e){
            System.out.println("an error occured");
            e.getStackTrace();
        }
    }

    public boolean doesPlayerExists(Player player){
        return true;                      
    }

    /**
     * I want the player to enter their name first, if the name exists on file we tell them it already
     * exists and if they wanna add on to tht name's history
     * if not we continue and write to the file with the new player's name 
     * 
     * Json file so we will be saving in dictionaries
     * I will use jackson to read and wrise json files
     */


}
