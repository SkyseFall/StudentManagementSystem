package com.iacsd.dto;

public class FeedbackRow {
	private int studentId;
	private int teacherId;
	private String teacherName;
	private String subjectName;
	private String feedbackRemarks;
	private int feedBackRatings;
	
	public FeedbackRow() {
	}

	public FeedbackRow(int studentId, int teacherId, String teacherName, String subjectName, String feedbackRemarks,
			int feedBackRatings) {
		this.studentId = studentId;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.subjectName = subjectName;
		this.feedbackRemarks = feedbackRemarks;
		this.feedBackRatings = feedBackRatings;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getFeedbackRemarks() {
		return feedbackRemarks;
	}

	public void setFeedbackRemarks(String feedbackRemarks) {
		this.feedbackRemarks = feedbackRemarks;
	}

	public int getFeedBackRatings() {
		return feedBackRatings;
	}

	public void setFeedBackRatings(int feedBackRatings) {
		this.feedBackRatings = feedBackRatings;
	}

	@Override
	public String toString() {
		return "FeedbackRow [studentId=" + studentId + ", teacherId=" + teacherId + ", teacherName=" + teacherName
				+ ", subjectName=" + subjectName + ", feedbackRemarks=" + feedbackRemarks + ", feedBackRatings="
				+ feedBackRatings + "]";
	}
}
