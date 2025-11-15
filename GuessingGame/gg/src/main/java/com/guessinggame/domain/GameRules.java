package com.guessinggame.domain;

public class GameRules {

    public boolean isOutOfRange(int playerGuess, int startRange, int endRange){
        return playerGuess < startRange || playerGuess > endRange;
    }

    public OutCome getOutcome(int secret, int playerGuess){
        return (playerGuess == secret) ? OutCome.WIN : OutCome.LOSS;
    }

    // public void scoreCounter(OutCome result){
    //     if (result == OutCome.WIN){
    //         this.winIncrement();
    //     } else {
    //         this.lossIncrement();
    //     }
    // }

    // private void winIncrement(){
    //     this.playerWinCount++;
    // }

    // private void lossIncrement(){
    //     this.playerLossCount++;
    // }
    


    // public int getPlayerWinCount(){
    //     return this.playerWinCount;
    // }

    // public int getPlayerLossCount(){
    //     return this.playerLossCount;
    // }

    
}
