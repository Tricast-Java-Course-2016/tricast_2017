package com.tricast.managers;

import java.util.List;

import com.tricast.controllers.requests.LotteryDrawEditRequest;
import com.tricast.controllers.responses.LotteryDrawResponse;
import com.tricast.repositories.entities.LotteryDraw;

public interface LotteryDrawManager {

    List<LotteryDraw> findAll();

    LotteryDraw findById(Long id);

    LotteryDraw create(LotteryDraw LotteryDraw);

    LotteryDraw update(LotteryDraw LotteryDraw);

    LotteryDrawResponse getDetailsForEditDraw(long id);

    LotteryDrawResponse update(LotteryDrawEditRequest lotteryGame);

    LotteryDraw settle(long lotteryDrawId);

    void deleteById(Long id);

}