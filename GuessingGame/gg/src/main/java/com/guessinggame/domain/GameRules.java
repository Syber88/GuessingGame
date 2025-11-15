package com.guessinggame.domain;

public class GameRules {

    public boolean isOutOfRange(int playerGuess, int startRange, int endRange){
        return playerGuess < startRange || playerGuess > endRange;
    }

    public OutCome getOutcome(int secret, int playerGuess){
        return (playerGuess == secret) ? OutCome.WIN : OutCome.LOSS;
    }
}
