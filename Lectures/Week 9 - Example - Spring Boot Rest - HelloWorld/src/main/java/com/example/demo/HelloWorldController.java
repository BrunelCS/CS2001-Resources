package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.HelloMessage;

//HelloWorld Controller is a REST controller, which responds to
//any request under http://localhost:8080/hello
@RestController  
@RequestMapping("/hello")
public class HelloWorldController {
	
	@Autowired
	HelloMessage helloMessage;
	

	public HelloWorldController() {
		super();
		
	}
	
	//Responds to GET
	//Prints out a message with all request parameters
	////Example: GET http://localhost:8080/hello?name=Alex
	/// Returns- Hello CS2001 [name=Alex]
	@GetMapping
	public String helloWithRequestParam(@RequestParam Map<String,String> allParams){
		return (String.format("%s %s\n", helloMessage.getHelloMessage(),allParams.entrySet()));
	}
	
	//Respond to GET when the path is variable: http://localhost:8080/hello/{id}
	//Example: GET http://localhost:8080/hello/1
	//Returns - Hello CS2001 - your id is 1
	@GetMapping("/{id}")
	public String helloWithID(@PathVariable(value = "id") Long helloId) {
		return (String.format("%s - your id is %d\n",helloMessage.getHelloMessage(),helloId));	
	}
	
	//Responds to PUT, where the hello message is changed
	//Different than lecture; chose put as it doesn't create a new resource
	//You can add set a new message in the Body of a PUT request as JSON
	//Example: {"helloMessage": "New Hello Message"}
	//Returns - Saved New Hello Message as newMessage
	@PutMapping
    public String createMessage(@RequestBody HelloMessage newMessage) {
		helloMessage.setHelloMessage(newMessage.getHelloMessage());
        return (String.format("Saved %s as newMessage\n",helloMessage.getHelloMessage()));
    }
	
	//Responds to DELETE
	//Note that semantics are different as it doesn't delete a resource, but goes
	//back to default message, which is acceptable for toy example
	//Prints out the default message
	@DeleteMapping
	public String deleteMessage() {
		helloMessage.setDefaultMessage();
		return (String.format("Went back to default: %s\n",helloMessage.getHelloMessage()));
	}
	
	
	
}
