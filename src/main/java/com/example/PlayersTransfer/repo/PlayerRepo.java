package com.example.PlayersTransfer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PlayersTransfer.model.Player;

public interface PlayerRepo extends JpaRepository<Player, Integer> {

}
