package com.guessinggame.domain;

public interface Scores {
    
    int getLosses();
    int getWins();
    void recordWin();
    void recordLoss();

}
