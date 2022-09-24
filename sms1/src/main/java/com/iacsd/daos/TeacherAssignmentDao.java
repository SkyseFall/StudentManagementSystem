package com.iacsd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.pojos.TeacherAssignment;

public interface TeacherAssignmentDao extends JpaRepository<TeacherAssignment, Integer> {
	TeacherAssignment findByAssignmentId(int assignmentid);
	TeacherAssignment save(TeacherAssignment teacherAssignment);
	List<TeacherAssignment> findByTeacherId(int id);
	List<TeacherAssignment> findBySubjectCode(String subjectCode);
}
