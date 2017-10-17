package com.tricast.managers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tricast.repositories.LotteryGameRepository;
import com.tricast.repositories.entities.LotteryGame;

@Service
public class LotteryGameManagerImpl implements LotteryGameManager {

    private LotteryGameRepository lotteryGameRepository;

    @Inject
    public LotteryGameManagerImpl(LotteryGameRepository LotteryGamesRepository) {
        this.lotteryGameRepository = LotteryGamesRepository;
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
    public LotteryGame create(LotteryGame LotteryGames) {
        return lotteryGameRepository.save(LotteryGames);
    }

    @Override
    public LotteryGame update(LotteryGame LotteryGames) {
        return lotteryGameRepository.save(LotteryGames);
    }

    @Override
    public void deleteById(Long id) {
        lotteryGameRepository.delete(id);
    }

}

