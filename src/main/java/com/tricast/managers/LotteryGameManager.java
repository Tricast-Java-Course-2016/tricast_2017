package com.tricast.managers;

import java.util.List;

import com.tricast.repositories.entities.LotteryGame;

public interface LotteryGameManager {

    List<LotteryGame> findAll();

    LotteryGame findById(Long id);

    LotteryGame create(LotteryGame LotteryGame);

    LotteryGame update(LotteryGame LotteryGame);

    void deleteById(Long id);

}