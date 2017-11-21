package com.tricast.managers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tricast.controllers.requests.LotteryDrawEditRequest;
import com.tricast.controllers.responses.LotteryDrawResponse;
import com.tricast.repositories.LotteryDrawRepository;
import com.tricast.repositories.LotteryTicketsRepository;
import com.tricast.repositories.PrizeLevelRepository;
import com.tricast.repositories.SingleSelectionsRepository;
import com.tricast.repositories.TransactionRepository;
import com.tricast.repositories.entities.LotteryDraw;
import com.tricast.repositories.entities.LotteryTicket;
import com.tricast.repositories.entities.PrizeLevel;
import com.tricast.repositories.entities.SingleSelection;
import com.tricast.repositories.entities.Transaction;

@Service
public class LotteryDrawManagerImpl implements LotteryDrawManager {

    private LotteryDrawRepository lotteryDrawRepository;
    private LotteryTicketsRepository lotteryTicketsRepository;
    private SingleSelectionsRepository singleSelectionsRepository;
    private PrizeLevelRepository prizeLevelRepository;
    private TransactionRepository transactionRepository;

    @Inject
    public LotteryDrawManagerImpl(LotteryDrawRepository LotteryDrawsRepository,
            LotteryTicketsRepository lotteryTicketsRepository, SingleSelectionsRepository singleSelectionsRepository,
            PrizeLevelRepository prizeLevelRepository, TransactionRepository transactionRepository) {
        this.lotteryDrawRepository = LotteryDrawsRepository;
        this.lotteryTicketsRepository = lotteryTicketsRepository;
        this.singleSelectionsRepository = singleSelectionsRepository;
        this.prizeLevelRepository = prizeLevelRepository;
        this.transactionRepository = transactionRepository;
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

    /*
     * private int NumberOfSsByTicket(long LotteryTicketid) { int ticketnumber = 0; for (SingleSelection selection :
     * singleSelectionsRepository.findAll()) { if (selection.getLotteryTicketid() == LotteryTicketid) { ticketnumber++;
     * } } return ticketnumber; }
     */

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

        /*
         * for (LotteryTicket ticket : ticketlist) { if (ticket.getLotteryDrawid() == id) { tickets +=
         * NumberOfSsByTicket(ticket.getId()); }
         *
         * }
         */
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
        lotteryDraw.setWinningNumbers("");
        String[] numbersToSort = lotteryGame.getWinningNumbers().split(",");
        Arrays.sort(numbersToSort, new Comparator<String>()
        {
            @Override
            public int compare(String s1, String s2) {
                return Integer.valueOf(s1).compareTo(Integer.valueOf(s2));
            }
        });
        for (int i = 0; i < numbersToSort.length; i++) {
            lotteryDraw.setWinningNumbers(lotteryDraw.getWinningNumbers() + numbersToSort[i].toString());
        }
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
    public LotteryDraw settle(long lotteryDrawId) throws Exception {
        long pool = 0;
        // Number of winning selection per prize level number
        Map<Integer, Integer> winningSingleSelectionPerPrizeLevel = new HashMap<>();
        // Unitary win amount per prize level number
        Map<Integer, Long> unitaryWinAmountOnPrizeLevel = new HashMap<>();
        // Single selections listed per ticket id
        Map<Long, List<SingleSelection>> singleSelectionsPerTicket = new HashMap<>();
        // Prize level number by id
        Map<Long, Integer> prizeLevelNumberPerPrizeLevelId = new HashMap<>();
        // Prize level id by number
        Map<Integer, Long> prizeLevelIdPerPrizeLevelNumber = new HashMap<>();
        // winning level of a singleselection stored in a map
        Map<Long, Integer> winningLevelOfSingleSelection = new HashMap<>();

        // Load the draw to settle
        LotteryDraw lotteryDrawToSettle = lotteryDrawRepository.findById(lotteryDrawId);
        // Get the winning number
        String winningNumbers = lotteryDrawToSettle.getWinningNumbers();
        // TODO: Error handling if not available
        if (winningNumbers.isEmpty()) {
            throw new Exception("there are no winningnumbers");
        }
        // Split the comma separated list into individual entries
        String[] winningNumberArray = winningNumbers.split(",");

        // Load all prize levels
        List<PrizeLevel> prizeLevels = prizeLevelRepository.findByLotterydrawid(lotteryDrawId);
        // TODO: Error handling if list size is not correct
        if (prizeLevels.size() != 4) {
            throw new Exception("prizeLevels list size in not correct");
        }
        // Filling up the prize level related maps
        for (PrizeLevel level : prizeLevels) {
            prizeLevelNumberPerPrizeLevelId.put(level.getId(), level.getLevel());
            prizeLevelIdPerPrizeLevelNumber.put(level.getLevel(), level.getId());
        }

        // Load all tickets for settlement
        List<LotteryTicket> lotteryTickets = lotteryTicketsRepository.findByLotteryDrawid(lotteryDrawId);

        // Iterating through tickets to determine poolsize, and load selections
        for (LotteryTicket ticket : lotteryTickets) {
            // Pool summary
            pool += ticket.getStake();

            // Loading single selections for current ticket
            List<SingleSelection> singleSelectionsForTicket =
                    singleSelectionsRepository.findByLotteryTicketid(ticket.getId());

            for (SingleSelection selectionForTicket : singleSelectionsForTicket) {
                int levelNumber = 0;
                // TODO:DONE: Compare the selection numbers with the winning number and determine the winning level number
                levelNumber = compareWinningNumbersWithSingleSelections(winningNumberArray,selectionForTicket.getSelection());
                winningLevelOfSingleSelection.put(selectionForTicket.getId(), levelNumber);
                // Updating winning single selection by prize level map
                winningSingleSelectionPerPrizeLevel.put(levelNumber,
                        winningSingleSelectionPerPrizeLevel.get(levelNumber) + 1);

                // Set the winning prize level id for the single selection in the map
                selectionForTicket.setPrizeLevelid(prizeLevelIdPerPrizeLevelNumber.get(levelNumber));

                // Adding the singleselection into the ticketId map
                if (singleSelectionsPerTicket.get(ticket.getId()) == null) {
                    List<SingleSelection> selectionsForPrizeLevel = new ArrayList<>();
                    selectionsForPrizeLevel.add(selectionForTicket);
                    singleSelectionsPerTicket.put(ticket.getId(), selectionsForPrizeLevel);
                } else {
                    singleSelectionsPerTicket.get(ticket.getId()).add(selectionForTicket);
                }
            }
        }

        // Now we will calculate the
        for (PrizeLevel level : prizeLevels) {
            // Calculate the multiplier
            BigDecimal multiplier =
                    BigDecimal.valueOf(level.getWinningpercentage()).divide(BigDecimal.valueOf(100),
                            RoundingMode.HALF_UP);
            // Calculate the pool allocated for the given level
            BigDecimal poolForLevel = BigDecimal.valueOf(pool).multiply(multiplier);

            // Get the number of winning selections for the level
            Integer singleSelectionForLevel = winningSingleSelectionPerPrizeLevel.get(level.getLevel());

            // Calculate the unitary win amount on the level
            BigDecimal unitaryWinAmountForLevel =
                    poolForLevel.divide(BigDecimal.valueOf(singleSelectionForLevel), 0, RoundingMode.HALF_UP);

            // Store it in the map
            unitaryWinAmountOnPrizeLevel.put(level.getLevel(), unitaryWinAmountForLevel.longValue());
        }

        // TODO:DONE: Iterate through the ticket per single selection map, determine the total winnings for the ticket
        // and
        // save a transaction for tickets where winnings > 0
        int wonMoneyByTicket;
        for (LotteryTicket ticket : lotteryTickets) {
            wonMoneyByTicket = 0;
            for(SingleSelection selection : singleSelectionsPerTicket.get(ticket.getId())) {
                selection.setWinningAmount(unitaryWinAmountOnPrizeLevel
                        .get(winningLevelOfSingleSelection.get(selection.getId())).intValue());
                wonMoneyByTicket += selection.getWinningAmount();
            }
            if (wonMoneyByTicket > 0) {
                createTransaction(wonMoneyByTicket, /* Integer operatorId */null, ticket.getPlayerid());
            }
        }

        return null;
    }

    private void createTransaction(Integer amount, Integer operatorId, Integer playerId) {
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setCreateDate(Date.valueOf(LocalDate.now()));
        transaction.setOperatorId(operatorId);
        transaction.setPlayerId(playerId);
        transaction.setType("winning");
        this.transactionRepository.save(transaction);
    }

    private int compareWinningNumbersWithSingleSelections(String[] winningNumberArray, String selectionNumbers) {
        int level = 0;
        String[] selectionNumberArray = selectionNumbers.split(",");
        for (int i = 0; i < winningNumberArray.length; i++) {
            for (int k = 0; k < winningNumberArray.length; k++) {
                if (winningNumberArray[i].equals(selectionNumberArray[k])) {
                    level++;
                }
            }
        }
        return level;
    }
}
