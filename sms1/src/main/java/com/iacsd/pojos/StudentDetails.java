package com.iacsd.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student_details")
public class StudentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roll_no")
	private int rollNo;
	
	@Column(name = "student_id")
	private int studentId;
	
	@Column(name = "class")
	private String std;
	
	private String section;
	private int fees;
	
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "student_subjects",
	joinColumns = {@JoinColumn(name = "student_id")},  // current table class.
	inverseJoinColumns = {@JoinColumn(name = "subject_code")})   // primary key of another table class.
	private List<Subjects> subjectList;
	
	
	public StudentDetails() {
		subjectList = new ArrayList<Subjects>();
	}

	

	public int getFees() {
		return fees;
	}



	public void setFees(int fees) {
		this.fees = fees;
	}



	public StudentDetails(int rollNo, int studentId, String std, String section, int fees) {
		this.rollNo = rollNo;
		this.studentId = studentId;
		this.std = std;
		this.section = section;
		this.fees = fees;
		subjectList = new ArrayList<Subjects>();
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
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


	public List<Subjects> getSubjectList() {
		return subjectList;
	}



	public void setSubjectList(List<Subjects> subjectList) {
		this.subjectList = subjectList;
	}

	
	public void addSubject(Subjects s) {
		this.subjectList.add(s);
		s.getStudentDetailsList().add(this);
	}
	
	

	@Override
	public String toString() {
		return "StudentDetails [rollNo=" + rollNo + ", studentId=" + studentId + ", std=" + std + ", section=" + section
				+ ", fees=" + fees + "]";
	}



	public void removeAll() {
		this.subjectList.clear();
		
	}
	
		
}
