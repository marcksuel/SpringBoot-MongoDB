package com.marcksuel.mongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marcksuel.mongo.domain.Post;
import com.marcksuel.mongo.domain.User;
import com.marcksuel.mongo.repository.PostRepository;
import com.marcksuel.mongo.repository.UserRepository;
@Configuration
public class Instantion implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");	
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		sdf.setTimeZone( TimeZone.getTimeZone("GMT"));
		
		Post p1= new Post(null, sdf.parse("15/03/2023 19:22"), "Estudando Java", "Vamo que vamo", u1);
		Post p2= new Post(null, sdf.parse("14/03/2023 15:22"), "Spring Boot", "Partiu programar muito hoje", u1);		
		Post p3= new Post(null, sdf.parse("15/02/2023 19:22"), "Carnaval pra que?", "Tranquilo no pc", u2);
		postRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
	}

}
