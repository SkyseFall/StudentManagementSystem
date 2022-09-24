package com.iacsd.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import com.iacsd.pojos.AssignmentSolution;
import com.iacsd.pojos.TeacherAssignment;

public class AssignmentSolutiondto {
	private int studentId;
	private String subjectCode;
	private int marks;
	private int  assignmentMarks;
	private MultipartFile assignmentSolution;
	private Date submissionTime;
	
	public AssignmentSolutiondto() {
		
	}
	
	
	public AssignmentSolutiondto(int studentId, String subjectCode, int marks, int assignmentMarks,
			MultipartFile assignmentSolution, Date submissionTime) {
		this.studentId = studentId;
		this.subjectCode = subjectCode;
		this.marks = marks;
		this.assignmentMarks = assignmentMarks;
		this.assignmentSolution = assignmentSolution;
		this.submissionTime = submissionTime;
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


	public MultipartFile getAssignmentSolution() {
		return assignmentSolution;
	}


	public void setAssignmentSolution(MultipartFile assignmentSolution) {
		this.assignmentSolution = assignmentSolution;
	}


	public Date getSubmissionTime() {
		return submissionTime;
	}


	public void setSubmissionTime(Date submissionTime) {
		this.submissionTime = submissionTime;
	}


	public static AssignmentSolution toEntity(AssignmentSolutiondto dto) {
		AssignmentSolution t=new AssignmentSolution();
		BeanUtils.copyProperties(dto, t);
		return t;
	}

}
