package com.guessinggame.domain;

public interface Scores {
    
    int getPlayerLossCount();
    int getPlayerWinCount();
    void recordWin();
    void recordLoss();

}
