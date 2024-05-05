package edu.avale1648.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.avale1648.internationale.repositories.GroupRepository;
import edu.avale1648.internationale.repositories.PostRepository;
import edu.avale1648.internationale.repositories.UserRepository;

@Configuration
public class DbLoader {
	private static final Logger LOGGER = LoggerFactory.getLogger(DbLoader.class);
	
	//@Bean
	//CommandLineRunner initDb(UserRepository ur, GroupRepository gr, PostRepository pr) {
		
	//}
}
