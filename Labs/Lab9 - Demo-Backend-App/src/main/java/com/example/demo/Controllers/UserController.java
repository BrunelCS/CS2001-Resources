package com.example.demo.Controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.UserPostDTO;
import com.example.demo.Models.User;
import com.example.demo.Services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
	UserService userService;
    
    //Get All Users
    @GetMapping
	public List<User> getUsers(){
        return userService.getUsers();
	}

    //Post a User
    @PostMapping
    public UserPostDTO postUser(@RequestBody UserPostDTO newUser){
        return newUser;
    }
    
    //Get User by ID
    @GetMapping("/{id}")
	public Optional<User> getUserByID(@PathVariable(value = "id") Long id) {
		return userService.findByID(id);	
	}
    
    //Delete a User by ID
    //Untested cuz post user don't work
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id){
        userService.deleteUser(id);
        return ("User Deleted");
    }
    
    //Get User by Email
    @GetMapping("/findByEmail")
    public User getUserByEmail(@RequestParam String email) {
		return userService.findByEmail(email);	
	}
}
