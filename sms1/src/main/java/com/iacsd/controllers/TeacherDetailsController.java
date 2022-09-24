package com.iacsd.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.dto.AuthenticateId;
import com.iacsd.dto.TeacherAttendanceRow;
import com.iacsd.dto.TeacherDesignation;
import com.iacsd.dto.TeacherProfile;
import com.iacsd.helperobjects.Maps;
import com.iacsd.pojos.Teacher;
import com.iacsd.pojos.Users;
import com.iacsd.services.TeacherService;
import com.iacsd.services.UsersService;

@CrossOrigin
@RequestMapping("/teacher")
@RestController
public class TeacherDetailsController {
	@Autowired
	private UsersService usersservice;
	
	@Autowired
	private TeacherService teacherService;
	
	@PostMapping("/getProfile")
	public ResponseEntity<?> getProfile(@RequestBody AuthenticateId auth){
		Users user = null;
		if(auth.getEmail() != null)
			user = usersservice.findByEmail(auth.getEmail());
		if(auth.getUserId() != 0)
			user = usersservice.findByuserId(auth.getUserId());
		TeacherProfile profile = teacherService.getProfile(user);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data", profile);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/updateProfile")
	public ResponseEntity<?> updateProfile(@RequestBody TeacherProfile tProfile){
		//System.out.println(tProfile.toString());
		teacherService.updateProfile(tProfile);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/all")
	public ResponseEntity<?> getAllTeachers(){
		List<Users> teacherList = usersservice.findUsersByTypeJob("teacher");
		List<TeacherDesignation> designationList = teacherService.getTeachersForDesignation(teacherList);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data",designationList);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/changeDesignation")
	public ResponseEntity<?> changeDesignation(@RequestBody TeacherDesignation tDesg){
		System.out.println(tDesg.toString());
		Teacher teacher = teacherService.findByTeacherId(tDesg.getTeacherId());
		teacher.setDesignation(tDesg.getDesignation());
		teacherService.save(teacher);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("messege","Designation Updated Successfully");
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/name")
	public ResponseEntity<?> searchByName(@RequestBody TeacherDesignation teacher){
		Map<String, Object> map = Maps.getMap();
		//System.out.println(teacher);
		List<Users> teacherList = usersservice.findByFirstName(teacher.getTeacherName());
		List<Users> list = new ArrayList<Users>();
		if(!teacherList.isEmpty()) {
			for (Users user : teacherList) {
				if(user.getTypeJob().equals("teacher") && user.getAccountStatus() == 1) {
					list.add(user);
				}
			}
		}
		List<Users> teacherList2 = usersservice.findByLastName(teacher.getTeacherName());
		if(!teacherList2.isEmpty()) {
			
			for (Users user : teacherList2) {
				if(user.getTypeJob().equals("teacher") && user.getAccountStatus() == 1) {
					list.add(user);
				}
			}
			
		}
		if(!list.isEmpty()) {
			List<TeacherDesignation> designationList = teacherService.getTeachersForDesignation(list);
			map.put("status", "success");
			map.put("data",designationList);
			return ResponseEntity.ok(map);
		}
		
		map.put("status", "error");
		map.put("messege","No user with name " + teacher.getTeacherName() +" found !!");
		return ResponseEntity.ok(map);
		
	}
	
	@PostMapping("/getNameAndId")
	public ResponseEntity<?> getNameAndId(){
		List<TeacherDesignation> teachers = teacherService.getWithIdAndDesig();
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data",teachers);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/getTeachersForAttendance")
	public ResponseEntity<?> getTeachersForAttendance(){
		List<TeacherAttendanceRow> tAttendance = teacherService.getTeachersForAttendance();
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data",tAttendance);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/getTeacherPaymentDetails")
	public ResponseEntity<?> getTeacherPaymentDetails(@RequestBody Teacher t){
		Teacher teacher = teacherService.findByTeacherId(t.getTeacherId());
		Users teacherUser = usersservice.findByuserId(t.getTeacherId());
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("teacherId", teacher.getTeacherId());
		map.put("designation", teacher.getDesignation());
		map.put("name", teacherUser.getFirstName()+" "+teacherUser.getLastName());
		map.put("dob", teacherUser.getDob());
		map.put("mobile", teacherUser.getMobile());
		map.put("gender",teacherUser.getGender());
		map.put("username",teacherUser.getUsername());
		map.put("salary",teacher.getSalary());
		return ResponseEntity.ok(map);
	}
}
