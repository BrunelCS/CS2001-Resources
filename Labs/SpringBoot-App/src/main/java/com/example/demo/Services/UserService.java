package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.User;
import com.example.demo.Repos.UserRepository;
import com.example.demo.Exceptions.ResourceNotFoundException;

@Service
public class UserService {
	@Autowired
    UserRepository userRepository;
	
	public UserService() {
		super();
		// Auto-generated constructor stub
	}
	
	
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}

	public void addUser(User newUser) {
		userRepository.save(newUser);
	}
	
	public Optional<User> findByID(Long id) {
		 return userRepository.findById(id);
	}
	
	public void deleteUser(Long id) {
		User user = userRepository.findById(id)
				  .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		userRepository.delete(user);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
