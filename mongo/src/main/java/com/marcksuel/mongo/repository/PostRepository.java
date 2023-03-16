package com.marcksuel.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.marcksuel.mongo.domain.Post;

public interface PostRepository  extends MongoRepository<Post,String>{
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
