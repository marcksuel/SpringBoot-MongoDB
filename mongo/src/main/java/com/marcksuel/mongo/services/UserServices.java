package com.marcksuel.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcksuel.mongo.domain.User;
import com.marcksuel.mongo.dto.UserDTO;
import com.marcksuel.mongo.repository.UserRepository;
import com.marcksuel.mongo.services.exception.ObjectNotFoundException;

@Service
public class UserServices {
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	public User fromDTO(UserDTO dto) {
		return new User(dto.getId(),dto.getName(),dto.getEmail());
	}               
	public void delete(String id) {
		findById(id); //verificar se existe caso constrario ja lançar a exception
		userRepository.deleteById(id);
	}
	public User update(User user) {
		User find = findById(user.getId());
		updateData(find, user);
		return userRepository.save(find);
	}

	private void updateData(User find, User user) {
		find.setEmail(user.getEmail());
		find.setName(user.getName());
		
	}
}
