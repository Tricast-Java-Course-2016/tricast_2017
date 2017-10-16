package com.tricast.managers.beans;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tricast.repositories.LotteryTicketsRepository;
import com.tricast.repositories.entities.LotteryTickets;

@Service
public class LotteryTicketManagerImpl implements LotteryTicketManager {

    private LotteryTicketsRepository lotteryTicketsRepository;

    @Inject
    public LotteryTicketManagerImpl(LotteryTicketsRepository lotteryTicketsRepository) {
        this.lotteryTicketsRepository = lotteryTicketsRepository;
    }

    @Override
    public List<LotteryTickets> findAll() {
        return lotteryTicketsRepository.findAll();
    }

    @Override
    public LotteryTickets findById(Long id) {
        return lotteryTicketsRepository.findById(id);
    }

    @Override
    public LotteryTickets create(LotteryTickets lotteryTickets) {
        return lotteryTicketsRepository.save(lotteryTickets);
    }

    @Override
    public LotteryTickets update(LotteryTickets lotteryTickets) {
        return lotteryTicketsRepository.save(lotteryTickets);
    }

    @Override
    public void deleteById(Long id) {
    	lotteryTicketsRepository.delete(id);
    }

}

