package com.example.demo.Repos;

import com.example.demo.Models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long>{
	User findByEmail(String email);
}
