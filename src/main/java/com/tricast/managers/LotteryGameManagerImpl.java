package com.tricast.managers;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.stereotype.Service;

import com.tricast.controllers.requests.LotteryGameRequest;
import com.tricast.repositories.LotteryGameRepository;
import com.tricast.repositories.entities.LotteryGame;

@Service
@Transactional
public class LotteryGameManagerImpl implements LotteryGameManager {

    private LotteryGameRepository lotteryGameRepository;

    @Inject
    public LotteryGameManagerImpl(LotteryGameRepository lotteryGamesRepository) {
        this.lotteryGameRepository = lotteryGamesRepository;
    }

    @Override
    public List<LotteryGame> findAll() {
        return lotteryGameRepository.findAll();
    }

    @Override
    public LotteryGame findById(Long id) {
        return lotteryGameRepository.findById(id);
    }

    @Override
    public LotteryGame create(LotteryGame lotteryGames) {
        return lotteryGameRepository.save(lotteryGames);
    }

    @Override
    public LotteryGame update(LotteryGameRequest lotteryGameRequest) throws SQLException {
    	
    	validateLotteryGame(lotteryGameRequest);
    	
    	LotteryGame lotteryGame = lotteryGameRepository.findById(lotteryGameRequest.getId());
    	
    	lotteryGame.setBaseStake(lotteryGameRequest.getBaseStake());
    	lotteryGame.setDescription(lotteryGameRequest.getDescription());
    	lotteryGame.setGridSize(lotteryGameRequest.getGridSize());
    	lotteryGame.setMaxNrOfCombination(lotteryGameRequest.getMaxNrOfCombination());
    	lotteryGame.setMaxNrOfFix(lotteryGameRequest.getMaxNrOfFix());
    	lotteryGame.setMinNrOfFix(lotteryGameRequest.getMinNrOfFix());
    	lotteryGame.setNrOfGrids(lotteryGameRequest.getNrOfGrids());
    	lotteryGame.setNumbersDrawn(lotteryGameRequest.getNumbersDrawn());    	
    	
        return lotteryGame;
    }

    private void validateLotteryGame(LotteryGameRequest request) throws SQLException {
    	
    	if(request.getMaxNrOfFix() < request.getMinNrOfFix()) {
    		throw new SQLException("Max nr of fix can't be smaller then the min");
    	}
    
    	if((request.getMinNrOfFix() + request.getMaxNrOfCombination()) < request.getNumbersDrawn()) {
    		throw new SQLException("Min fix and max combi must be exceeded the number of drawn");
    	}    		
    }
    
    @Override
    public void deleteById(Long id) {
        lotteryGameRepository.delete(id);
    }

}

