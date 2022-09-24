package com.iacsd.services;

import java.util.List;

import com.iacsd.pojos.Class;

public interface ClassService {
	Class findByStd(String std);
	Class save(Class c);
	List<String> findAll();
}
