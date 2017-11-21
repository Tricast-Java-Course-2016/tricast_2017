package com.tricast.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tricast.repositories.entities.SingleSelection;

public interface SingleSelectionsRepository extends CrudRepository<SingleSelection, Long> {

	@Override
	List<SingleSelection> findAll();

	SingleSelection findById(Long id);

    List<SingleSelection> findByLotteryTicketid(Long lotteryTicketId);


}