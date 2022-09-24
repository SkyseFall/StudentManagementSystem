package com.iacsd.dto;

public class AccountDetails {
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private String typeJob;
	
	public AccountDetails() {
	}

	public AccountDetails(String firstName, String lastName, String mobile, String email, String typeJob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.typeJob = typeJob;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTypeJob() {
		return typeJob;
	}

	public void setTypeJob(String typeJob) {
		this.typeJob = typeJob;
	}

	@Override
	public String toString() {
		return "AccountDetails [firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile + ", email="
				+ email + ", typeJob=" + typeJob + "]";
	}
	
	
}
