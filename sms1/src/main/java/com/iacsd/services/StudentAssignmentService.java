package com.iacsd.services;

import org.springframework.web.multipart.MultipartFile;

import com.iacsd.pojos.AssignmentSolution;

public interface StudentAssignmentService {

	AssignmentSolution saveNewMenu(AssignmentSolution menu, MultipartFile assignment_solution);

}
