package com.iacsd.dto;

public class FeeRecordRow {
	private int studentId;
	private String studentName;
	private String std;
	private String Mobile;
	private String email;
	private String gender;
	private int fees;
	
	public FeeRecordRow() {
	}

	public FeeRecordRow(int studentId, String studentName, String std, String mobile, String email, String gender,
			int fees) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.std = std;
		Mobile = mobile;
		this.email = email;
		this.gender = gender;
		this.fees = fees;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "FeeRecordRow [studentId=" + studentId + ", studentName=" + studentName + ", std=" + std + ", Mobile="
				+ Mobile + ", email=" + email + ", gender=" + gender + ", fees=" + fees + "]";
	}
}
