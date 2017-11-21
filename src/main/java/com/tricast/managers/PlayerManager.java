package com.tricast.managers;

import java.sql.SQLException;
import java.util.List;

import com.tricast.controllers.responses.PlayerResponse;
import com.tricast.repositories.entities.Player;

public interface PlayerManager {

    List<Player> findAll();

    Player findById(Long id);

    Player create(Player player);

    Player update(Player player);

    void deleteById(Long id);

    PlayerResponse login(String username, String password) throws SQLException;
}
