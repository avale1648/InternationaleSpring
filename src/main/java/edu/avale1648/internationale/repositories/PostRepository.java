package edu.avale1648.internationale.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.avale1648.internationale.entities.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {
	
}
