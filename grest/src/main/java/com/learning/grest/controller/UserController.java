package com.learning.grest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.grest.entity.User;
import com.learning.grest.exception.ResourceNotFoundException;
import com.learning.grest.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	 //get all users
	@GetMapping
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
	// get user by Id
	@GetMapping("/{id}")
	public User getUserById(@PathVariable (value = "id") long userId) {
		return this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found by Id:"+userId));
	}
	//create user
	@PostMapping
	public User createUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}
	//update user
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user,@PathVariable (value = "id") long userId){
		User existingUser =this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found by Id:"+userId));
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		
		return this.userRepository.save(existingUser);
	}
	//delete user
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable (value = "id") long userId){
		User existingUser =this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found by Id:"+userId));
		this.userRepository.delete(existingUser);
		return ResponseEntity.ok().build();
	}
	

}
