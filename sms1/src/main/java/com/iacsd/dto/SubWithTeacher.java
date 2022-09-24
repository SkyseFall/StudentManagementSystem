package com.iacsd.dto;

public class SubWithTeacher {
	private String subjectCode;
	private String subjectName;
	private String std;
	private String tName;
	
	public SubWithTeacher() {
	}

	public SubWithTeacher(String subjectCode, String subjectName, String std, String tName) {
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.std = std;
		this.tName = tName;
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

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	@Override
	public String toString() {
		return "SubWithTeacher [subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", std=" + std
				+ ", tName=" + tName + "]";
	}
}
