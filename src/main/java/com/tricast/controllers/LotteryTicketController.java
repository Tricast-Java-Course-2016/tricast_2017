package com.tricast.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tricast.managers.LotteryTicketManager;
import com.tricast.repositories.entities.LotteryTicket;

@RestController
@RequestMapping(path = "lotteryticket")
public class LotteryTicketController {

    private LotteryTicketManager lotteryTicketManager;

    @Inject
    public LotteryTicketController(LotteryTicketManager lotteryTicketManager) {
        this.lotteryTicketManager = lotteryTicketManager;
    }

    @GetMapping
    public List<LotteryTicket> findAll() {
        return lotteryTicketManager.findAll();
    }

    @PostMapping
    public LotteryTicket create(@RequestBody LotteryTicket lotteryTicket) {
        return lotteryTicketManager.create(lotteryTicket);
    }

    @GetMapping
    public LotteryTicket findById(@PathVariable long id) {
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

}

