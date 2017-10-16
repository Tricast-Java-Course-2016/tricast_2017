package com.tricast.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tricast.managers.SingleSelectionManager;
import com.tricast.repositories.entities.SingleSelection;

@RestController
@RequestMapping(path = "singleselection")
public class SingleSelectionController {

    private SingleSelectionManager singleSelectionManager;

    @Inject
    public SingleSelectionController(SingleSelectionManager singleSelectionManager) {
        this.singleSelectionManager = singleSelectionManager;
    }

    @GetMapping
    public List<SingleSelection> findAll() {
        return singleSelectionManager.findAll();
    }

    @PostMapping
    public SingleSelection create(@RequestBody SingleSelection singleSelection) {
        return singleSelectionManager.create(singleSelection);
    }

}

