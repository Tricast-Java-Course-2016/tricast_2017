package com.tricast.managers.beans;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tricast.repositories.PlayerRepository;
import com.tricast.repositories.entities.Player;

@Service
public class PlayerManagerImpl implements PlayerManager {

    private PlayerRepository playerRepository;

    @Inject
    public PlayerManagerImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player findById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public Player create(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player update(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.delete(id);
    }

}
