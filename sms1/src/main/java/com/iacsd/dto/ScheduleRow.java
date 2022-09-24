package com.iacsd.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ScheduleRow {
	private String tName;
	private String std;
	private String subjectName;
	private Date startTime;
	private Date endTime;
	private int sessionId;
	
	public ScheduleRow() {
	}

	public ScheduleRow(String tName, String std, String subjectName, Date startTime, Date endTime) {
		this.tName = tName;
		this.std = std;
		this.subjectName = subjectName;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	

	public ScheduleRow(String tName, String std, String subjectName, Date startTime, Date endTime, int sessionId) {
		this.tName = tName;
		this.std = std;
		this.subjectName = subjectName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.sessionId = sessionId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "ScheduleRow [tName=" + tName + ", std=" + std + ", subjectName=" + subjectName + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}
	
}
