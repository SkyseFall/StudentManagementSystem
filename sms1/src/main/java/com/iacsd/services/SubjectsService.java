package com.iacsd.services;

import java.util.List;

import com.iacsd.dto.MarksRow;
import com.iacsd.dto.SubWithTeacher;
import com.iacsd.pojos.Subjects;

public interface SubjectsService {
	Subjects save(Subjects subject);
	Subjects findBySubjectCode(String subjectcode);
	List<Subjects> findAll();
	List<SubWithTeacher> fetchTeachers(List<Subjects> list);
	List<Subjects> findByStd(String std);
	List<Subjects> findByTeacherId(int id);
	List<MarksRow> fetchMarkRows(Subjects subject);
}
