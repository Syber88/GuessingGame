package com.guessinggame.domain;

public class Player {
    private String name;
    private ScoreTracker score;
    private int lifetimeWins;
    private int lifetimeLosses;

    public Player(String name, ScoreTracker score){
        this.name = name;
        this.score = score;
        
    }

    public String toString(){
        return "Wins: " + this.getLifetimeWins() + "\n" + "Losses: " + this.getLifetimeLosses();
    }

    public String getName(){
        return this.name;
    }

    public void recordWin(){
        this.score.recordWin();
    }

    public void recordLoss(){
        this.score.recordLoss();
    }

    public int getSessionWins(){
        return this.score.getWins();
    } 

    public int getSessionLosses(){
        return this.score.getLosses();
    }
    
    public int getLifetimeWins() {
        return this.lifetimeWins;
    }

    public int getLifetimeLosses() {
        return this.lifetimeLosses;
    }

    public void restoreScores(int lifetimeWins, int lifetimeLosses){
        this.lifetimeWins = lifetimeWins;
        this.lifetimeLosses = lifetimeLosses;
    }

    public void resetGameScores(){
        this.score.setScore(0, 0);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Player)){
            return false;
        }

        Player objPlayer = (Player) obj;
        if (this.name.equals(objPlayer.name)){
            return true;
        }
        return false;
    }

    
    
}
