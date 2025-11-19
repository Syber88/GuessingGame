package com.guessinggame.domain;

public class ScoreTracker implements  Scores {

    private int losses; 
    private int wins;

    public ScoreTracker(){
        this.losses = 0;
        this.wins = 0;
    }

    @Override
    public int getLosses() {
        return this.losses;
    }

    @Override
    public int getWins() {
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

    void setScore(int wins, int losses){
        this.losses = losses;
        this.wins = wins;
    }
    

}
