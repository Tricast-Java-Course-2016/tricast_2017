package com.tricast.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tricast.managers.OperatorManager;
import com.tricast.repositories.entities.Operator;

@RestController
@RequestMapping(path = "operator")
public class OperatorController {

    private OperatorManager operatorManager;

    @Inject
    public OperatorController(OperatorManager operatorManager) {
        this.operatorManager = operatorManager;
    }

    @GetMapping
    public List<Operator> findAll() {
        return operatorManager.findAll();
    }

    @PostMapping
    public Operator create(@RequestBody Operator player) {
        return operatorManager.create(player);
    }

    @GetMapping
    public Operator findById(@PathVariable long id) {
        return operatorManager.findById(id);
    }

    @PutMapping
    public Operator update(@RequestBody Operator operator) {
        return operatorManager.update(operator);
    }

    @DeleteMapping
    public void delete(@PathVariable long id) {
        operatorManager.deleteById(id);
    }

}
