package com.tricast.managers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tricast.repositories.LotteryDrawRepository;
import com.tricast.repositories.entities.LotteryDraw;

@Service
public class LotteryDrawManagerImpl implements LotteryDrawManager {

    private LotteryDrawRepository lotteryDrawsepository;

    @Inject
    public LotteryDrawManagerImpl(LotteryDrawRepository LotteryDrawsRepository) {
        this.lotteryDrawsepository = LotteryDrawsRepository;
    }

    @Override
    public List<LotteryDraw> findAll() {
        return lotteryDrawsepository.findAll();
    }

    @Override
    public LotteryDraw findById(Long id) {
        return lotteryDrawsepository.findById(id);
    }

    @Override
    public LotteryDraw create(LotteryDraw LotteryDraws) {
        return lotteryDrawsepository.save(LotteryDraws);
    }

    @Override
    public LotteryDraw update(LotteryDraw LotteryDraws) {
        return lotteryDrawsepository.save(LotteryDraws);
    }

    @Override
    public void deleteById(Long id) {
        lotteryDrawsepository.delete(id);
    }

}

