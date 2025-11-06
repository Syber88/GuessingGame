package com.guessinggame.persistence;

import com.guessinggame.domain.*;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;


public class PlayerScoreHistory {
    // private Player player;
    private final String fileName;

    public PlayerScoreHistory(){
        this.fileName = "PlayerScoreHistory.json";
    }

    public String getFileName(){
        return this.fileName;
    }

    public void createFile(){
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

    public boolean playerExists(String name, String fileName) throws IOException{
        Map<String, Map<String, Integer>> data = readPlayerHistoryFile(fileName);
        if (data.containsKey(name)){
            return true;
        }
        return false;
    }
    

    public Map<String, Map<String, Integer>> readPlayerHistoryFile(String fileName) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Map<String, Integer>> data = mapper.readValue(new File(fileName), 
        new com.fasterxml.jackson.core.type.TypeReference<Map<String, Map<String, Integer>>>() {});
        return data;
    }

    public void saveStats(Player player, String fileName)throws Exception{
        /**
         * we will be getting the in-game loss and win from the game variable. think about that
         */
        Map<String, Map<String, Integer>> data = readPlayerHistoryFile(fileName);
        Map<String, Integer> playerMap = data.get(player.getName());

        int wins = playerMap.get("wins"), losses = playerMap.get("losses"); 
        wins += player.getWins(); 
        losses += player.getLosses();

        playerMap.put("wins", wins);
        playerMap.put("losses", losses);

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), mapper);
    }

    public Player loadPlayerStats(Player player, String fileName)throws Exception{
        Map<String, Map<String, Integer>> data = readPlayerHistoryFile(fileName);
        Map<String,Integer>playerMap = data.get(player.getName());
        player.setLosses(playerMap.get("losses"));
        player.setWins(playerMap.get("wins"));
        return player;
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
