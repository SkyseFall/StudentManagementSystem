package com.iacsd.dto;


import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.iacsd.pojos.TeacherAssignment;

public class TeacherAssignmentdto {
private int  teacher_id;
private MultipartFile added_assignment;
@DateTimeFormat(pattern = "yyyy-MM-dd")
@Temporal(TemporalType.DATE)
private Date assignment_due;
private String subject_code;

public TeacherAssignmentdto() {
}

public TeacherAssignmentdto(int teacher_id, MultipartFile added_assignment, Date assignment_due, String subject_code) {
	this.teacher_id = teacher_id;
	this.added_assignment = added_assignment;
	this.assignment_due = assignment_due;
	this.subject_code = subject_code;
}

public int getTeacher_id() {
	return teacher_id;
}

public void setTeacher_id(int teacher_id) {
	this.teacher_id = teacher_id;
}

public MultipartFile getAdded_assignment() {
	return added_assignment;
}

public void setAdded_assignment(MultipartFile added_assignment) {
	this.added_assignment = added_assignment;
}

public Date getAssignment_due() {
	return assignment_due;
}

public void setAssignment_due(Date assignment_due) {
	this.assignment_due = assignment_due;
}

public String getSubject_code() {
	return subject_code;
}

public void setSubject_code(String subject_code) {
	this.subject_code = subject_code;
}

@Override
public String toString() {
	return "TeacherAssignment [teacher_id=" + teacher_id + ", added_assignment=" + added_assignment
			+ ", assignment_due=" + assignment_due + ", subject_code=" + subject_code + "]";
}

public static TeacherAssignment toEntity(TeacherAssignmentdto dto) {
	TeacherAssignment t=new TeacherAssignment();
	BeanUtils.copyProperties(dto, t);
	return t;
}

}

