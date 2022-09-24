package com.iacsd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.pojos.StudentDetails;

public interface StudentDetailsDao extends JpaRepository<StudentDetails, Integer> {
	StudentDetails findBystudentId(int userId);
	StudentDetails save(StudentDetails studentDetails);
	void deleteByStudentId(int Id);
	void deleteByRollNo(int rollNo);
	
	List<StudentDetails> findByStd(String std);
	List<StudentDetails> findAll();
}
