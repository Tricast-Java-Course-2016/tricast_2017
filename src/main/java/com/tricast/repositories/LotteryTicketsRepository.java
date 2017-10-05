package com.tricast.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tricast.repositories.entities.LotteryTickets;

				  
public interface LotteryTicketsReposytory extends CrudRepository<Account, Long>{

	@Override
	List<LotteryTickets> findAll();
	
	LotteryTickets findById(Long id);
	
	
}