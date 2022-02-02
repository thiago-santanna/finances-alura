package com.tsswebapps.finance.dto;

public class UserDto {
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public UserDto(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
}
