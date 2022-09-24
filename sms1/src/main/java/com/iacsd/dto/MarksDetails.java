package com.iacsd.dto;

public class MarksDetails {
	private int marksheetId;
	private String subjectCode;
	private String subjectName;
	private int marks;
	private int maxMarks;
	private int assignmentMarks;
	private int maxAssignmentMarks;
	private String status;
	
	public MarksDetails() {
	}

	public MarksDetails(int marksheetId, String subjectCode, String subjectName, int marks, int maxMarks,
			int assignmentMarks, int maxAssignmentMarks) {
		this.marksheetId = marksheetId;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.marks = marks;
		this.maxMarks = maxMarks;
		this.assignmentMarks = assignmentMarks;
		this.maxAssignmentMarks = maxAssignmentMarks;
	}
	

	public MarksDetails(int marksheetId, String subjectCode, String subjectName, int marks, int maxMarks,
			int assignmentMarks, int maxAssignmentMarks, String status) {
		this.marksheetId = marksheetId;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.marks = marks;
		this.maxMarks = maxMarks;
		this.assignmentMarks = assignmentMarks;
		this.maxAssignmentMarks = maxAssignmentMarks;
		this.status = status;
	}
	
	

	public int getMarksheetId() {
		return marksheetId;
	}

	public void setMarksheetId(int marksheetId) {
		this.marksheetId = marksheetId;
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

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}

	public int getAssignmentMarks() {
		return assignmentMarks;
	}

	public void setAssignmentMarks(int assignmentMarks) {
		this.assignmentMarks = assignmentMarks;
	}

	public int getMaxAssignmentMarks() {
		return maxAssignmentMarks;
	}

	public void setMaxAssignmentMarks(int maxAssignmentMarks) {
		this.maxAssignmentMarks = maxAssignmentMarks;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MarksDetails [marksheetId=" + marksheetId + ", subjectCode=" + subjectCode + ", subjectName="
				+ subjectName + ", marks=" + marks + ", maxMarks=" + maxMarks + ", assignmentMarks=" + assignmentMarks
				+ ", maxAssignmentMarks=" + maxAssignmentMarks + ", status=" + status + "]";
	}

	
}
