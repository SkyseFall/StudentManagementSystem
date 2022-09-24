package com.iacsd.dto;

public class StudentAttendanceRow {
	private int studentId;
	private String studentName;
	private String section;
	private String attendanceStatus;
	
	public StudentAttendanceRow() {
	}

	public StudentAttendanceRow(int studentId, String studentName, String section, String attendanceStatus) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.section = section;
		this.attendanceStatus = attendanceStatus;
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

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getAttendanceStatus() {
		return attendanceStatus;
	}

	public void setAttendanceStatus(String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

	@Override
	public String toString() {
		return "StudentAttendanceRow [studentId=" + studentId + ", studentName=" + studentName + ", section=" + section
				+ ", attendanceStatus=" + attendanceStatus + "]";
	}
}
