package com.PlayersTransfer.presistance.repository;

import org.springframework.stereotype.Repository;
import com.PlayersTransfer.presistance.model.Club;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Repository
@RepositoryRestResource(collectionResourceRel="Clubs",path="Clubs")
public interface ClubRepository extends JpaRepository<Club,Long> {
}
