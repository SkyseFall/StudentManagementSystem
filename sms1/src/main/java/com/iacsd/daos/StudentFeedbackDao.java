package com.iacsd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.pojos.StudentFeedback;

public interface StudentFeedbackDao extends JpaRepository<StudentFeedback, Integer> {
	List<StudentFeedback> findByStudentId(int studentId);
	StudentFeedback save(StudentFeedback studentFeedback);
	List<StudentFeedback> findByTeacherId(int teacherId);
	void deleteByFeedbackId(int Id);
}
