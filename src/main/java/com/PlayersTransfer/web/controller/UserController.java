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

@RestController    // This means that this class is a Controller
public class UserController {
	@Autowired 
	private UserRepository userRepository;
	
	@GetMapping("/gUsers")  // to get all Users
	public Iterable<User> getAllPlsyers() {
		return userRepository.findAll();
	}
	
	@PostMapping("/aUser")   // to add user
	public User createPlayer(@Valid @RequestBody User user) {

		return userRepository.save(user);
	}
	
	// Get a Single User
		@GetMapping("/gUser/{Uid}")
		public User getPlayerById(@PathVariable(value = "uid") long userId) {
			return userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User", "uid", userId));
		}

		// Update a User
		@PutMapping("/uUser/{Uid}")
		public User updatePlayer(@PathVariable(value = "Uid") Long userId,
				@Valid @RequestBody User userDetails) {

			User user = userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User", "Uid", userId));

			user.setName(userDetails.getName());
			user.setEmail(userDetails.getEmail());
			user.setAge(userDetails.getAge());

			User updatedUser = userRepository.save(user);
			return updatedUser;
		}
	// Delete a User
	@DeleteMapping("/dUser/{pid}")
	public ResponseEntity<?> deletePlayer(@PathVariable(value = "uid") Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "uid", userId));

		userRepository.delete(user);

		return ResponseEntity.ok().build();
	}
}
