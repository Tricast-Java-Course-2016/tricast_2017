package com.tricast.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tricast.repositories.entities.Operator;

public interface OperatorRepository extends CrudRepository<Operator, Long> {

	@Override
    List<Operator> findAll();

    Operator findById(Long id);

    Operator findByUserName(String username);
}