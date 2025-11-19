package com.guessinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// import com.guessinggame.domain.GameRules;


public class GameRulesTest {
    GameRules rules;

    @BeforeEach
    void setUp(){
        this.rules = new GameRules();
    }

    @Test
    void withinRangeTest(){
        int start = 1;
        int end = 10;
        int playerGuess = 5;
        assertFalse(rules.isOutOfRange(playerGuess, start, end));
    }

    @Test
    void notWithinRangeTest(){
        int start = 1;
        int end = 10;
        int playerGuess = 12;
        assertTrue(rules.isOutOfRange(playerGuess, start, end));
    }

    @Test
    void lossOutcomeLossTest(){
        int playerGuess = 5;
        int secret = 8;
        assertEquals(OutCome.LOSS, rules.getOutcome(secret, playerGuess));
    }

    @Test
    void lossOutcomeWinTest(){
        int playerGuess = 9;
        int secret = 9;
        assertEquals(OutCome.WIN, rules.getOutcome(secret, playerGuess));
    }
}
