package com.project.dto;

public class AdminDTO {
	
	private String username;
	private String password;
	
	
	public AdminDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AdminDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public AdminDTO(String username) {
		super();
		this.username = username;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	}
	


