package com.tricast.managers;

import java.util.List;

import com.tricast.repositories.entities.LotteryDraw;

public interface LotteryDrawManager {

    List<LotteryDraw> findAll();

    LotteryDraw findById(Long id);

    LotteryDraw create(LotteryDraw LotteryDraw);

    LotteryDraw update(LotteryDraw LotteryDraw);

    void deleteById(Long id);

}