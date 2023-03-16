package com.marcksuel.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcksuel.mongo.domain.Post;
import com.marcksuel.mongo.repository.PostRepository;
import com.marcksuel.mongo.services.exception.ObjectNotFoundException;
@Service
public class PostServices {
	@Autowired
	private PostRepository postRepository;

	
	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	public List<Post> findByTitle(String text){
		return postRepository.findByTitleContainingIgnoreCase(text);
	}
}
