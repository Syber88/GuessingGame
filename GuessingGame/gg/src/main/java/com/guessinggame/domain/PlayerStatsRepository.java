package com.guessinggame.domain;

public interface PlayerStatsRepository {

    Player load (String name);
    void save(Player player);

}
