package com.tricast.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tricast.repositories.entities.LotteryTicket;

public interface LotteryTicketsRepository extends CrudRepository<LotteryTicket, Long> {

    @Override
    List<LotteryTicket> findAll();

    LotteryTicket findById(Long id);

    List<LotteryTicket> findByLotteryDrawId(Long lotteryDrawId);

}