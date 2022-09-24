package com.iacsd.dto;

public class Subject {

	private String subjectCode;

	private String subjectName;

	private String std;

	private int maxMarks;

	private int maxAssignmentMarks;

	private int teacherId;

	public Subject() {
	}

	public Subject(String subjectCode, String subjectName, String std, int maxMarks, int maxAssignmentMarks) {
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.std = std;
		this.maxMarks = maxMarks;
		this.maxAssignmentMarks = maxAssignmentMarks;
	}
	

	public Subject(String subjectCode, String subjectName, String std, int maxMarks, int maxAssignmentMarks,
			int teacherId) {
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.std = std;
		this.maxMarks = maxMarks;
		this.maxAssignmentMarks = maxAssignmentMarks;
		this.teacherId = teacherId;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public int getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}

	public int getMaxAssignmentMarks() {
		return maxAssignmentMarks;
	}

	public void setMaxAssignmentMarks(int maxAssignmentMarks) {
		this.maxAssignmentMarks = maxAssignmentMarks;
	}
	

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public String toString() {
		return "Subjects [subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", std=" + std + ", maxMarks="
				+ maxMarks + ", maxAssignmentMarks=" + maxAssignmentMarks + ", teacherId=" + teacherId + "]";
	}
}
