package com.iacsd.pojos;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "marks")
public class Marks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "marksheet_id")
	private int marksheetId;
	
	@Column(name = "student_id")
	private int studentId;
	
	@Column(name = "subject_code")
	private String subjectCode;
	
	private int marks;
	
	@Column(name = "assignment_marks")
	private int assignmentMarks;
	
	@Column(name = "assignment_solution")
	private String assignmentSolution;
	
	@Basic(optional = false)
	@Column(name = "submission_time", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date submissionTime;
	
	public Marks() {
	}

	public Marks(int marksheetId, int studentId, String subjectCode, int marks, int assignmentMarks,
			String assignmentSolution, Date submissionTime) {
		this.marksheetId = marksheetId;
		this.studentId = studentId;
		this.subjectCode = subjectCode;
		this.marks = marks;
		this.assignmentMarks = assignmentMarks;
		this.assignmentSolution = assignmentSolution;
		this.submissionTime = submissionTime;
	}

	public int getMarksheetId() {
		return marksheetId;
	}

	public void setMarksheetId(int marksheetId) {
		this.marksheetId = marksheetId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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

	public int getAssignmentMarks() {
		return assignmentMarks;
	}

	public void setAssignmentMarks(int assignmentMarks) {
		this.assignmentMarks = assignmentMarks;
	}

	public String getAssignmentSolution() {
		return assignmentSolution;
	}

	public void setAssignmentSolution(String assignmentSolution) {
		this.assignmentSolution = assignmentSolution;
	}

	public Date getSubmissionTime() {
		return submissionTime;
	}

	public void setSubmissionTime(Date submissionTime) {
		this.submissionTime = submissionTime;
	}

	@Override
	public String toString() {
		return "Marks [marksheetId=" + marksheetId + ", studentId=" + studentId + ", subjectCode=" + subjectCode
				+ ", marks=" + marks + ", assignmentMarks=" + assignmentMarks + ", assignmentSolution="
				+ assignmentSolution + ", submissionTime=" + submissionTime + "]";
	}
}
