package com.tricast.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tricast.repositories.entities.LotteryDraw;


public interface LotteryDrawRepository extends CrudRepository<LotteryDraw, Long> {

	@Override
    List<LotteryDraw> findAll();

    LotteryDraw findById(Long id);


}