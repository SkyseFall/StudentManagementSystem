package com.iacsd.dto;

import java.util.Date;

public class Marksheet {
	private int userId;
	private String studentName;
	private String std;
	private String section;
	private int rollNo;
	private Date dob;
	private String gender;
	private String overallStatus;
	private int maxTotal;
	private int total;
	private float percentage;
	
	public Marksheet() {
	}

	public Marksheet(int userId, String studentName, String std, String section, int rollNo, Date dob, String gender,
			String overallStatus, int maxTotal, int total, float percentage) {
		this.userId = userId;
		this.studentName = studentName;
		this.std = std;
		this.section = section;
		this.rollNo = rollNo;
		this.dob = dob;
		this.gender = gender;
		this.overallStatus = overallStatus;
		this.maxTotal = maxTotal;
		this.total = total;
		this.percentage = percentage;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOverallStatus() {
		return overallStatus;
	}

	public void setOverallStatus(String overallStatus) {
		this.overallStatus = overallStatus;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}



	public int getRollNo() {
		return rollNo;
	}



	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	


	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Marksheet [userId=" + userId + ", studentName=" + studentName + ", std=" + std + ", section=" + section
				+ ", rollNo=" + rollNo + ", dob=" + dob + ", gender=" + gender + ", overallStatus=" + overallStatus
				+ ", maxTotal=" + maxTotal + ", total=" + total + ", percentage=" + percentage + "]";
	}

}
