package com.iacsd.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class ScheduleModel {
	String subjectTeacher;
	String std;
	private String startTime;
	@Temporal(TemporalType.TIME)
	private String endTime;
	
	public ScheduleModel() {
	}

	public ScheduleModel(String subjectTeacher, String std, String startTime, String endTime) {
		this.subjectTeacher = subjectTeacher;
		this.std = std;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getSubjectTeacher() {
		return subjectTeacher;
	}

	public void setSubjectTeacher(String subjectTeacher) {
		this.subjectTeacher = subjectTeacher;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "ScheduleModel [subjectTeacher=" + subjectTeacher + ", std=" + std + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
}
