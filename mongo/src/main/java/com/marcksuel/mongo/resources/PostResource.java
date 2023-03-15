package com.marcksuel.mongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcksuel.mongo.domain.Post;
import com.marcksuel.mongo.services.PostServices;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	@Autowired	
	private PostServices service;
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}

}
