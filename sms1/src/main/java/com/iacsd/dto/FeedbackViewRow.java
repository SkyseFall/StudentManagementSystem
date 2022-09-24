package com.iacsd.dto;

public class FeedbackViewRow {
	private int feedbackId;
	private int studentId;
	private String studentName;
	private String std;
	private String subjectName;
	private String feedbackRemarks;
	private int feedbackRatings;
	
	public FeedbackViewRow() {
	}

	public FeedbackViewRow(int feedbackId, int studentId, String studentName, String std, String subjectName,
			String feedbackRemarks, int feedbackRatings) {
		this.feedbackId = feedbackId;
		this.studentId = studentId;
		this.studentName = studentName;
		this.std = std;
		this.subjectName = subjectName;
		this.feedbackRemarks = feedbackRemarks;
		this.feedbackRatings = feedbackRatings;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
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

	public int getFeedbackRatings() {
		return feedbackRatings;
	}

	public void setFeedbackRatings(int feedbackRatings) {
		this.feedbackRatings = feedbackRatings;
	}
	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	@Override
	public String toString() {
		return "FeedbackViewRow [feedbackId=" + feedbackId + ", studentId=" + studentId + ", studentName=" + studentName
				+ ", subjectName=" + subjectName + ", feedbackRemarks=" + feedbackRemarks + ", feedbackRatings="
				+ feedbackRatings + "]";
	}
}
