package com.example.demo.Controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.UserService;
import com.example.demo.DTO.UserPostDTO;
import com.example.demo.Models.User;
import com.example.demo.Models.UserType;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController

public class UserController {
    @Autowired
	UserService userService;
    
    // Get All Users
    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    //Post a User
    @PostMapping("/user")
    public ResponseEntity<Optional<User>> addUser(@RequestBody UserPostDTO newUserDTO) {
    	
    	if (newUserDTO.getName()==null || 
    		newUserDTO.getEmail()==null ||
    		newUserDTO.getPassword()==null ||
    		newUserDTO.getUserType() == UserType.NONE) {
            return new ResponseEntity<>(Optional.ofNullable(null), HttpStatus.BAD_REQUEST);
        }
    	
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    	User newUser = new User(newUserDTO.getName(), newUserDTO.getEmail(),
        encoder.encode(newUserDTO.getPassword()), newUserDTO.getUserType());
    	userService.addUser(newUser);
    	return new ResponseEntity<>(Optional.ofNullable(newUser),HttpStatus.CREATED);

    }
    
    //Get User by ID
    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable(value = "id") long Id) {
        return userService.findByID(Id);
    }
    
    
    //Delete a User by ID
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable(value = "id") long Id) {
        userService.deleteUser(Id);
        return "User Deleted"; 
    }
    
    //Get User by Email
    @GetMapping("/user/findByEmail")
    public Optional<User> getUserByEmail(@RequestParam String email) {
    	return Optional.ofNullable(userService.findByEmail(email));
    }

    //Get the details for the currently logged in user
	@GetMapping("/user/getDetails")
	public Optional<User> geLoggedInUserDetails() {
		return Optional.ofNullable(userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
	}

   
}
