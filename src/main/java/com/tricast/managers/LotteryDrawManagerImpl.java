package com.tricast.managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tricast.controllers.requests.LotteryDrawEditRequest;
import com.tricast.controllers.responses.LotteryDrawResponse;
import com.tricast.repositories.LotteryDrawRepository;
import com.tricast.repositories.LotteryTicketsRepository;
import com.tricast.repositories.PrizeLevelRepository;
import com.tricast.repositories.entities.LotteryDraw;
import com.tricast.repositories.entities.LotteryTicket;
import com.tricast.repositories.entities.PrizeLevel;


@Service
public class LotteryDrawManagerImpl implements LotteryDrawManager {

    private LotteryDrawRepository lotteryDrawRepository;
    private LotteryTicketsRepository lotteryTicketsRepository;
    //private SingleSelectionsRepository singleSelectionsRepository;
    private PrizeLevelRepository prizeLevelRepository;

    @Inject
    public LotteryDrawManagerImpl(LotteryDrawRepository LotteryDrawsRepository,
            LotteryTicketsRepository lotteryTicketsRepository, /*SingleSelectionsRepository singleSelectionsRepository*/
            PrizeLevelRepository prizeLevelRepository) {
        this.lotteryDrawRepository = LotteryDrawsRepository;
        this.lotteryTicketsRepository = lotteryTicketsRepository;
        // this.singleSelectionsRepository = singleSelectionsRepository;
        this.prizeLevelRepository = prizeLevelRepository;
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

    /*private int NumberOfSsByTicket(long LotteryTicketid) {
        int ticketnumber = 0;
        for (SingleSelection selection : singleSelectionsRepository.findAll()) {
            if (selection.getLotteryTicketid() == LotteryTicketid) {
                ticketnumber++;
            }
        }
        return ticketnumber;
    }*/

    private List<PrizeLevel> prizeLevelsForDrawId(long id) {
        List<PrizeLevel> goodPrizeLevels = new ArrayList<>();
        List<PrizeLevel> prizeLevelList = prizeLevelRepository.findAll();
        for (PrizeLevel prizelevel : prizeLevelList) {
            if (prizelevel.getLotterydrawid() == id) {
                goodPrizeLevels.add(prizelevel);
            }
        }
        prizeLevelList.clear();
        return goodPrizeLevels;
    }

    @Override
    public LotteryDrawResponse getDetailsForEditDraw(long id) {
        LotteryDrawResponse result = new LotteryDrawResponse();
        int tickets = 0;

        // kéneee egy ticket lista ahol a draw id == id
        // singleSelectionManagerImpl.NumberOfSsByTicket(ticket id) minden ticketre a listában
        List<LotteryTicket> ticketlist = lotteryTicketsRepository.findAll();

        /*for (LotteryTicket ticket : ticketlist) {
            if (ticket.getLotteryDrawid() == id) {
                tickets += NumberOfSsByTicket(ticket.getId());
            }

        }*/
        // ticketek stakejét szummolni
        for (LotteryTicket ticket : ticketlist) {
            if (ticket.getLotteryDrawid() == id) {
                tickets += ticket.getStake();
            }
        }

        // result.setWinningAmount(this.findById(id).getBaseStake() * tickets); // régi
        result.setWinningAmount(tickets);

        // nyerő számok beállítása
        List<Integer> workList = new ArrayList<>();
        LotteryDraw lotteryDraw = findById(id);
        String numbers = lotteryDraw.getWinningNumbers();
        StringTokenizer st = new StringTokenizer(numbers, ",");
        while (st.hasMoreTokens()) {
            workList.add(Integer.parseInt(st.nextToken()));
        }
        result.setWinningNumbers(workList);
        ticketlist.clear();
        workList.clear();

        // percentage beállítása
        List<PrizeLevel> goodPrizeLevels = prizeLevelsForDrawId(id);
        Collections.sort(goodPrizeLevels);
        for (PrizeLevel prizelevel : goodPrizeLevels) {
            workList.add(prizelevel.getWinningpercentage());
        }
        result.setWinningPercentages(workList);
        workList.clear();
        goodPrizeLevels.clear();
        return result;
    }

    @Override
    public LotteryDrawResponse update(LotteryDrawEditRequest lotteryGame) {

        LotteryDraw lotteryDraw = lotteryDrawRepository.findById((long) lotteryGame.getLotteryDrawId());
        lotteryDraw.setWinningNumbers(lotteryGame.getWinningNumbers());
        // percentage set
        List<PrizeLevel> goodPrizeLevels = prizeLevelsForDrawId(lotteryGame.getLotteryDrawId());// adott drawid-s pl-ek
        Collections.sort(goodPrizeLevels);
        // nyeremény százalékok integer listába tétele
        List<Integer> workList = new ArrayList<>();
        String numbers = lotteryGame.getWinningPercentage();
        StringTokenizer st = new StringTokenizer(numbers, ",");
        while (st.hasMoreTokens()) {
            workList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(workList);// emelkedő sor
        // PL entity-knek érték adás
        for (int i = 0; i < goodPrizeLevels.size() - 1; i++) {
            // goodPrizeLevels.get(i).setLevel(i /*hogy vannak a szintek?*/);
            goodPrizeLevels.get(i).setWinningpercentage(workList.get(i));
        }
        LotteryDrawResponse result = new LotteryDrawResponse();
        // result készítés
        return null;
    }

    @Override
    public LotteryDraw settle(long lotteryDrawId) {
        // TODO Auto-generated method stub
        return null;
    }

}

