package com.tricast.managers.beans;

import java.util.List;

import com.tricast.repositories.entities.SingleSelections;

public interface SingleSelectionManager {

    List<SingleSelections> findAll();

    SingleSelections findById(Long id);

    SingleSelections create(SingleSelections singleSelection);

    SingleSelections update(SingleSelections singleSelection);

    void deleteById(Long id);

}