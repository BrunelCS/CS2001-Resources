package com.example.demo.Security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Models.User;
import com.example.demo.Repos.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    { 
      User currentUser = repository.findByEmail(email);
      
      if (currentUser!=null) {
    	  System.out.println(currentUser.getEmail());
      
    	  List<GrantedAuthority> authorities = new ArrayList<>();
    	  authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    	 
    	  UserDetails user = new org.springframework.security.core
              .userdetails.User(email, currentUser.getPassword()
              , true, true, true, true, 
              authorities);
          return user;
      }else {
    	  throw new UsernameNotFoundException("User not authorized.");
      }
    }
    
}