package com.iacsd.controllers;

import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.dto.Authenticate;
import com.iacsd.dto.SubWithTeacher;
import com.iacsd.dto.Subject;
import com.iacsd.helperobjects.Maps;
import com.iacsd.pojos.StudentDetails;
import com.iacsd.pojos.Subjects;
import com.iacsd.pojos.Users;
import com.iacsd.services.StudentDetailsService;
import com.iacsd.services.SubjectsService;
import com.iacsd.services.TeacherService;
import com.iacsd.services.UsersService;

@CrossOrigin
@RequestMapping("/subject")
@RestController
public class SubjectController {
	
	@Autowired
	SubjectsService subjectsService;
	
	@Autowired
	UsersService uService;
	
	@Autowired
	StudentDetailsService sdService;
	
	
	@PostMapping("/addSubject")
	public ResponseEntity<?> addSubject(@RequestBody Subject subject){
		Subjects flag = subjectsService.findBySubjectCode(subject.getSubjectCode());
		Map<String, Object> map = Maps.getMap();
		if(flag != null) {
			map.put("status", "exists");
			map.put("message", "The subject you've entered alrady exists, Plz Check the Subject code from the below list");
			return ResponseEntity.ok(map);
		}
		Subjects s1 = new Subjects();
		s1.setMaxAssignmentMarks(subject.getMaxAssignmentMarks());
		s1.setMaxMarks(subject.getMaxMarks());
		s1.setStd(subject.getStd());
		s1.setSubjectCode(subject.getSubjectCode());
		s1.setSubjectName(subject.getSubjectName());
		s1.setTeacherId(subject.getTeacherId());
		
		
		List<StudentDetails> studentList = sdService.findByStd(subject.getStd());
		for (StudentDetails sd : studentList) {
			System.out.println(sd.toString());
			s1.addStudentDetails(sd);
		}
		
		System.out.println(subject.toString());
		System.out.println(s1.toString());
		Subjects s = subjectsService.save(s1);
		if(s != null) {
			map.put("status", "success");
			return ResponseEntity.ok(map);
		}else {
			map.put("status", "error");
			return ResponseEntity.ok(map);
		}
	}
	
	@PostMapping("/all")
//	@GetMapping("/all")
	public ResponseEntity<?> allSubjects(){
		
		System.out.println("in All Subject Controller.");
		List<Subjects> list = subjectsService.findAll();
		
		List<SubWithTeacher> modList = subjectsService.fetchTeachers(list);
		
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data", modList);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/AssignTeacher")
	public ResponseEntity<?> AssignTeacher(@RequestBody Subjects subject){
		Subjects s = subjectsService.findBySubjectCode(subject.getSubjectCode());
		s.setTeacherId(subject.getTeacherId());
		subjectsService.save(s);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/demo")
	public ResponseEntity<?> demo(@RequestBody Subject subject){
		Subjects s = subjectsService.findBySubjectCode(subject.getSubjectCode());
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data", s);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/fetchSubjectsForTeacher")
	public ResponseEntity<?> fetchSubjectsForTeacher(@RequestBody Authenticate auth){
		List<Subjects> listSubjects = subjectsService.findByTeacherId(auth.getUserId());
		System.out.println("listSubjects : "+listSubjects);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data", listSubjects);
		return ResponseEntity.ok(map);
	}
}
