package com.iacsd.services;

import java.util.List;

import com.iacsd.dto.StudentAttendanceRow;
import com.iacsd.dto.attendanceListReadable;
import com.iacsd.pojos.StudentAttendance;
import com.iacsd.pojos.StudentDetails;

public interface StudentAttendanceService {
	List<StudentAttendance> findByStudentId(int id);

	List<StudentAttendanceRow> getStudentList(List<StudentDetails> studentList);
	StudentAttendance save(StudentAttendance studentAttendance);

	List<attendanceListReadable> getReadableAttendance(List<StudentAttendance> attendanceList);

	float getAttendancePercentage(List<StudentAttendance> attendanceList);
}
