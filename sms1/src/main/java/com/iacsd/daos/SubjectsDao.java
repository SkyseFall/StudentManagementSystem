package com.iacsd.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iacsd.pojos.Subjects;

import java.lang.String;
import java.util.List;

public interface SubjectsDao extends JpaRepository<Subjects, String> {
	Subjects save(Subjects subject);
	Subjects findBySubjectCode(String subjectcode);
	List<Subjects> findAll();
	List<Subjects> findByStd(String std);  // find by class
	
	@Query(value="select * from subjects where teacher_id = :id", nativeQuery = true)
	List<Subjects> findByTeacherId(@Param("id") int id);
}
