package edu.avale1648.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.avale1648.internationale.entities.Group;
import edu.avale1648.internationale.entities.Post;
import edu.avale1648.internationale.entities.User;
import edu.avale1648.internationale.repositories.GroupRepository;
import edu.avale1648.internationale.repositories.PostRepository;
import edu.avale1648.internationale.repositories.UserRepository;

@Component
public class DbLoader implements CommandLineRunner {
	private final UserRepository USERS;
	private final GroupRepository GROUPS;
	private final PostRepository POSTS;

	@Autowired
	public DbLoader(UserRepository users, GroupRepository groups, PostRepository posts) {
		USERS = users;
		GROUPS = groups;
		POSTS = posts;
	}

	@Override
	public void run(String... args) throws Exception {
		var lenin = new User("Lenin", "lenin@pochta.su", "ninel", "22-04-1870");
		var ussr = new Group("USSR", false);

		USERS.save(lenin);
		GROUPS.save(ussr);
		POSTS.save(new Post(lenin, ussr, "Пролетарии всех стран, соединяйтесь!"));
	}
}
