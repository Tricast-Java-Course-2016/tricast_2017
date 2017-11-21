package com.tricast.managers;

import java.sql.SQLException;
import java.util.List;

import com.tricast.controllers.responses.OperatorResponse;
import com.tricast.controllers.responses.PlayerResponse;
import com.tricast.repositories.entities.Operator;
import com.tricast.repositories.entities.Player;

public interface OperatorManager {

    List<Operator> findAll();

    Operator findById(Long id);

    Operator create(Operator player);

    Operator update(Operator player);

    void deleteById(Long id);

    OperatorResponse login(String username, String password) throws SQLException;
}
