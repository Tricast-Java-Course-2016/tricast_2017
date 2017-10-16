package com.tricast.managers.beans;

import java.util.List;

import com.tricast.repositories.entities.LotteryTickets;

public interface LotteryTicketManager {

    List<LotteryTickets> findAll();

    LotteryTickets findById(Long id);

    LotteryTickets create(LotteryTickets lotteryTicket);

    LotteryTickets update(LotteryTickets lotteryTicket);

    void deleteById(Long id);

}