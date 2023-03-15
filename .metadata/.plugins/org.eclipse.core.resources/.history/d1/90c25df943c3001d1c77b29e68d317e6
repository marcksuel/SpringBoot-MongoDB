package com.marcksuel.mongo.resources;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcksuel.mongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	 
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity <List<User>> findAll(){
		List<User> list = new ArrayList<User>();

		//user para teste
		User u1 = new User("1","Max","max@gmail.com");
		User u2 = new User("2","ax","ax@gmail.com");
		User u3 = new User("3","x","x@gmail.com");
		
		list.addAll(Arrays.asList(u1,u2,u3));
		
		return ResponseEntity.ok().body(list);
	}
	
	
}
