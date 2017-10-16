package com.tricast.managers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tricast.repositories.SingleSelectionsRepository;
import com.tricast.repositories.entities.SingleSelection;

@Service
public class SingleSelectionManagerImpl implements SingleSelectionManager {

    private SingleSelectionsRepository singleSelectionsRepository;

    @Inject
    public SingleSelectionManagerImpl(SingleSelectionsRepository singleSelectionsRepository) {
        this.singleSelectionsRepository = singleSelectionsRepository;
    }

    @Override
    public List<SingleSelection> findAll() {
        return singleSelectionsRepository.findAll();
    }

    @Override
    public SingleSelection findById(Long id) {
        return singleSelectionsRepository.findById(id);
    }

    @Override
    public SingleSelection create(SingleSelection singleSelections) {
        return singleSelectionsRepository.save(singleSelections);
    }

    @Override
    public SingleSelection update(SingleSelection singleSelections) {
        return singleSelectionsRepository.save(singleSelections);
    }

    @Override
    public void deleteById(Long id) {
        singleSelectionsRepository.delete(id);
    }

}

