package edu.avale1648.internationale.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.avale1648.internationale.entities.Group;
import edu.avale1648.internationale.exceptions.GroupNotFoundException;
import edu.avale1648.internationale.repositories.GroupRepository;

@RestController
public class GroupConroller {
	private final GroupRepository REPOSITORY;

	public GroupConroller(GroupRepository repository) {
		REPOSITORY = repository;
	}

	@PostMapping("/groups")
	public Group create(@RequestBody Group group) {
		return REPOSITORY.save(group);
	}

	@GetMapping("/groups/{id}")
	public Group read(@PathVariable Integer id) {
		return REPOSITORY.findById(id).orElseThrow(() -> new GroupNotFoundException(id));
	}

	@GetMapping("/groups")
	public Iterable<Group> readAll() {
		return REPOSITORY.findAll();
	}

	@PutMapping("/groups/{id}")
	public Group update(@RequestBody Group newGroup, @PathVariable Integer id) {
		return REPOSITORY.findById(id).map(group -> {
			group = new Group(newGroup);
			return REPOSITORY.save(group);
		}).orElseGet(() -> {
			newGroup.setId(id);
			return REPOSITORY.save(newGroup);
		});
	}

	@DeleteMapping("/groups/{id}")
	public void delete(@PathVariable Integer id) {
		REPOSITORY.deleteById(id);
	}

	@DeleteMapping("/groups")
	public void deleteAll() {
		REPOSITORY.deleteAll();
	}

}
