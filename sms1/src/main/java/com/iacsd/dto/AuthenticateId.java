package com.iacsd.dto;

import java.util.Date;

public class AuthenticateId {
	int userId;
	String email;
	Date dob;
	
	public AuthenticateId() {
	}
	

	public AuthenticateId(int userId, String email, Date dob) {
		this.userId = userId;
		this.email = email;
		this.dob = dob;
	}

	
	public AuthenticateId(String email, Date dob) {
		this.email = email;
		this.dob = dob;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	@Override
	public String toString() {
		return "AuthenticateId [userId=" + userId + ", email=" + email + ", dob=" + dob + "]";
	}
}
