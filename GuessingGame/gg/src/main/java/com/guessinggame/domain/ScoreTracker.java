package com.guessinggame.domain;

public class ScoreTracker implements  Scores {

    private int losses; 
    private int wins;

    public ScoreTracker(){
        this.losses = 0;
        this.wins = 0;
    }

    @Override
    public int getPlayerLossCount() {
        return this.losses;
    }

    @Override
    public int getPlayerWinCount() {
        return this.wins;
    }

    @Override
    public void recordLoss() {
        this.losses++;
    }

    @Override
    public void recordWin() {
        this.wins++;
    }
    

}
