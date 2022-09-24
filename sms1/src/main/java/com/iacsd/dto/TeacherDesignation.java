package com.iacsd.dto;

public class TeacherDesignation {
	private int teacherId;
	private String teacherName;
	private String email;
	private String mobile;
	private String designation;
	
	public TeacherDesignation() {
	}

	public TeacherDesignation(int teacherId, String teacherName, String email, String mobile, String designation) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.email = email;
		this.mobile = mobile;
		this.designation = designation;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "TeacherDesignation [teacherId=" + teacherId + ", teacherName=" + teacherName + ", email=" + email
				+ ", mobile=" + mobile + ", designation=" + designation + "]";
	}
}
