package com.iacsd.dto;

public class TeacherAttendanceRow {
	private int teacherId;
	private String teacherName;
	private String designation;
	
	public TeacherAttendanceRow() {
	}

	public TeacherAttendanceRow(int teacherId, String teacherName, String designation) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.designation = designation;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "TeacherAttendanceRow [teacherId=" + teacherId + ", teacherName=" + teacherName + ", designation="
				+ designation + "]";
	}
}
