package com.iacsd.services;

import java.util.List;

import com.iacsd.dto.attendanceListReadable;
import com.iacsd.pojos.TeacherAttendance;

public interface TeacherAttendanceService {
	List<TeacherAttendance> findByTeacherId(int Id);
	TeacherAttendance save(TeacherAttendance tAttendence);
	float getAttendancePercentage(List<TeacherAttendance> attendanceList);
	List<attendanceListReadable> getReadableAttendance(List<TeacherAttendance> attendanceList);
}
