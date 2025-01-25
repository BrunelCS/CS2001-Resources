package com.example.demo.DTO;

import com.example.demo.Models.UserType;

public class UserPostDTO {
	String name;
	String email;
	String password;
	UserType userType;
	
	public UserPostDTO(String name, String email, String password, Boolean buyer, Boolean seller) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.userType = convertType(buyer,seller);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType convertType(Boolean buyer, Boolean seller) {
		if(buyer==false && seller==false)
			return UserType.NONE;
		
		if(buyer==true && seller==false)
			return UserType.BUYER;
		
		if(buyer == false && seller== true)
			return UserType.SELLER;
	
		return UserType.BOTH;
		
		
	}
}
