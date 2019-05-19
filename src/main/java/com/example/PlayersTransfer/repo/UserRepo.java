package com.example.PlayersTransfer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PlayersTransfer.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
