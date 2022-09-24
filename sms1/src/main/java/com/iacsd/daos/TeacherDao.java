package com.iacsd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.pojos.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Integer> {
	Teacher findByTeacherId(int id);
	Teacher save(Teacher teacher);
	List<Teacher> findAll();
}
