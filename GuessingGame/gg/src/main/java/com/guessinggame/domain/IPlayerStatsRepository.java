package com.guessinggame.domain;

public interface IPlayerStatsRepository {

    Player load (String name);
    void save(Player player);

}
