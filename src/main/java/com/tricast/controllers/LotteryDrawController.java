package com.tricast.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tricast.managers.LotteryDrawManager;
import com.tricast.repositories.entities.LotteryDraw;

@RestController
@RequestMapping(path = "lotterydraw")
public class LotteryDrawController {

    private LotteryDrawManager lotteryDrawManager;

    @Inject
    public LotteryDrawController(LotteryDrawManager lotteryTicketManager) {
        this.lotteryDrawManager = lotteryTicketManager;
    }

    @GetMapping
    public List<LotteryDraw> findAll() {
        return lotteryDrawManager.findAll();
    }

    @PostMapping
    public LotteryDraw create(@RequestBody LotteryDraw lotteryTicket) {
        return lotteryDrawManager.create(lotteryTicket);
    }

}

