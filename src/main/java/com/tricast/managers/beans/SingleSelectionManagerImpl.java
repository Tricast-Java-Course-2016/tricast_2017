package com.tricast.managers.beans;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tricast.repositories.SingleSelectionsRepository;
import com.tricast.repositories.entities.SingleSelections;

@Service
public class SingleSelectionManagerImpl implements SingleSelectionManager {

    private SingleSelectionsRepository singleSelectionsRepository;

    @Inject
    public SingleSelectionManagerImpl(SingleSelectionsRepository singleSelectionsRepository) {
        this.singleSelectionsRepository = singleSelectionsRepository;
    }

    @Override
    public List<SingleSelections> findAll() {
        return singleSelectionsRepository.findAll();
    }

    @Override
    public SingleSelections findById(Long id) {
        return singleSelectionsRepository.findById(id);
    }

    @Override
    public SingleSelections create(SingleSelections singleSelections) {
        return singleSelectionsRepository.save(singleSelections);
    }

    @Override
    public SingleSelections update(SingleSelections singleSelections) {
        return singleSelectionsRepository.save(singleSelections);
    }

    @Override
    public void deleteById(Long id) {
        singleSelectionsRepository.delete(id);
    }

}

