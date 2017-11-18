package com.tricast.managers;

import java.util.List;

import javax.inject.Inject;

import com.tricast.repositories.TransactionRepository;
import com.tricast.repositories.entities.Transaction;

public class TransactionManagerImpl implements TransactionManager {

    private TransactionRepository transactionRepository;

    @Inject
    public TransactionManagerImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> findAll() {
        return this.transactionRepository.findAll();
    }

    @Override
    public Transaction findById(Long id) {
        return this.transactionRepository.findById(id);
    }

    @Override
    public Transaction create(Transaction transaction) {
        return this.transactionRepository.save(transaction);
    }

    @Override
    public Transaction update(Transaction transaction) {
        return this.transactionRepository.save(transaction);
    }

    @Override
    public void deleteById(Long id) {
        this.transactionRepository.delete(id);

    }

}
