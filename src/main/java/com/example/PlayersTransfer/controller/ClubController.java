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

import com.example.PlayersTransfer.model.Club;
import com.example.PlayersTransfer.repo.ClubRepo;

@RestController
public class ClubController {
	
	@Autowired
	ClubRepo clubRepo;
	
	@PostMapping("/aClub")
	public Club getClub(@RequestBody Club club)
	{
		
		return clubRepo.save(club);
	}

	@GetMapping("/gClubs")
	public List<Club> getAllClubs()
	{
		return clubRepo.findAll();
	}
	
	@GetMapping("gClub/{C_ID}")
	public Optional<Club> getClub(@PathVariable("C_ID") int C_ID)
	{
		return clubRepo.findById(C_ID);
	}
	
	@DeleteMapping("dClub/{C_ID}")
	public String deleteClub(@PathVariable("C_ID") int C_ID)
	{
		Club club= clubRepo.getOne(C_ID);
		clubRepo.delete(club);
		return "Deleted";
	}
}
