package com.iacsd.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.dto.AssignmentSolutiondto;
import com.iacsd.helperobjects.Maps;
import com.iacsd.pojos.AssignmentSolution;
import com.iacsd.services.MarksService;
import com.iacsd.services.StudentAssignmentService;

@CrossOrigin
@RequestMapping("/studentAssignment")
@RestController
public class AssignmentSolutionController {
	@Autowired
	private StudentAssignmentService studentAssignmentService;
	
	@Autowired
	private MarksService marksService;
	
	@PostMapping("/submitAssignment")
	public ResponseEntity<?> saveAssignment(AssignmentSolutiondto studentAssignment){
		
		
		int id = studentAssignment.getStudentId();
		String sCode = studentAssignment.getSubjectCode();
		marksService.deletePreviousRecord(id,sCode);
		
		
		AssignmentSolution menu = AssignmentSolutiondto.toEntity(studentAssignment);	
		AssignmentSolution m = studentAssignmentService.saveNewMenu(menu, studentAssignment.getAssignmentSolution());
	   Map<String, Object> map = Maps.getMap();
	   map.put("status","success");
	   return ResponseEntity.ok(map); 
	}
}
