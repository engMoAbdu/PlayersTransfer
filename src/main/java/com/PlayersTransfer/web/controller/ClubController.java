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
import com.PlayersTransfer.presistance.model.Club;
import com.PlayersTransfer.presistance.repository.ClubRepository;



@RestController
public class ClubController {
	@Autowired
	private ClubRepository clupRepository;
	
	@GetMapping("/gClubs")  // to get all CLubs
	public Iterable<Club> getAllClubs() {
		return clupRepository.findAll();
	}

	@PostMapping("/aClub")   // to add Club
	public Club createClub(@Valid @RequestBody Club club) {

		return clupRepository.save(club);
	}

	// Get a Single Club
	@GetMapping("/gClub/{cid}")
	public Club getClubById(@PathVariable(value = "cid") Long clubId) {
		return clupRepository.findById(clubId)
				.orElseThrow(() -> new ResourceNotFoundException("Club", "cid", clubId));
	}

	// Update a Club
	@PutMapping("/uClub/{cid}")
	public Club updateNote(@PathVariable(value = "cid") Long clubId,
			@Valid @RequestBody Club clubDetails) {

		Club club = clupRepository.findById(clubId)
				.orElseThrow(() -> new ResourceNotFoundException("Club", "cid", clubId));

		club.setName(clubDetails.getName());
		club.setCountry(clubDetails.getCountry());
		
		Club updatedClub = clupRepository.save(club);
		return updatedClub;
	}

	// Delete a Club
	@DeleteMapping("/dClub/{cid}")
	public ResponseEntity<?> deleteClub(@PathVariable(value = "cid") Long clubId) {
		Club club = clupRepository.findById(clubId)
				.orElseThrow(() -> new ResourceNotFoundException("Club", "cid", clubId));

		clupRepository.delete(club);

		return ResponseEntity.ok().build();
	}
}
