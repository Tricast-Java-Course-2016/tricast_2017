package com.tricast.managers;

import java.sql.SQLException;
import java.util.List;

import com.tricast.controllers.requests.LotteryGameRequest;
import com.tricast.repositories.entities.LotteryGame;

public interface LotteryGameManager {

    List<LotteryGame> findAll();

    LotteryGame findById(Long id);

    LotteryGame create(LotteryGame lotteryGame);

    LotteryGame update(LotteryGameRequest lotteryGame) throws SQLException;

    void deleteById(Long id);

}