package com.tricast.managers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tricast.repositories.OperatorRepository;
import com.tricast.repositories.entities.Operator;

@Service
public class OperatorManagerImpl implements OperatorManager {

    private OperatorRepository operatorRepository;

    @Inject
    public OperatorManagerImpl(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    @Override
    public List<Operator> findAll() {
        return operatorRepository.findAll();
    }

    @Override
    public Operator findById(Long id) {
        return operatorRepository.findById(id);
    }

    @Override
    public Operator create(Operator player) {
        return operatorRepository.save(player);
    }

    @Override
    public Operator update(Operator player) {
        return operatorRepository.save(player);
    }

    @Override
    public void deleteById(Long id) {
        operatorRepository.delete(id);
    }

}
