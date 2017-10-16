package com.tricast.managers;

import java.util.List;

import com.tricast.repositories.entities.Operator;

public interface OperatorManager {

    List<Operator> findAll();

    Operator findById(Long id);

    Operator create(Operator player);

    Operator update(Operator player);

    void deleteById(Long id);

}
