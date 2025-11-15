package com.guessinggame.domain;

public class GameRules {

    public GameRules(){

    }

    public boolean isOutOfRange(int playerGuess, int startRange, int endRange){
        return playerGuess < startRange || playerGuess > endRange;
        }

    
}
