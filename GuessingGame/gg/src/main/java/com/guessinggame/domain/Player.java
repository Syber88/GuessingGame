package com.guessinggame.domain;

public class Player {
    private String name;
    private int wins;
    private int losses;

    public Player(String name){
        this.name = name;
    }

    public String toString(){
        return "Wins: " + this.wins + "\n" + "Losses: " + this.losses;
    }

    public String getName(){
        return this.name;
    }
    
    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
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
        if (this.name == objPlayer.name){
            return true;
        }
        return false;
    }

    
    
}
