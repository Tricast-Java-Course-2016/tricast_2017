package com.tricast.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public LotteryDraw findById(@PathVariable("id") long id) {
        return lotteryDrawManager.findById(id);
    }

    // @PostMapping("/settle")
    // public LotteryDraw settle(@RequestBody long lotteryDrawId) {
    // return lotteryDrawManager.settle(lotteryDrawId);
    // }
    //
    // @GetMapping("/detailsForEditDraw/{id}")
    // public LotteryDrawResponse getDetailsForEditDraw(@PathVariable("id") long id) {
    // return lotteryDrawManager.getDetailsForEditDraw(id);
    // }
    //
    // @PutMapping
    // public LotteryDrawResponse update(@RequestBody LotteryDrawEditRequest lotteryGame) {
    // return lotteryDrawManager.update(lotteryGame);
    // }

    @DeleteMapping
    public void delete(@PathVariable long id) {
        lotteryDrawManager.deleteById(id);
    }

}

