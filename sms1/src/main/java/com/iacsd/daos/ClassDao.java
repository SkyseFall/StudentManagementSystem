package com.iacsd.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.pojos.Class;

import java.lang.String;
import java.util.List;

public interface ClassDao extends JpaRepository<Class, Integer> {
	Class findByStd(String std);
	Class save(Class c);
	List<Class> findAll();
}
