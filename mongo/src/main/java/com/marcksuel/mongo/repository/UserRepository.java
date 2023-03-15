package com.marcksuel.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marcksuel.mongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

}
