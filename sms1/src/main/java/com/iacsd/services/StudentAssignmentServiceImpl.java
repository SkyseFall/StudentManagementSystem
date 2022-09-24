package com.iacsd.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iacsd.daos.StudentAssignmentDao;
import com.iacsd.pojos.AssignmentSolution;
import com.iacsd.utils.DiskStorageServiceImpl;
@Transactional
@Service
public class StudentAssignmentServiceImpl implements StudentAssignmentService {
@Autowired
DiskStorageServiceImpl storageService ;

@Autowired
StudentAssignmentDao dao;
	@Override
	public AssignmentSolution saveNewMenu(AssignmentSolution menu, MultipartFile assignment_solution) {
		String filename = storageService.store(assignment_solution);
		menu.setAssignmentSolution(filename);
		return dao.save(menu);
	}

}
