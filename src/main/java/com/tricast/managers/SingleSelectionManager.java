package com.tricast.managers;

import java.util.List;

import com.tricast.repositories.entities.SingleSelection;

public interface SingleSelectionManager {

    List<SingleSelection> findAll();

    SingleSelection findById(Long id);

    SingleSelection create(SingleSelection singleSelection);

    SingleSelection update(SingleSelection singleSelection);

    void deleteById(Long id);

}