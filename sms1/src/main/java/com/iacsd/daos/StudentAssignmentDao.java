package com.iacsd.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.pojos.AssignmentSolution;

public interface StudentAssignmentDao extends JpaRepository<AssignmentSolution, Integer> {
	AssignmentSolution findByMarksheetId(int marksheetid);
	AssignmentSolution save(AssignmentSolution teacherAssignment);
}
