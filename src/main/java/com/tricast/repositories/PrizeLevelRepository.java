package com.tricast.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tricast.repositories.entities.PrizeLevel;

public interface PrizeLevelRepository extends CrudRepository<PrizeLevel, Long> {

    @Override
    List<PrizeLevel> findAll();

    PrizeLevel findById(Long id);
}
