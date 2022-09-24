package com.iacsd.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.pojos.TeacherAttendance;

public interface TeacherAttendanceDao extends JpaRepository<TeacherAttendance, Date> {
	List<TeacherAttendance> findByTeacherId(int Id);
	TeacherAttendance save(TeacherAttendance tAttendence);
}
