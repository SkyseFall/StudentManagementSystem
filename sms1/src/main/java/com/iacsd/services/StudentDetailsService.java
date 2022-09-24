package com.iacsd.services;

import java.util.List;

import com.iacsd.dto.FeeRecordRow;
import com.iacsd.dto.MarksDetails;
import com.iacsd.dto.MarksRow;
import com.iacsd.dto.Marksheet;
import com.iacsd.dto.StudentDetailsWithName;
import com.iacsd.dto.StudentProfile;
import com.iacsd.pojos.StudentDetails;
import com.iacsd.pojos.Users;

public interface StudentDetailsService {

	StudentProfile getProfile(Users user);

	void updateProfile(StudentProfile sProfile);
	
	StudentDetails save(StudentDetails studentDetails);
	StudentDetails findBystudentId(int userId);

	List<StudentDetailsWithName> getStudentDetails(List<Users> list);
	
	void deleteByStudentId(int Id);
	
	void deleteByRollNo(int rollNo);
	
	List<StudentDetails> findByStd(String std);
	List<StudentDetails> findAll();

	List<FeeRecordRow> getFeeRecords(List<StudentDetails> studentList);

	List<Users> fetchUsers(List<StudentDetails> sDetails);

	List<MarksDetails> fetchMarkDetails(StudentDetails sDetail);

	Marksheet fetchMarksheet(StudentDetails sDetail, List<MarksDetails> mDetails);

	

}
