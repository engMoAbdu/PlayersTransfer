package com.example.PlayersTransfer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.PlayersTransfer.model.Player;
import com.example.PlayersTransfer.repo.PlayerRepo;

@RestController
public class PlayerController {

	@Autowired
	PlayerRepo playerRepo;
	
	@PostMapping("/aPlayer")
	public Player addPlayer(@RequestBody Player player)
	{
		return playerRepo.save(player);
	}
	
	@GetMapping("gPlayers")
	public List<Player> getAllPlayers()
	{
		return playerRepo.findAll();
	}
	
	@GetMapping("gPlayer/{P_ID}")
	public Optional<Player> getPlayer(@PathVariable("P_ID") int P_ID)
	{
		return playerRepo.findById(P_ID);
	}
	
	@DeleteMapping("dPlayer")
	public String deletePlayer(@PathVariable("P_ID") int P_ID)
	{
		Player player = playerRepo.getOne(P_ID);
		playerRepo.delete(player);
		return "DELETED";
	}
}
