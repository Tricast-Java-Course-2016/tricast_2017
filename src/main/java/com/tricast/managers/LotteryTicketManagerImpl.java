package com.tricast.managers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tricast.repositories.LotteryTicketsRepository;
import com.tricast.repositories.entities.LotteryTicket;

@Service
public class LotteryTicketManagerImpl implements LotteryTicketManager {

    private LotteryTicketsRepository lotteryTicketsRepository;

    @Inject
    public LotteryTicketManagerImpl(LotteryTicketsRepository lotteryTicketsRepository) {
        this.lotteryTicketsRepository = lotteryTicketsRepository;
    }

    @Override
    public List<LotteryTicket> findAll() {
        return lotteryTicketsRepository.findAll();
    }

    @Override
    public LotteryTicket findById(Long id) {
        return lotteryTicketsRepository.findById(id);
    }

    @Override
    public LotteryTicket create(LotteryTicket lotteryTickets) {
        return lotteryTicketsRepository.save(lotteryTickets);
    }

    @Override
    public LotteryTicket update(LotteryTicket lotteryTickets) {
        return lotteryTicketsRepository.save(lotteryTickets);
    }

    @Override
    public void deleteById(Long id) {
    	lotteryTicketsRepository.delete(id);
    }

}

