package com.iacsd.dto;

public class TeacherAssignmentRow {
	private String std;
	private String subjectName;
	private String subjectCode;
	private String addedAssignment;
	private String assignmentDue;
	private String submissionTime;
	private int assignmentId;
	private int studentId;
	
	public TeacherAssignmentRow() {
	}

	public TeacherAssignmentRow(String std, String subjectName, String subjectCode, String addedAssignment,
			String assignmentDue, String submissionTime, int assignmentId, int studentId) {
		this.std = std;
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.addedAssignment = addedAssignment;
		this.assignmentDue = assignmentDue;
		this.submissionTime = submissionTime;
		this.assignmentId = assignmentId;
		this.studentId = studentId;
	}


	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getAddedAssignment() {
		return addedAssignment;
	}

	public void setAddedAssignment(String addedAssignment) {
		this.addedAssignment = addedAssignment;
	}

	public String getAssignmentDue() {
		return assignmentDue;
	}

	public void setAssignmentDue(String assignmentDue) {
		this.assignmentDue = assignmentDue;
	}

	public String getSubmissionTime() {
		return submissionTime;
	}


	public void setSubmissionTime(String submissionTime) {
		this.submissionTime = submissionTime;
	}

	

	public int getAssignmentId() {
		return assignmentId;
	}


	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}

	


	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "TeacherAssignmentRow [std=" + std + ", subjectName=" + subjectName + ", subjectCode=" + subjectCode
				+ ", addedAssignment=" + addedAssignment + ", assignmentDue=" + assignmentDue + ", submissionTime="
				+ submissionTime + ", assignmentId=" + assignmentId + ", studentId=" + studentId + "]";
	}
}
