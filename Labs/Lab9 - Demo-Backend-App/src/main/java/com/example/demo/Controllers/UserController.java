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

@RestController

public class UserController {
    @Autowired
	UserService userService;
    
    //Get All Users

    //Post a User
    
    //Get User by ID
    
    //Delete a User by ID
    
    //Get User by Email
   
}
