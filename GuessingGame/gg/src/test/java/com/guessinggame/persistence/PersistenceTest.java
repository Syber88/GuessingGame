package com.guessinggame.persistence;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import com.guessinggame.domain.*;

import org.junit.jupiter.api.BeforeEach;


public class PersistenceTest {
    private Player player;
    private PlayerScoreHistory history;

    @BeforeEach
    void setUp(){
        this.player = new Player("Jimmy Neutron");
        this.history = new PlayerScoreHistory(player);

    }

    @Test
    void playerExistingSucceedsTest(){
        boolean exists = history.playerExists(player);
        assertTrue(exists);
    }

    @Test 
    void readPlayerHistoryFileTestWins() throws Exception {
        Map<String, Map<String, Integer>> data = history.readPlayerHistoryFile("src/test/resources/ScoreHistoryTest.json");
        int wins = data.get("john").get("wins");
        assertEquals(5, wins);
        
    }

    @Test 
    void readPlayerHistoryFileTestLosses() throws Exception {
        Map<String, Map<String, Integer>> data = history.readPlayerHistoryFile("src/test/resources/ScoreHistoryTest.json");
        int losses = data.get("max").get("losses");
        assertEquals(1, losses);
        
    }
    
}
