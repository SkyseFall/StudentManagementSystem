package com.iacsd.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.dto.AuthenticateId;
import com.iacsd.dto.FeeRecordRow;
import com.iacsd.dto.MarksRow;
import com.iacsd.dto.StudentAttendanceRow;
import com.iacsd.dto.StudentDetailsWithName;
import com.iacsd.dto.StudentProfile;
import com.iacsd.helperobjects.Maps;
import com.iacsd.pojos.StudentAttendance;
import com.iacsd.pojos.StudentDetails;
import com.iacsd.pojos.Subjects;
import com.iacsd.pojos.Users;
import com.iacsd.services.StudentAttendanceService;
import com.iacsd.services.StudentDetailsService;
import com.iacsd.services.SubjectsService;
import com.iacsd.services.UsersService;

@CrossOrigin
@RequestMapping("/student")
@RestController
public class StudentDetailsController {
	@Autowired
	private UsersService usersservice;

	@Autowired
	private StudentDetailsService studentDetailsService;
	
	@Autowired
	private SubjectsService subService;
	
	@Autowired
	private StudentAttendanceService sAService;

	@PostMapping("/getProfile")
	public ResponseEntity<?> getProfile(@RequestBody AuthenticateId auth) {
		Users user = null;
		if(auth.getEmail() != null)
			user = usersservice.findByEmail(auth.getEmail());
		//System.out.println("------------------------------------------------------------------------------------------");
		//System.out.println(user);
		//System.out.println("------------------------------------------------------------------------------------------");
		if(auth.getUserId() != 0)
			user = usersservice.findByuserId(auth.getUserId());
		StudentProfile profile = studentDetailsService.getProfile(user);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data", profile);
		return ResponseEntity.ok(map);

	}
	
	@PostMapping("updateProfile")
	public ResponseEntity<?> updateProfile(@RequestBody StudentProfile sProfile){
		studentDetailsService.updateProfile(sProfile);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/addClass")
	public ResponseEntity<?> addClass(@RequestBody StudentDetailsWithName student){
		String standard = student.getStd();
		StudentDetails studentD = studentDetailsService.findBystudentId(student.getStudentId());
		List<Subjects> subList = subService.findByStd(standard);
		if(studentD != null) {
			studentD.removeAll();
		}else {
			studentD = new StudentDetails();
		}
		for (Subjects s : subList) {
			studentD.addSubject(s);
		}
		studentD.setStudentId(student.getStudentId());
		studentD.setStd(standard);
		studentD.setSection(student.getSection());
		studentDetailsService.save(studentD);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/findClass")
	public ResponseEntity<?> findClass (@RequestBody StudentDetails sDetails){
		StudentDetails sD = studentDetailsService.findBystudentId(sDetails.getStudentId());
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("std", sD.getStd());
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/getStudentsForAttendance")
	public ResponseEntity<?> getStudentsForAttendance(@RequestBody StudentDetails sDetails){
		List<StudentDetails> studentList = studentDetailsService.findByStd(sDetails.getStd());
		List<StudentAttendanceRow> sAList = sAService.getStudentList(studentList);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data", sAList);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/fetchStudentsByScode")
	public ResponseEntity<?> fetchStudentsByScode(@RequestBody Subjects s){
		System.out.println(s.toString());
		Subjects subject = subService.findBySubjectCode(s.getSubjectCode());
		List<MarksRow> marksRowList = subService.fetchMarkRows(subject);
		
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data", marksRowList);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/getFeesPaid")
	public ResponseEntity<?> getFeesPaid(@RequestBody StudentDetails sDetails){
		StudentDetails student = studentDetailsService.findBystudentId(sDetails.getStudentId());
		Users user = usersservice.findByuserId(sDetails.getStudentId());
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data", student.getFees());
		map.put("name", user.getFirstName() + " " + user.getLastName());
		map.put("id", user.getUserId());
		map.put("dob", user.getDob());
		map.put("gender", user.getGender());
		map.put("mobile", user.getMobile());
		map.put("username", user.getUsername());
		map.put("rollno", student.getRollNo());
		map.put("std", student.getStd());
		map.put("section", student.getSection());
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/PayAmount")
	public ResponseEntity<?> PayAmount(@RequestBody StudentDetails sDetails){
		StudentDetails student = studentDetailsService.findBystudentId(sDetails.getStudentId());
		int amount = student.getFees();
		int newAmount = amount + sDetails.getFees();
		student.setFees(newAmount);
		StudentDetails s = studentDetailsService.save(student);
		if(s != null) {
			Map<String, Object> map = Maps.getMap();
			map.put("status", "success");
			return ResponseEntity.ok(map);
		}else {
			Map<String, Object> map = Maps.getMap();
			map.put("status", "error");
			return ResponseEntity.ok(map);
		}
	}
	
	@GetMapping("/getFeeRecords")
	public ResponseEntity<?> getFeeRecords(){
		List<StudentDetails> studentList = studentDetailsService.findAll();
		List<FeeRecordRow> feeRecords= studentDetailsService.getFeeRecords(studentList);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data", feeRecords);
		return ResponseEntity.ok(map);
	}
}
