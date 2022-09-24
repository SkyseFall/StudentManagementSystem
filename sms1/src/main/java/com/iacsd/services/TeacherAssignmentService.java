package com.iacsd.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.iacsd.dto.TeacherAssignmentRow;
import com.iacsd.pojos.Subjects;
import com.iacsd.pojos.TeacherAssignment;

public interface TeacherAssignmentService {

	public TeacherAssignment saveNewMenu(TeacherAssignment menu, MultipartFile added_assignment);
	TeacherAssignment findByAssignmentId(int assignmentid);
	TeacherAssignment save(TeacherAssignment teacherAssignment);
	public List<TeacherAssignmentRow> getAssignmentList(List<TeacherAssignment> list);
	List<TeacherAssignment> findByTeacherId(int id);
	public List<TeacherAssignmentRow> fetchAssignmentListBySubjects(List<Subjects> subjects);
	List<TeacherAssignment> findBySubjectCode(String subjectCode);
}
