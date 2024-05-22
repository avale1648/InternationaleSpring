package edu.avale1648.internationale.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.avale1648.internationale.entities.User;
import edu.avale1648.internationale.exceptions.UserNotFoundException;
import edu.avale1648.internationale.repositories.UserRepository;

@RestController
public class UserController {

	private final UserRepository REPOSITORY;

	public UserController(UserRepository repository) {
		REPOSITORY = repository;
	}

	@PostMapping("/users")
	public User create(@RequestBody User user) {
		return REPOSITORY.save(user);
	}

	@GetMapping("/users/{id}")
	public User read(@PathVariable Integer id) {
		return REPOSITORY.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/users")
	public Iterable<User> readAll() {
		return REPOSITORY.findAll();
		//return 
	}
	
	@PutMapping("/users/{id}")
	public User update(@RequestBody User newUser, @PathVariable Integer id) {
		return REPOSITORY.findById(id).map(user -> {
			user = new User(newUser);
			return REPOSITORY.save(user);
		}).orElseGet(() -> {
			newUser.setId(id);
			return REPOSITORY.save(newUser);
		});
	}

	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable Integer id) {
		REPOSITORY.deleteById(id);
	}

	@DeleteMapping("/users")
	public void deleteAll() {
		REPOSITORY.deleteAll();
	}
}
