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
        this.player = new Player("john");
        this.history = new PlayerScoreHistory();

    }

    @Test
    void playerExistingSucceedsTest()throws Exception {
        boolean exists = history.playerExists(player.getName(), "src/test/resources/ScoreHistoryTest.json");
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

    // @Test
    // void saveStatsTest(){
// 
    // }

    @Test
    void loadPlayerStatsTest()throws Exception {
        Player player = history.loadPlayerStats(this.player, "src/test/resources/ScoreHistoryTest.json");
        assertEquals(5, player.getWins());
        assertEquals(2, player.getLosses());
    }
}
