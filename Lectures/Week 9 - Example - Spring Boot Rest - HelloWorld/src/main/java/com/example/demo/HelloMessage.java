package com.example.demo;

import org.springframework.stereotype.Component;

//Example component, that serves as a resource
//for this toy example
@Component
public class HelloMessage {
	String helloMessage;

	public HelloMessage() {
		super();
		setDefaultMessage();
	}

	public String getHelloMessage() {
		return helloMessage;
	}

	public void setHelloMessage(String helloMessage) {
		this.helloMessage = helloMessage;
	}
	
	public void setDefaultMessage() {
		helloMessage = "Hello CS2001";
	}
	
}
