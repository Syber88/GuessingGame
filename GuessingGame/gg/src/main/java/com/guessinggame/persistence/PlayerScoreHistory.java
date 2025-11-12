package com.guessinggame.persistence;

import com.guessinggame.domain.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.HashMap;
import com.guessinggame.ui.ConsoleUI;;


public class PlayerScoreHistory {
    // private Player player;
    private final String fileName;

    public PlayerScoreHistory(){
        this.fileName = "PlayerScoreHistory.json";
        try{
            createFile(fileName);

        } catch(IOException e) {

        }
    }

    public String getFileName(){
        return this.fileName;
    }

    public void createFile(String fileName)throws IOException{
        File file = new File(fileName);
        try {
            if (file.createNewFile()){
                try(FileWriter writer = new FileWriter(file)){
                    writer.write("{}");
                }
            }
        } catch (IOException e){
            e.printStackTrace();
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
        File file = new File(fileName);
        if (file.length() == 0){
            return new HashMap<>();
        }
        
        Map<String, Map<String, Integer>> data = mapper.readValue(file, 
        new com.fasterxml.jackson.core.type.TypeReference<Map<String, Map<String, Integer>>>() {});
        return data;
    }

    public void saveStats(Player player, String fileName, Game game)throws Exception{
        /**
         * we will be getting the in-game loss and win from the game variable. think about that
         */
        Map<String, Map<String, Integer>> data = readPlayerHistoryFile(fileName);
        Map<String, Integer> playerMap = data.computeIfAbsent(player.getName(), k -> {
            Map<String, Integer> pm = new HashMap<>();
            pm.put("wins",0);
            pm.put("losses", 0);
            return pm;
        });

        int wins = playerMap.getOrDefault("wins",0), losses = playerMap.getOrDefault("losses",0); 
        wins += game.getPlayerWinCount(); 
        losses += game.getPlayerLossCount();

        playerMap.put("wins", wins);
        playerMap.put("losses", losses);

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), data);
    }

    public Player loadPlayerStats(Player player, String fileName)throws Exception{
        Map<String, Map<String, Integer>> data = readPlayerHistoryFile(fileName);
        Map<String,Integer>playerMap = data.get(player.getName());
        player.setLosses(playerMap.get("losses"));
        player.setWins(playerMap.get("wins"));
        return player;
    }

    public void showAllTimePlayerStats(Player player, ConsoleUI ui){
        ui.showMessage("All-Time stats: ");
        ui.showMessage(player.toString());
    }



    /**
     * I want the player to enter their name first, if the name exists on file we tell them it already
     * exists and add on to tht name's history
     * if not we continue and write to the file with the new player's name 
     * 
     * Json file so we will be saving in dictionaries
     * I will use jackson to read and wrise json files
     */


}
