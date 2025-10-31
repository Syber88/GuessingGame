package com.guessinggame.domain;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;

public class GameTest {
    Game game;


    @BeforeEach
    void setUp(){
        Scanner scanner = new Scanner(new ByteArrayInputStream(new byte[0]));
        this.game = new Game(scanner);
    }

    @Test
    void gameGetSecret() {
        int secret = game.generateSecret(1, 5);
        assertTrue(secret >= 0 && secret <= 5);
    }

    @Test
    void gameGetOutcomeLoss(){
        OutCome result = game.getOutcome(15, 18);
        assertEquals(result, OutCome.LOSS);
    }

    @Test
    void gameGetOutcomeWin(){
        OutCome result = game.getOutcome(18, 18);
        assertEquals(result, OutCome.WIN);
    }
    
}
