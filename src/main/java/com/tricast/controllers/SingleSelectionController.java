package com.tricast.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tricast.managers.beans.SingleSelectionManager;
import com.tricast.repositories.entities.SingleSelections;

@RestController
@RequestMapping(path = "singleselection")
public class SingleSelectionController {

    private SingleSelectionManager singleSelectionManager;

    @Inject
    public SingleSelectionController(SingleSelectionManager singleSelectionManager) {
        this.singleSelectionManager = singleSelectionManager;
    }

    @GetMapping
    public List<SingleSelections> findAll() {
        return singleSelectionManager.findAll();
    }

    @PostMapping
    public SingleSelections create(@RequestBody SingleSelections singleSelection) {
        return singleSelectionManager.create(singleSelection);
    }

}

