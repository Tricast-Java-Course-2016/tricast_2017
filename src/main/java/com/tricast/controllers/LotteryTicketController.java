package com.tricast.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tricast.managers.beans.LotteryTicketManager;
import com.tricast.repositories.entities.LotteryTickets;

@RestController
@RequestMapping(path = "lotteryticket")
public class LotteryTicketController {

    private LotteryTicketManager lotteryTicketManager;

    @Inject
    public LotteryTicketController(LotteryTicketManager lotteryTicketManager) {
        this.lotteryTicketManager = lotteryTicketManager;
    }

    @GetMapping
    public List<LotteryTickets> findAll() {
        return lotteryTicketManager.findAll();
    }

    @PostMapping
    public LotteryTickets create(@RequestBody LotteryTickets lotteryTicket) {
        return lotteryTicketManager.create(lotteryTicket);
    }

}

