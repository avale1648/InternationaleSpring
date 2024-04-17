package edu.avale1648.internationale.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.avale1648.internationale.entities.Group;
import edu.avale1648.internationale.repositories.GroupRepository;

@Controller
@RequestMapping(path = "/groups")
public class GroupConroller {
	@Autowired
	private GroupRepository repository;

	@PostMapping(path = "/create-or-update")
	public @ResponseBody Group createOrUpdate(@RequestParam String name, @RequestParam boolean mature) {
		var group = new Group(name, mature);

		repository.save(group);

		return group;
	}

	@GetMapping(path = "/read")
	public @ResponseBody Group read(Integer id) {
		return repository.findById(id).get();
	}

	@GetMapping(path = "/read-all")
	public @ResponseBody Iterable<Group> readAll() {
		return repository.findAll();
	}

	@DeleteMapping(path = "/delete")
	public @ResponseBody Group delete(@RequestParam Integer id) {
		var group = repository.findById(id).get();

		repository.delete(group);

		return group;
	}

	@DeleteMapping(path = "/delete-all")
	public @ResponseBody Iterable<Group> deleteAll() {
		var groups = repository.findAll();

		repository.deleteAll();

		return groups;
	}

}
