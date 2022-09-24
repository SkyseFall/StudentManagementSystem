package com.iacsd.dto;

public class StudentDetailsWithName {
	private int rollNo;
	private String studentName;
	private int studentId;
	private String std;  // class
	private String section;
	
	public StudentDetailsWithName() {
	}

	public StudentDetailsWithName(int rollNo, String studentName, int studentId, String std, String section) {
		this.rollNo = rollNo;
		this.studentName = studentName;
		this.studentId = studentId;
		this.std = std;
		this.section = section;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
		return "StudentDetailsWithName [rollNo=" + rollNo + ", studentName=" + studentName + ", studentId=" + studentId
				+ ", std=" + std + ", section=" + section + "]";
	}
}
