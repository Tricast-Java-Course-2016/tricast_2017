package com.tricast.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tricast.controllers.responses.BetBasicResponse;
import com.tricast.managers.LotteryDrawManager;
import com.tricast.managers.LotteryGameManager;
import com.tricast.managers.LotteryTicketManager;
import com.tricast.repositories.entities.LotteryTicket;

@RestController
@RequestMapping(path = "lotteryticket")
public class LotteryTicketController {

    private LotteryTicketManager lotteryTicketManager;
    private LotteryGameManager lotteryGameManager;

    @Autowired
    private LotteryDrawManager lotteryDrawManager;

    @Inject
    public LotteryTicketController(LotteryTicketManager lotteryTicketManager, LotteryGameManager lotteryGameManager) {
        this.lotteryTicketManager = lotteryTicketManager;
        this.lotteryGameManager = lotteryGameManager;
    }

    @GetMapping
    public List<LotteryTicket> findAll() {
        return lotteryTicketManager.findAll();
    }

    @PostMapping
    public LotteryTicket create(@RequestBody LotteryTicket lotteryTicket) {
        return lotteryTicketManager.create(lotteryTicket);
    }

    @GetMapping("/{id}")
    public LotteryTicket findById(@PathVariable("id") long id) {
        return lotteryTicketManager.findById(id);
    }

    @PutMapping
    public LotteryTicket update(@RequestBody LotteryTicket lotteryGame) {
        return lotteryTicketManager.update(lotteryGame);
    }

    @DeleteMapping
    public void delete(@PathVariable long id) {
        lotteryTicketManager.deleteById(id);
    }


    @GetMapping("/{lotteryGameId}")
    public BetBasicResponse getBetBasicResponse(@PathVariable("lotteryGameId") long lotteryGameId) {
        return lotteryTicketManager.getBetBasicResponse(lotteryGameId);
    }

    // @PostMapping("/placebet")
    // public LotteryTicketDetailsResponse placeBet(@RequestBody BetRequest betRequest) {
    // return lotteryTicketManager.placeBet(betRequest);
    // }

}

