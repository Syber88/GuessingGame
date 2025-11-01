package com.guessinggame.domain;

public enum OutCome {

    LOSS("Bad luck, you lost"),
    WIN("Congrats, you got it");

    private final String message;

    OutCome(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
