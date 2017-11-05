package com.tricast.managers;

import java.util.List;

import com.tricast.controllers.responses.BetBasicResponse;
import com.tricast.repositories.entities.LotteryTicket;

public interface LotteryTicketManager {

    List<LotteryTicket> findAll();

    LotteryTicket findById(Long id);

    LotteryTicket create(LotteryTicket lotteryTicket);

    LotteryTicket update(LotteryTicket lotteryTicket);

    void deleteById(Long id);

    BetBasicResponse getBetBasicResponse(long lotteryGameId);

}