package com.tricast.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tricast.controllers.requests.LoginRequest;
import com.tricast.controllers.responses.PlayerResponse;
import com.tricast.managers.PlayerManager;
import com.tricast.repositories.entities.Player;

@RestController
@RequestMapping(path = "player")
public class PlayerController {

    private PlayerManager playerManager;

    @Inject
    public PlayerController(PlayerManager playerManager) {
        this.playerManager = playerManager;
    }

    @GetMapping
    public List<Player> findAll() {
        return playerManager.findAll();
    }

    @PostMapping
    public Player create(@RequestBody Player player) {
        return playerManager.create(player);
    }

    @GetMapping("/{id}")
    public Player findById(@PathVariable("id") long id) {
        return playerManager.findById(id);
    }

    @PutMapping
    public Player update(@RequestBody Player player) {
        return playerManager.update(player);
    }

    @DeleteMapping
    public void delete(@PathVariable long id) {
        playerManager.deleteById(id);
    }

	@RequestMapping(method = RequestMethod.POST, path = "/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
				
		try {
			PlayerResponse account = playerManager.login(loginRequest.getUserName(), loginRequest.getPassword());
			return ResponseEntity.ok(account);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
