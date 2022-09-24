package com.iacsd.services;

import java.util.List;

import com.iacsd.dto.TeacherAttendanceRow;
import com.iacsd.dto.TeacherDesignation;
import com.iacsd.dto.TeacherProfile;
import com.iacsd.pojos.Teacher;
import com.iacsd.pojos.Users;

public interface TeacherService {

	TeacherProfile getProfile(Users user);

	void updateProfile(TeacherProfile tProfile);
	Teacher findByTeacherId(int id);
	List<TeacherDesignation> getTeachersForDesignation(List<Users> teacherList);
	Teacher save(Teacher teacher);

	List<TeacherDesignation> getWithIdAndDesig();
	List<Teacher> findAll();

	List<TeacherAttendanceRow> getTeachersForAttendance();

}
