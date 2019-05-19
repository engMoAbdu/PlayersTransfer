package com.example.PlayersTransfer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PlayersTransfer.model.Club;

public interface ClubRepo extends JpaRepository<Club, Integer> {

}
