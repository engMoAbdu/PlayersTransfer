package com.PlayersTransfer.presistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import com.PlayersTransfer.presistance.model.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
@RepositoryRestResource(collectionResourceRel="Users",path="Users")
public interface UserRepository extends JpaRepository<User, Long> {
}