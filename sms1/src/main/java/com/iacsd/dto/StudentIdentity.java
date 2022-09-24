package com.iacsd.dto;

public class StudentIdentity {
	private int studentId;
	private String sName;
	
	public StudentIdentity() {
	}

	public StudentIdentity(int studentId, String sName) {
		this.studentId = studentId;
		this.sName = sName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	@Override
	public String toString() {
		return "StudentIdentity [studentId=" + studentId + ", sName=" + sName + "]";
	}
	
}
