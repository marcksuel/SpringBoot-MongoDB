package com.marcksuel.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.marcksuel.mongo.domain.Post;

public interface PostRepository  extends MongoRepository<Post,String>{

}
