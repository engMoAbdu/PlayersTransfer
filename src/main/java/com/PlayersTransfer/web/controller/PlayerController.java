package com.PlayersTransfer.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PlayersTransfer.exception.ResourceNotFoundException;
import com.PlayersTransfer.presistance.model.*;
import com.PlayersTransfer.presistance.repository.*;


@RestController
public class PlayerController {
	@Autowired
	private PlayerRepository playerRepository;

	@GetMapping("/gPlayers")  // to get all Players
	public Iterable<Player> getAllPlsyers() {
		return playerRepository.findAll();
	}

	@PostMapping("/aPlayer")   // to add Players
	public Player createPlayer(@Valid @RequestBody Player player) {

		return playerRepository.save(player);
	}

	// Get a Single player
	@GetMapping("/gPlayer/{pid}")
	public Player getPlayerById(@PathVariable(value = "pid") Long playerId) {
		return playerRepository.findById(playerId)
				.orElseThrow(() -> new ResourceNotFoundException("Player", "pid", playerId));
	}

	// Update a Player
	@PutMapping("/uPlayer/{P_id}")
	public Player updatePlayer(@PathVariable(value = "Pid") Long playerId,
			@Valid @RequestBody Player playerDetails) {

		Player player = playerRepository.findById(playerId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "pid", playerId));

		player.setName(playerDetails.getName());
		player.setAge(playerDetails.getAge());

		Player updatedPlayer = playerRepository.save(player);
		return updatedPlayer;
	}

	// Delete a player
	@DeleteMapping("/dPlayer/{pid}")
	public ResponseEntity<?> deletePlayer(@PathVariable(value = "pid") Long playerId) {
		Player player = playerRepository.findById(playerId)
				.orElseThrow(() -> new ResourceNotFoundException("Player", "pid", playerId));

		playerRepository.delete(player);

		return ResponseEntity.ok().build();
	}
}
