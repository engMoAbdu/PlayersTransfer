package com.PlayersTransfer.presistance.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import com.PlayersTransfer.presistance.model.Player;

@Repository
@RepositoryRestResource(collectionResourceRel="Players",path="Players")
public interface PlayerRepository extends JpaRepository<Player,Long>{
}
