package com.iacsd.services;

import java.util.List;

import com.iacsd.dto.MarksRow;
import com.iacsd.dto.StudentIdentity;
import com.iacsd.pojos.Marks;

public interface MarksService {
	List<Marks> findByStudentId(int id);
	Marks save(Marks marks);
	Marks marksForFileUpload(StudentIdentity sIdentity);
	void deletePreviousRecord(int id, String sCode);
	List<MarksRow> fetchAssignments(int studentId);
	
}
