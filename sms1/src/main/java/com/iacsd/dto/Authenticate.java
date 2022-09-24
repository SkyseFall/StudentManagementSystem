package com.iacsd.dto;

public class Authenticate {
	public int userId;
	public String email;
	public String password;
	
	public Authenticate() {
	}

	public Authenticate(String email, String password) {
		this.email = email;
		this.password = password;
	}
	

	public Authenticate(int userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public Authenticate(int userId, String email, String password) {
		this.userId = userId;
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Authenticate [email=" + email + ", password=" + password + "]";
	}

}
