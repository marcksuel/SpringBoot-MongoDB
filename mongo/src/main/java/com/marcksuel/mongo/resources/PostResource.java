package com.marcksuel.mongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcksuel.mongo.domain.Post;
import com.marcksuel.mongo.resources.util.URL;
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
	
	@RequestMapping(value = "/fullsearch" , method = RequestMethod.GET)
	public ResponseEntity<List<Post>> fullsearch(
			@RequestParam(value="text", defaultValue = "") String text,
			@RequestParam(value="minDate", defaultValue = "") String minDate,
			@RequestParam(value="maxDate", defaultValue = "") String maxDate
			)
		{
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		text = URL.decodeParam(text);
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}	
	
	@RequestMapping(value = "/titlesearch" , method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text){
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}	

}
