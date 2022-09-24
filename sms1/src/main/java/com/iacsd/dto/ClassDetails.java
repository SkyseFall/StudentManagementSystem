package com.iacsd.dto;

public class ClassDetails {
	private String std;
	private String classRep;
	private String teacherRep;
	
	public ClassDetails() {
	}

	public ClassDetails(String std, String classRep, String teacherRep) {
		this.std = std;
		this.classRep = classRep;
		this.teacherRep = teacherRep;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getClassRep() {
		return classRep;
	}

	public void setClassRep(String classRep) {
		this.classRep = classRep;
	}

	public String getTeacherRep() {
		return teacherRep;
	}

	public void setTeacherRep(String teacherRep) {
		this.teacherRep = teacherRep;
	}

	@Override
	public String toString() {
		return "ClassDetails [std=" + std + ", classRep=" + classRep + ", teacherRep=" + teacherRep + "]";
	}
}
