package com.iacsd.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.daos.ClassDao;
import com.iacsd.daos.SubjectsDao;
import com.iacsd.pojos.Class;
import com.iacsd.pojos.Subjects;

@Transactional
@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	ClassDao classDao;
	
	@Autowired
	SubjectsDao subjectDao;

	
	// find by class   --   Class Dao
	@Override
	public Class findByStd(String std) {
		 Class findByStd = classDao.findByStd(std);
		 System.out.println("findByStd : "+ findByStd);
		return findByStd;
	}

	@Override
	public Class save(Class c) {
		/*
		 * List<Subjects> subjects = c.getSubjectList(); if(!subjects.isEmpty()) { for
		 * (Subjects sub : subjects) { subjectDao.save(sub); System.out.println(sub); }
		 * }
		 */
		return classDao.save(c);
	}

	@Override
	public List<String> findAll() {
		List<Class> list = classDao.findAll();
		List<String> classes = new ArrayList<String>();
		if(list != null) {
			for (Class c : list) {
				classes.add(c.getStd());
			}
			return classes;
		}
		return null;
	}

}
