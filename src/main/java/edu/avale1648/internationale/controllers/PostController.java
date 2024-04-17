package edu.avale1648.internationale.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.avale1648.internationale.entities.Post;
import edu.avale1648.internationale.repositories.PostRepository;

@Controller
@RequestMapping(path="/posts")
public class PostController {
	@Autowired
	private PostRepository repository;
	private UserController userController = new UserController();
	private GroupConroller groupController = new GroupConroller();
	
	
	@PostMapping(path="/create-or-update")
	public @ResponseBody Post createOrUpdate(@RequestParam Integer userId, @RequestParam Integer groupId, @RequestParam String text) {
		var user = userController.read(userId);
		if(user == null) {
			throw new IllegalStateException("User not found");
		}
		var group = groupController.read(groupId);
		
		var post = new Post(user, group, text);
		
		repository.save(post);
		
		return post;
	}
	
	@GetMapping(path = "/read")
	public @ResponseBody Post read(@RequestParam Integer id) {
		return repository.findById(id).get();
	}

	@GetMapping(path = "/read-all")
	public @ResponseBody Iterable<Post> readAll() {
		return repository.findAll();
	}

	@DeleteMapping(path = "/delete")
	public @ResponseBody Post delete(@RequestParam Integer id) {
		var post = repository.findById(id).get();

		repository.delete(post);

		return post;
	}

	@DeleteMapping(path = "/delete-all")
	public @ResponseBody Iterable<Post> deleteAll() {
		var posts = repository.findAll();

		repository.deleteAll();

		return posts;
	}
}
