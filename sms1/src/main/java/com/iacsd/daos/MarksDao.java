package com.iacsd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.pojos.Marks;

public interface MarksDao extends JpaRepository<Marks, Integer>{
	List<Marks> findByStudentId(int id);
	Marks save(Marks marks);
}
