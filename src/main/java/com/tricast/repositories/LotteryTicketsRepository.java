package com.tricast.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tricast.repositories.entities.LotteryTickets;


public interface LotteryTicketsRepository extends CrudRepository<LotteryTickets, Long> {

	@Override
	List<LotteryTickets> findAll();

	LotteryTickets findById(Long id);


}