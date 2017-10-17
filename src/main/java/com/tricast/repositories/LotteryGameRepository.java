package com.tricast.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tricast.repositories.entities.LotteryGame;


public interface LotteryGameRepository extends CrudRepository<LotteryGame, Long> {

	@Override
    List<LotteryGame> findAll();

    LotteryGame findById(Long id);


}