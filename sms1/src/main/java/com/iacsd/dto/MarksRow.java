package com.iacsd.dto;

import java.util.Date;

public class MarksRow {
	private int studentId;
	private String studentName;
	private int rollNo;
	private String subjectCode;
	private int marks;
	private int maxMarks;
	private int assignmentMarks;
	private int maxAssignmentMarks;
	private String assignmentSolution;
	private String submissionTime;
	private String subjectName;
	
	public MarksRow() {
	}

	public MarksRow(int studentId, String studentName, int rollNo, String subjectCode, int marks, int maxMarks,
			int assignmentMarks, int maxAssignmentMarks) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.rollNo = rollNo;
		this.subjectCode = subjectCode;
		this.marks = marks;
		this.maxMarks = maxMarks;
		this.assignmentMarks = assignmentMarks;
		this.maxAssignmentMarks = maxAssignmentMarks;
	}

	

	public MarksRow(int studentId, String studentName, int rollNo, String subjectCode, int marks, int maxMarks,
			int assignmentMarks, int maxAssignmentMarks, String assignmentSolution, String submissionTime) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.rollNo = rollNo;
		this.subjectCode = subjectCode;
		this.marks = marks;
		this.maxMarks = maxMarks;
		this.assignmentMarks = assignmentMarks;
		this.maxAssignmentMarks = maxAssignmentMarks;
		this.assignmentSolution = assignmentSolution;
		this.submissionTime = submissionTime;
	}
	
	

	public MarksRow(int studentId, String studentName, int rollNo, String subjectCode, int marks, int maxMarks,
			int assignmentMarks, int maxAssignmentMarks, String assignmentSolution, String submissionTime,
			String subjectName) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.rollNo = rollNo;
		this.subjectCode = subjectCode;
		this.marks = marks;
		this.maxMarks = maxMarks;
		this.assignmentMarks = assignmentMarks;
		this.maxAssignmentMarks = maxAssignmentMarks;
		this.assignmentSolution = assignmentSolution;
		this.submissionTime = submissionTime;
		this.subjectName = subjectName;
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

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
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

	public String getAssignmentSolution() {
		return assignmentSolution;
	}

	public void setAssignmentSolution(String assignmentSolution) {
		this.assignmentSolution = assignmentSolution;
	}

	

	public String getSubmissionTime() {
		return submissionTime;
	}

	public void setSubmissionTime(String submissionTime) {
		this.submissionTime = submissionTime;
	}

	
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "MarksRow [studentId=" + studentId + ", studentName=" + studentName + ", rollNo=" + rollNo
				+ ", subjectCode=" + subjectCode + ", marks=" + marks + ", maxMarks=" + maxMarks + ", assignmentMarks="
				+ assignmentMarks + ", maxAssignmentMarks=" + maxAssignmentMarks + "]";
	}
}
