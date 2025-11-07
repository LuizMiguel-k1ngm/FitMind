package com.fitmind.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitmind.entity.User;
import com.fitmind.service.UserService;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserResource {
	private UserService servico;

	public UserResource(UserService servico) {
		this.servico = servico;
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findbyId(@PathVariable Long id){
		User u = servico.findById(id);
		return ResponseEntity.ok().body(u);
	}
	
	
	
	@PostMapping(value = "/create")
	public ResponseEntity<User> add(@RequestBody User u){

		User newUser = servico.add(u);
		
		return ResponseEntity.ok().body(newUser);
		
		
	}
	
	@DeleteMapping(value = "/{userId}/delete")
	public ResponseEntity<Void> delete(@PathVariable Long userId){
		
		servico.delete(userId);
		return ResponseEntity.noContent().build();
	}
	

	
	
	

}
