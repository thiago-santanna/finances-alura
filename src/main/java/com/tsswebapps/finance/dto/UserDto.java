package com.tsswebapps.finance.dto;

import com.tsswebapps.finance.model.User;

public class UserDto {
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDto(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User toUser() {	
		User user = new User();

		
		return user;
	}
}
