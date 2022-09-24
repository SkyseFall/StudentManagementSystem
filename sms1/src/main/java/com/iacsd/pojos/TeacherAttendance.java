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
@Table(name = "teacher_attendance")
public class TeacherAttendance {
	@Id
	@Column(name = "date_of_attendance")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfAttendance;
	
	@Column(name = "teacher_id")
	private int teacherId;
	
	@Column(name = "attendance_status")
	private String attendanceStatus;
	
	public TeacherAttendance() {
	}

	public TeacherAttendance(Date dateOfAttendance, int teacherId, String attendanceStatus) {
		this.dateOfAttendance = dateOfAttendance;
		this.teacherId = teacherId;
		this.attendanceStatus = attendanceStatus;
	}

	public Date getDateOfAttendance() {
		return dateOfAttendance;
	}

	public void setDateOfAttendance(Date dateOfAttendance) {
		this.dateOfAttendance = dateOfAttendance;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getAttendanceStatus() {
		return attendanceStatus;
	}

	public void setAttendanceStatus(String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

	@Override
	public String toString() {
		return "TeacherAttendance [dateOfAttendance=" + dateOfAttendance + ", teacherId=" + teacherId
				+ ", attendanceStatus=" + attendanceStatus + "]";
	}
	

}
