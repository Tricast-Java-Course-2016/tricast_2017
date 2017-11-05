package com.tricast.managers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tricast.controllers.responses.BetBasicResponse;
import com.tricast.repositories.LotteryDrawRepository;
import com.tricast.repositories.LotteryGameRepository;
import com.tricast.repositories.LotteryTicketsRepository;
import com.tricast.repositories.entities.LotteryDraw;
import com.tricast.repositories.entities.LotteryGame;
import com.tricast.repositories.entities.LotteryTicket;

@Service
public class LotteryTicketManagerImpl implements LotteryTicketManager {

    private LotteryTicketsRepository lotteryTicketsRepository;
    private LotteryGameRepository lotteryGameRepository;
    private LotteryDrawRepository lotteryDrawRepository;

    @Inject
    public LotteryTicketManagerImpl(LotteryTicketsRepository lotteryTicketsRepository,
            LotteryGameRepository lotteryGameRepository, LotteryDrawRepository lotteryDrawRepository) {
        this.lotteryTicketsRepository = lotteryTicketsRepository;
        this.lotteryGameRepository = lotteryGameRepository;
        this.lotteryDrawRepository = lotteryDrawRepository;
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

    @Override
    public BetBasicResponse getBetBasicResponse(long lotteryGameId) {
        BetBasicResponse betBasicResponse = new BetBasicResponse();

        LotteryGame lotteryGame = new LotteryGame();
        lotteryGame = lotteryGameRepository.findById(lotteryGameId);
        LotteryDraw lotteryDraw = new LotteryDraw();
        lotteryDraw = lotteryDrawRepository.findById(lotteryGameId);

        betBasicResponse.setLotteryGameId(lotteryGameId);
        betBasicResponse.setLotteryDrawId(lotteryDraw.getId());
        betBasicResponse.setDescription(lotteryGame.getDescription());
        betBasicResponse.setBaseStake(lotteryGame.getBaseStake());
        betBasicResponse.setGridSize(lotteryGame.getGridSize());
        betBasicResponse.setNumbersDrawn(lotteryGame.getNumbersDrawn());
        betBasicResponse.setNrOfGrids(lotteryGame.getNrOfGrids());
        betBasicResponse.setMinNrOfFox(lotteryGame.getMinNrOfFox());
        betBasicResponse.setMaxNrOfFix(lotteryGame.getMaxNrOfFix());
        betBasicResponse.setMaxNrOfCombination(lotteryGame.getMaxNrOfCombination());
        betBasicResponse.setYear(lotteryDraw.getYear());
        betBasicResponse.setWeek(lotteryDraw.getWeek());

        return betBasicResponse;
    }

}

