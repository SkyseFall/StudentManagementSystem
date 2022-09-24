package com.iacsd.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "class")
public class Class {
	@Id
	@Column(name = "class")
	private String std;   // class standard.
	
	@Column(name = "class_rep")
	private int classRep;  // total no of Students
	
	@Column(name = "teacher_rep")
	private int teacherRep;  // total no of Teachers.
	
	@OneToMany(mappedBy = "std")
	private List<Subjects> subjectList;
	
	public Class() {
		this.subjectList = new ArrayList<Subjects>();
	}

	public Class(String std, int classRep, int teacherRep) {
		this.std = std;
		this.classRep = classRep;
		this.teacherRep = teacherRep;
	}
	
	

	public Class(String std, int classRep, int teacherRep, List<Subjects> subjectList) {
		this.std = std;
		this.classRep = classRep;
		this.teacherRep = teacherRep;
		this.subjectList = new ArrayList<Subjects>();
	}

	public List<Subjects> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<Subjects> subjectList) {
		this.subjectList = subjectList;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public int getClassRep() {
		return classRep;
	}

	public void setClassRep(int classRep) {
		this.classRep = classRep;
	}

	public int getTeacherRep() {
		return teacherRep;
	}

	public void setTeacherRep(int teacherRep) {
		this.teacherRep = teacherRep;
	}

	
	
	@Override
	public String toString() {
		return "Class [std=" + std + ", classRep=" + classRep + ", teacherRep=" + teacherRep + ", subjectList="
				+ subjectList + "]";
	}

	public void addSubject(Subjects subject) {
		subjectList.add(subject);
		subject.setStd(this.std);
	}
	
}
