package edu.avale1648.internationale.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.avale1648.internationale.entities.Post;
import edu.avale1648.internationale.exceptions.PostNotFoundException;
import edu.avale1648.internationale.repositories.PostRepository;

@RestController
public class PostController {
	private final PostRepository REPOSITORY;

	public PostController(PostRepository repository) {
		REPOSITORY = repository;
	}

	@PostMapping("/posts")
	public Post create(@RequestBody Post post) {
		return REPOSITORY.save(post);
	}

	@GetMapping("/posts/{id}")
	public Post read(@PathVariable Integer id) {
		return REPOSITORY.findById(id).orElseThrow(() -> new PostNotFoundException(id));
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/posts")
	public Iterable<Post> readAll() {
		return REPOSITORY.findAll();
	}
	// end::get-aggregate-root[]

	@PutMapping("/posts/{id}")
	public Post update(@RequestBody Post newPost, @PathVariable Integer id) {
		return REPOSITORY.findById(id).map(post -> {
			post = new Post(newPost);
			return REPOSITORY.save(post);
		}).orElseGet(() -> {
			newPost.setId(id);
			return REPOSITORY.save(newPost);
		});
	}

	@DeleteMapping("/posts/{id}")
	public void delete(@PathVariable Integer id) {
		REPOSITORY.deleteById(id);
	}

	@DeleteMapping("/posts")
	public void deleteAll() {
		REPOSITORY.deleteAll();
	}
}
