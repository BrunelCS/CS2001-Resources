package com.example.demo.Security;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginFilter  extends AbstractAuthenticationProcessingFilter {

	  public LoginFilter(String url, AuthenticationManager authManager) {
	    super(new AntPathRequestMatcher(url));
	    this.setAuthenticationManager(authManager);
	  }

	  @Override
	  public Authentication attemptAuthentication(
	  HttpServletRequest req, HttpServletResponse res)
	      throws AuthenticationException, IOException, ServletException {
	  AccountCredentials creds = new ObjectMapper()
	        .readValue(req.getInputStream(), AccountCredentials.class);
	   
	  return this.getAuthenticationManager().authenticate(
	        new UsernamePasswordAuthenticationToken(
	            creds.getUsername(),
	            creds.getPassword()
	        )
	    );
	  }

	  @Override
	  protected void successfulAuthentication(
	      HttpServletRequest req,
	      HttpServletResponse res, FilterChain chain,
	      Authentication auth) throws IOException, ServletException {
	    JWTService.addToken(res, auth.getName());
	  }
	}