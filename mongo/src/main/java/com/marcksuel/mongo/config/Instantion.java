package com.marcksuel.mongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marcksuel.mongo.domain.User;
import com.marcksuel.mongo.repository.UserRepository;
@Configuration
public class Instantion implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");	
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
	}

}