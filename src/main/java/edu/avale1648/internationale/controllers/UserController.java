package edu.avale1648.internationale.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.avale1648.internationale.entities.User;
import edu.avale1648.internationale.repositories.UserRepository;

@Controller
@RequestMapping(path = "/users")
public class UserController {
	@Autowired
	private UserRepository repository;

	@PostMapping(path = "/create-or-update")
	public @ResponseBody User createOrUpdate(@RequestParam String name, @RequestParam String email,
			@RequestParam String password, @RequestParam String birthday) {
		var user = new User(name, email, password, birthday);

		repository.save(user);

		return user;
	}

	@GetMapping(path = "/read")
	public @ResponseBody User read(@RequestParam Integer id) {
		return repository.findById(id).get();
	}

	@GetMapping(path = "/read-all")
	public @ResponseBody Iterable<User> readAll() {
		return repository.findAll();
	}

	@DeleteMapping(path = "/delete")
	public @ResponseBody User delete(@RequestParam Integer id) {
		var user = repository.findById(id).get();

		repository.delete(user);

		return user;
	}

	@DeleteMapping(path = "/delete-all")
	public @ResponseBody Iterable<User> deleteAll() {
		var users = repository.findAll();

		repository.deleteAll();

		return users;
	}
}
