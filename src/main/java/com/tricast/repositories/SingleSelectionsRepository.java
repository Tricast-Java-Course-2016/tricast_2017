package com.tricast.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tricast.repositories.entities.LotteryTickets;

				  
public interface SingleSelectionsReposytory extends CrudRepository<SingleSelections, Long>{

	@Override
	List<SingleSelections> findAll();
	
	SingleSelections findById(Long id);
	
	
}