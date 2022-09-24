package com.iacsd.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id")
	private int userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	private String mobile;
	
	private String gender;
	
	@Column(name = "acc_status")
	private int accountStatus;
	
//	private boolean accountStatus;
	
	private String username;
	private String email;
	private String password;
	@Column(name = "type_job")
	private String typeJob;
	private String pincode;
	private String locality;
	
	
	public Users() {
	}


	public Users(int userId, String firstName, String lastName, Date dob, String mobile, String gender,
			int accountStatus, String username, String email, String password, String typeJob, String pincode,String locality) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.mobile = mobile;
		this.gender = gender;
		this.accountStatus = accountStatus;
		this.username = username;
		this.email = email;
		this.password = password;
		this.typeJob = typeJob;
		this.pincode = pincode;
		this.locality = locality;
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


	public int getAccountStatus() {
		return accountStatus;
	}


	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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


	public String getTypeJob() {
		return typeJob;
	}


	public void setTypeJob(String typeJob) {
		this.typeJob = typeJob;
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



	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", mobile=" + mobile + ", gender=" + gender + ", accountStatus=" + accountStatus + ", username="
				+ username + ", email=" + email + ", password=" + password + ", typeJob=" + typeJob + ", pincode="
				+ pincode + ", locality=" + locality + "]";
	}
}
