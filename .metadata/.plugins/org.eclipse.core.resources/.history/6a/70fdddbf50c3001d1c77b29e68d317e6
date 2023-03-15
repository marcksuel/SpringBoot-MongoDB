package com.marcksuel.mongo.resources;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcksuel.mongo.domain.User;
import com.marcksuel.mongo.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserServices service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	
}
