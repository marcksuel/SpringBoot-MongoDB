package com.marcksuel.mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcksuel.mongo.domain.User;
import com.marcksuel.mongo.repository.UserRepository;

@Service
public class UserServices {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
}
