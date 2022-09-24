package com.iacsd.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "student_attendance")
public class StudentAttendance {
	@Id
	@Column(name = "date_of_attendance")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfAttendance;
	
	@Column(name = "student_id")
	private int studentId;
	
	@Column(name = "attendance_status")
	private String attendanceStatus;
	
	public StudentAttendance() {
	}

	public StudentAttendance(Date dateOfAttendance, int studentId, String attendanceStatus) {
		this.dateOfAttendance = dateOfAttendance;
		this.studentId = studentId;
		this.attendanceStatus = attendanceStatus;
	}

	public Date getDateOfAttendance() {
		return dateOfAttendance;
	}

	public void setDateOfAttendance(Date dateOfAttendance) {
		this.dateOfAttendance = dateOfAttendance;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getAttendanceStatus() {
		return attendanceStatus;
	}

	public void setAttendanceStatus(String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

	@Override
	public String toString() {
		return "StudentAttendance [dateOfAttendance=" + dateOfAttendance + ", studentId=" + studentId
				+ ", attendanceStatus=" + attendanceStatus + "]";
	}
}
