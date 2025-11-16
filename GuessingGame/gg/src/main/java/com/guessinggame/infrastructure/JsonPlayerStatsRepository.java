package com.guessinggame.infrastructure;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guessinggame.domain.*;;

public class JsonPlayerStatsRepository implements PlayerStatsRepository{
    private final String filename;

    public JsonPlayerStatsRepository(){
        this.filename = "GuessingGame/gg/src/PlayerScoreHistory.json";
    }

    @Override
    public Player load(String name) {
        try {
            Map<String, Map<String, Integer>> data = readFile(filename);
            Map<String,Integer>playerMap = data.get(name);
            Player player = new Player(name, new ScoreTracker());
            int losses = playerMap.getOrDefault("losses",0);
            int wins = playerMap.get("wins");
            player.restoreScores(wins, losses);
            return player;

        } catch (IOException e){
            System.out.println("Error opening file: " + e.getMessage());
            return new Player(name, new ScoreTracker());
        }
    }

    @Override
    public void save(Player player) {
        try {
            Map<String, Map<String, Integer>> data = readFile(filename);
            Map<String, Integer> playerMap = data.computeIfAbsent(player.getName(), k -> {
                Map<String, Integer> pm = new HashMap<>();
                pm.put("wins",0);
                pm.put("losses", 0);
                return pm;
            });
    
            int wins = playerMap.getOrDefault("wins",0), losses = playerMap.getOrDefault("losses",0); 
            wins += player.getWins();
            losses += player.getLosses();
    
            playerMap.put("wins", wins);
            playerMap.put("losses", losses);
    
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), data);

        } catch (IOException e){
            System.out.println("Error opening file: " + e.getMessage());
        }
        
    }

    public Map<String, Map<String, Integer>> readFile(String fileName) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileName);
        if (file.length() == 0){
            return new HashMap<>();
        }
        
        Map<String, Map<String, Integer>> data = mapper.readValue(file, 
        new com.fasterxml.jackson.core.type.TypeReference<Map<String, Map<String, Integer>>>() {});
        return data;
    }

    public boolean playerExists(String name, String fileName) throws IOException{
        Map<String, Map<String, Integer>> data = readFile(fileName);
        if (data.containsKey(name)){
            return true;
        }
        return false;
    }

}
