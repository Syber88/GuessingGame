package com.guessinggame.persistence;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
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
    void playerExistingSucceeds(){
        boolean exists = history.doesPlayerExists(player);
        assertTrue(exists);
    }
    
}
