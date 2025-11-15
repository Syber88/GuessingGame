package com.guessinggame.domain;

public class Player {
    private String name;
    private ScoreTracker score;

    public Player(String name, ScoreTracker score){
        this.name = name;
        this.score = score;
    }

    public String toString(){
        return "Wins: " + this.getWins() + "\n" + "Losses: " + this.getLosses();
    }

    public String getName(){
        return this.name;
    }
    
    public int getWins() {
        return this.score.getWins();
    }

    public int getLosses() {
        return this.score.getLosses();
    }

    public void restoreScores(int wins, int losses){
        this.score.setScore(wins, losses);
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
