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
import org.springframework.web.bind.annotation.RestController;

import com.tricast.controllers.requests.LotteryGameRequest;
import com.tricast.managers.LotteryGameManager;
import com.tricast.repositories.entities.LotteryGame;

@RestController
@RequestMapping(path = "lotterygames")
public class LotteryGameController {

	private LotteryGameManager lotteryGameManager;

	@Inject
	public LotteryGameController(LotteryGameManager lotteryTicketManager) {
		this.lotteryGameManager = lotteryTicketManager;
	}

	@GetMapping
	public List<LotteryGame> findAll() {
		return lotteryGameManager.findAll();
	}

	@PostMapping
	public LotteryGame create(@RequestBody LotteryGame lotteryGame) {
		return lotteryGameManager.create(lotteryGame);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody LotteryGameRequest lotteryGameRequest) {
		try {
			LotteryGame lotteryGame = lotteryGameManager.update(lotteryGameRequest);
			return ResponseEntity.ok(lotteryGame);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public LotteryGame findById(@PathVariable("id") long id) {
		return lotteryGameManager.findById(id);
	}

	@DeleteMapping
	public void delete(@PathVariable long id) {
		lotteryGameManager.deleteById(id);
	}

}
