package com.iacsd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iacsd.pojos.StudentDetails;

public interface StudentDetailsDao extends JpaRepository<StudentDetails, Integer> {
	
//	@Query(value="select * from StudentDetails where studentId= :userId", nativeQuery = true)
//	StudentDetails findBystudentId(@Param("userId") int userId);
	
	StudentDetails findBystudentId(int userId);
	StudentDetails save(StudentDetails studentDetails);
	void deleteByStudentId(int Id);
	void deleteByRollNo(int rollNo);
	
	List<StudentDetails> findByStd(String std);
	List<StudentDetails> findAll();
}
