package com.marcksuel.mongo.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.marcksuel.mongo.domain.User;

import ch.qos.logback.core.joran.sanity.SanityChecker;

public class UserDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String email;
	
	//Post
	
	//Comment

	public UserDTO() {
	}
	public UserDTO(User user) {
		id=user.getId();
		name=user.getName();
		email=user.getEmail();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
