package com.guessinggame.infrastructure;

import java.util.Map;

import com.guessinggame.domain.*;;

public class JsonPlayerStatsRepository implements PlayerStatsRepository{

    @Override
    public Player load(String name) {
        Map<String, Map<String, Integer>> data = readPlayerHistoryFile(fileName);
        Map<String,Integer>playerMap = data.get(name);
        player.setLosses(playerMap.get("losses"));
        player.setWins(playerMap.get("wins"));
        return player;
    }

    @Override
    public void save(Player player) {
        // TODO Auto-generated method stub
        
    }

}
