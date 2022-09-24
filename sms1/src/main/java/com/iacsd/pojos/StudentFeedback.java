package com.iacsd.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_feedback")
public class StudentFeedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id")
	private int feedbackId;
	
	@Column(name = "student_id")
	private int studentId;
	
	@Column(name = "teacher_id")
	private int teacherId;
	
	@Column(name = "feedback_remarks")
	private String feedbackRemarks;
	
	@Column(name = "feedback_ratings")
	private int feedbackRatings;
	
	public StudentFeedback() {
	}

	public StudentFeedback(int feedbackId, int studentId, int teacherId, String feedbackRemarks, int feedbackRatings) {
		this.feedbackId = feedbackId;
		this.studentId = studentId;
		this.teacherId = teacherId;
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

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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

	@Override
	public String toString() {
		return "StudentFeedback [feedbackId=" + feedbackId + ", studentId=" + studentId + ", teacherId=" + teacherId
				+ ", feedbackRemarks=" + feedbackRemarks + ", feedbackRatings=" + feedbackRatings + "]";
	}
}
