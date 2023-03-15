package com.marcksuel.mongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcksuel.mongo.domain.User;
import com.marcksuel.mongo.dto.UserDTO;
import com.marcksuel.mongo.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserServices service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity <List<UserDTO>> findAll(){
		List<User> x = service.findAll();
		List<UserDTO> list = x.stream().map(y -> new UserDTO(y)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User user= service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO userdto){
		User user=  service.fromDTO(userdto);
		user = service.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build(); // codigo 201 do create + localização do novo recurso
	}
	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody String id){
		service.delete(id);
		return ResponseEntity.noContent().build(); //quando é uma resposta e não tem que retornar nada, a resposta deve ser codigo 204
	}
	@RequestMapping(value = "/{id}" , method = RequestMethod.POST)
	public ResponseEntity<Void> update(@RequestBody UserDTO userdto, @PathVariable String id){
		User user=  service.fromDTO(userdto);
		user.setId(id);
		user = service.update(user);
		return ResponseEntity.noContent().build(); //quando é uma resposta e não tem que retornar nada, a resposta deve ser codigo 204
	}
}
