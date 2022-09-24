package com.iacsd.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.pojos.StudentAttendance;

public interface StudentAttendanceDao extends JpaRepository<StudentAttendance, Date> {
	List<StudentAttendance> findByStudentId(int id);
	StudentAttendance save(StudentAttendance studentAttendance);
}
