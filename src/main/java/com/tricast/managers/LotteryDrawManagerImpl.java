package com.tricast.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tricast.controllers.requests.LotteryDrawEditRequest;
import com.tricast.controllers.responses.LotteryDrawResponse;
import com.tricast.repositories.LotteryDrawRepository;
import com.tricast.repositories.LotteryTicketsRepository;
import com.tricast.repositories.SingleSelectionsRepository;
import com.tricast.repositories.entities.LotteryDraw;
import com.tricast.repositories.entities.LotteryTicket;
import com.tricast.repositories.entities.SingleSelection;

@Service
public class LotteryDrawManagerImpl implements LotteryDrawManager {

    private LotteryDrawRepository lotteryDrawRepository;
    private LotteryTicketsRepository lotteryTicketsRepository;
    private SingleSelectionsRepository singleSelectionsRepository;

    @Inject
    public LotteryDrawManagerImpl(LotteryDrawRepository LotteryDrawsRepository,
            LotteryTicketsRepository lotteryTicketsRepository, SingleSelectionsRepository singleSelectionsRepository) {
        this.lotteryDrawRepository = LotteryDrawsRepository;
        this.lotteryTicketsRepository = lotteryTicketsRepository;
        this.singleSelectionsRepository = singleSelectionsRepository;
    }

    @Override
    public List<LotteryDraw> findAll() {
        return lotteryDrawRepository.findAll();
    }

    @Override
    public LotteryDraw findById(Long id) {
        return lotteryDrawRepository.findById(id);
    }

    @Override
    public LotteryDraw create(LotteryDraw LotteryDraws) {
        return lotteryDrawRepository.save(LotteryDraws);
    }

    @Override
    public LotteryDraw update(LotteryDraw LotteryDraws) {
        return lotteryDrawRepository.save(LotteryDraws);
    }

    @Override
    public void deleteById(Long id) {
        lotteryDrawRepository.delete(id);
    }

    private int NumberOfSsByTicket(long LotteryTicketid) {
        int ticketnumber = 0;
        for (SingleSelection selection : singleSelectionsRepository.findAll()) {
            if (selection.getLotteryTicketid() == LotteryTicketid) {
                ticketnumber++;
            }
        }
        return ticketnumber;
    }

    @Override
    public LotteryDrawResponse getDetailsForEditDraw(long id) {
        LotteryDrawResponse result = new LotteryDrawResponse();
        int tickets = 0;

        // kéneee egy ticket lista ahol a draw id == id
        // singleSelectionManagerImpl.NumberOfSsByTicket(ticket id) minden ticketre a listában
        List<LotteryTicket> ticketlist = lotteryTicketsRepository.findAll();

        for (LotteryTicket ticket : ticketlist) {
            if (ticket.getLotteryDrawid() == id) {
                tickets += NumberOfSsByTicket(ticket.getId());
            }

        }
        result.setWinningAmount(this.findById(id).getBaseStake() * tickets); // pullamount nem winning

        List<Integer> winningNumbers = new ArrayList<>();
        LotteryDraw lotteryDraw = findById(id);
        String numbers = lotteryDraw.getWinningNumbers();
        StringTokenizer st = new StringTokenizer(numbers, ",");
        while (st.hasMoreTokens()) {
            winningNumbers.add(Integer.parseInt(st.nextToken()));
        }
        result.setWinningNumbers(winningNumbers);
        winningNumbers.clear();

        // percentage hol?
        return result;
    }

    @Override
    public LotteryDrawResponse update(LotteryDrawEditRequest lotteryGame) {
        // TODO Auto-generated method stub
        if (lotteryDrawRepository.exists((long) lotteryGame.getLotteryDrawId())) {
            LotteryDraw lotteryDraw = lotteryDrawRepository.findById((long) lotteryGame.getLotteryDrawId());

            lotteryDraw.setWinningNumbers(lotteryGame.getWinningNumbers());
            // percentage set ?
        }
        else {
            // create(LotteryDraws);
        }
        return null;
    }

    @Override
    public LotteryDraw settle(long lotteryDrawId) {
        // TODO Auto-generated method stub
        return null;
    }

}

