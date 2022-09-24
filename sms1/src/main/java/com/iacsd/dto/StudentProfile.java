package com.iacsd.dto;

import java.util.Date;

public class StudentProfile {
	private int userId;
	private String firstName;
	private String lastName;
	private Date dob;
	private String mobile;
	private String gender;
	private String username;
	private String pincode;
	private String locality;
	private String std;
	private String section;
	private String typeJob;
	
	public StudentProfile() {
	}

	

	public StudentProfile(int userId, String firstName, String lastName, Date dob, String mobile, String gender,
			String username, String pincode, String locality, String std, String section, String typeJob) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.mobile = mobile;
		this.gender = gender;
		this.username = username;
		this.pincode = pincode;
		this.locality = locality;
		this.std = std;
		this.section = section;
		this.typeJob = typeJob;
	}



	public String getTypeJob() {
		return typeJob;
	}



	public void setTypeJob(String typeJob) {
		this.typeJob = typeJob;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return "StudentProfile [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob="
				+ dob + ", mobile=" + mobile + ", gender=" + gender + ", username=" + username + ", pincode=" + pincode
				+ ", locality=" + locality + ", std=" + std + ", section=" + section + "]";
	}
}
