package com.marcksuel.mongo.services.exception;

public class ObjectNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String e) {
		super(e);
	}
}
