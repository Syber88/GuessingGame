package com.guessinggame.domain;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class ScoreTests {
    Scores score = new ScoreTracker();

    @Test
    void playerHasLostATurnTest(){
        score.recordLoss();
        assertEquals(1, score.getLosses());
        assertEquals(0, score.getWins());
        
    }

    @Test
    void playerHasLostATurnTwiceTest(){
        score.recordLoss();
        assertEquals(1, score.getLosses());
        assertEquals(0, score.getWins());
        score.recordLoss();
        assertEquals(2, score.getLosses());
        assertEquals(0, score.getWins());
        
    }

    @Test
    void playerHasLostTwiceAndWonOnceTest(){
        score.recordLoss();
        assertEquals(1, score.getLosses());
        assertEquals(0, score.getWins());
        score.recordLoss();
        assertEquals(2, score.getLosses());
        assertEquals(0, score.getWins());
        score.recordWin();
        assertEquals(2, score.getLosses());
        assertEquals(1, score.getWins());
    }

    @Test
    void playerHasWonATurnTest(){
        score.recordWin();
        assertEquals(0, score.getLosses());
        assertEquals(1, score.getWins());
        
    }

    @Test
    void playerHasWonATurnTwiceTest(){
        score.recordWin();
        assertEquals(0, score.getLosses());
        assertEquals(1, score.getWins());
        score.recordWin();
        assertEquals(0, score.getLosses());
        assertEquals(2, score.getWins());
        
    }

    @Test
    void playerHasWonTwiceAndLostOnceTest(){
        score.recordLoss();
        assertEquals(1, score.getLosses());
        assertEquals(0, score.getWins());
        score.recordLoss();
        assertEquals(2, score.getLosses());
        assertEquals(0, score.getWins());
        score.recordWin();
        assertEquals(2, score.getLosses());
        assertEquals(1, score.getWins());
    }



}
