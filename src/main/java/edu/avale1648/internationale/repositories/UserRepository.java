package edu.avale1648.internationale.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.avale1648.internationale.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
