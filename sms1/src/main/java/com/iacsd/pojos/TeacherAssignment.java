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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "teacher_assignment")
public class TeacherAssignment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "assignment_id")
	private int assignmentId;
	
	@Column(name = "teacher_id")
	private int teacherId;
	
	@Column(name = "added_assignment")
	private String addedAssignment;
	
	@Column(name = "assignment_due")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date assignmentDue;
	
	@Basic(optional = false)
	@Column(name = "submission_time", insertable = false, updatable = false)
	//@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date submissionTime;
	
	@Column(name = "subject_code")
	private String subjectCode;
	
	public TeacherAssignment() {
	}

	public TeacherAssignment(int assignmentId, int teacherId, String addedAssignment, Date assignmentDue,
			Date submissionTime) {
		this.assignmentId = assignmentId;
		this.teacherId = teacherId;
		this.addedAssignment = addedAssignment;
		this.assignmentDue = assignmentDue;
		this.submissionTime = submissionTime;
	}
	
	

	public TeacherAssignment(int assignmentId, int teacherId, String addedAssignment, Date assignmentDue,
			Date submissionTime, String subjectCode) {
		this.assignmentId = assignmentId;
		this.teacherId = teacherId;
		this.addedAssignment = addedAssignment;
		this.assignmentDue = assignmentDue;
		this.submissionTime = submissionTime;
		this.subjectCode = subjectCode;
	}

	public int getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getAddedAssignment() {
		return addedAssignment;
	}

	public void setAddedAssignment(String addedAssignment) {
		this.addedAssignment = addedAssignment;
	}

	public Date getAssignmentDue() {
		return assignmentDue;
	}

	public void setAssignmentDue(Date assignmentDue) {
		this.assignmentDue = assignmentDue;
	}

	public Date getSubmissionTime() {
		return submissionTime;
	}

	public void setSubmissionTime(Date submissionTime) {
		this.submissionTime = submissionTime;
	}
	
	

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	@Override
	public String toString() {
		return "TeacherAssignment [assignmentId=" + assignmentId + ", teacherId=" + teacherId + ", addedAssignment="
				+ addedAssignment + ", assignmentDue=" + assignmentDue + ", submissionTime=" + submissionTime
				+ ", subjectCode=" + subjectCode + "]";
	}
}
