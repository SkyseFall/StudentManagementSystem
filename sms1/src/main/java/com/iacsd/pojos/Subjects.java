package com.iacsd.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "subjects")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","studentDetailsList"})
public class Subjects {
	@Id
	@Column(name = "subject_code")
	private String subjectCode;
	
	@Column(name = "subject_name")
	private String subjectName;
	
	@Column(name = "class")
	private String std;
	
	@Column(name = "max_marks")
	private int maxMarks;
	
	@Column(name = "max_assignment_marks")
	private int maxAssignmentMarks;
	
	@Column(name = "teacher_id")
	private int teacherId;
	
	@ManyToMany(mappedBy = "subjectList",cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	List<StudentDetails> studentDetailsList;
	
	
	
	
	public Subjects() {
		studentDetailsList = new ArrayList<StudentDetails>();
	}

	public Subjects(String subjectCode, String subjectName, String std, int maxMarks, int maxAssignmentMarks) {
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.std = std;
		this.maxMarks = maxMarks;
		this.maxAssignmentMarks = maxAssignmentMarks;
		studentDetailsList = new ArrayList<StudentDetails>();
	}
	

	public Subjects(String subjectCode, String subjectName, String std, int maxMarks, int maxAssignmentMarks,
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
	
	public List<StudentDetails> getStudentDetailsList() {
		return studentDetailsList;
	}

	public void setStudentDetailsList(List<StudentDetails> studentDetailsList) {
		this.studentDetailsList = studentDetailsList;
	}
	
	public void addStudentDetails(StudentDetails sd) {
		this.studentDetailsList.add(sd);
		sd.getSubjectList().add(this);
	}

	@Override
	public String toString() {
		return "Subjects [subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", std=" + std + ", maxMarks="
				+ maxMarks + ", maxAssignmentMarks=" + maxAssignmentMarks + ", teacherId=" + teacherId
				+ ", studentDetailsList=" + studentDetailsList + "]";
	}

	

	
}
