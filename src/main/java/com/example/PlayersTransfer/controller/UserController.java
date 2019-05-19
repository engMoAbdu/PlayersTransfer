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

import com.example.PlayersTransfer.model.User;
import com.example.PlayersTransfer.repo.UserRepo;

@RestController
public class UserController {

	@Autowired
	UserRepo userRepo;
	
	@PostMapping("/aUser")
	public User addUser(@RequestBody User user)
	{
		return userRepo.save(user);
	}
	
	@GetMapping("gUsers")
	public List<User> getAllPlayers()
	{
		return userRepo.findAll();
	}
	
	@GetMapping("gUser/{U_ID}")
	public Optional<User> getPlayer(@PathVariable("U_ID") int U_ID)
	{
		return userRepo.findById(U_ID);
	}
	
	@DeleteMapping("dUser")
	public String deletePlayer(@PathVariable("U_ID") int U_ID)
	{
		User user = userRepo.getOne(U_ID);
		userRepo.delete(user);
		return "DELETED";
	}
}
