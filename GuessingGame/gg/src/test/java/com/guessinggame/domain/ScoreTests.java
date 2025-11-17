// package com.guessinggame.domain;

// import org.junit.jupiter.api.*;
// import static org.junit.jupiter.api.Assertions.*;


// public class ScoreTests {
//     Scores score = new ScoreTracker();

//     @Test
//     void playerHasLostATurnTest(){
//         score.recordLoss();
//         assertEquals(1, score.getPlayerLossCount());
//         assertEquals(0, score.getPlayerWinCount());
        
//     }

//     @Test
//     void playerHasLostATurnTwiceTest(){
//         score.recordLoss();
//         assertEquals(1, score.getPlayerLossCount());
//         assertEquals(0, score.getPlayerWinCount());
//         score.recordLoss();
//         assertEquals(2, score.getPlayerLossCount());
//         assertEquals(0, score.getPlayerWinCount());
        
//     }

//     @Test
//     void playerHasLostTwiceAndWonOnceTest(){
//         score.recordLoss();
//         assertEquals(1, score.getPlayerLossCount());
//         assertEquals(0, score.getPlayerWinCount());
//         score.recordLoss();
//         assertEquals(2, score.getPlayerLossCount());
//         assertEquals(0, score.getPlayerWinCount());
//         score.recordWin();
//         assertEquals(2, score.getPlayerLossCount());
//         assertEquals(1, score.getPlayerWinCount());
//     }

//     @Test
//     void playerHasWonATurnTest(){
//         score.recordWin();
//         assertEquals(0, score.getPlayerLossCount());
//         assertEquals(1, score.getPlayerWinCount());
        
//     }

//     @Test
//     void playerHasWonATurnTwiceTest(){
//         score.recordWin();
//         assertEquals(0, score.getPlayerLossCount());
//         assertEquals(1, score.getPlayerWinCount());
//         score.recordWin();
//         assertEquals(0, score.getPlayerLossCount());
//         assertEquals(2, score.getPlayerWinCount());
        
//     }

//     @Test
//     void playerHasWonTwiceAndLostOnceTest(){
//         score.recordLoss();
//         assertEquals(1, score.getPlayerLossCount());
//         assertEquals(0, score.getPlayerWinCount());
//         score.recordLoss();
//         assertEquals(2, score.getPlayerLossCount());
//         assertEquals(0, score.getPlayerWinCount());
//         score.recordWin();
//         assertEquals(2, score.getPlayerLossCount());
//         assertEquals(1, score.getPlayerWinCount());
//     }



// }
