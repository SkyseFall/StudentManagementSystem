package com.iacsd.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "schedule")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "session_id")
	private int sessionId;
	
	@Column(name = "teacher_id")
	private int teacherId;
	
	@Column(name = "class")
	private String std;
	
	@Column(name = "subject_code")
	private String subjectCode;
	
	@Column(name = "start_time")
	@DateTimeFormat(pattern = "hh:mm:ss")
	@Temporal(TemporalType.TIME)
	private Date startTime;
	
	@Column(name = "end_time")
	@DateTimeFormat(pattern = "hh:mm:ss")
	@Temporal(TemporalType.TIME)
	private Date endTime;
	
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Schedule() {
	}

	public Schedule(int sessionId, int teacherId, String std, String subjectCode, Date startTime, Date endTime) {
		this.sessionId = sessionId;
		this.teacherId = teacherId;
		this.std = std;
		this.subjectCode = subjectCode;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "Schedule [sessionId=" + sessionId + ", teacherId=" + teacherId + ", std=" + std + ", subjectCode="
				+ subjectCode + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}	
}
