package com.iacsd.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.dto.AccountDetails;
import com.iacsd.dto.Authenticate;
import com.iacsd.dto.AuthenticateId;
import com.iacsd.dto.StudentDetailsWithName;
import com.iacsd.dto.StudentIdentity;
import com.iacsd.dto.StudentProfile;
import com.iacsd.dto.TeacherProfile;
import com.iacsd.helperobjects.Maps;
import com.iacsd.pojos.Class;
import com.iacsd.pojos.StudentDetails;
import com.iacsd.pojos.Teacher;
import com.iacsd.pojos.Users;
import com.iacsd.services.StudentDetailsService;
import com.iacsd.services.TeacherService;
import com.iacsd.services.UsersService;

@CrossOrigin
@RequestMapping("/users")
@RestController
public class UserController {
	
	@Autowired
	private UsersService usersservice;
	
	@Autowired
	private StudentDetailsService studentDetailsService;
	
	@Autowired
	private TeacherService teacherService;
	
	/*
	 * @PostMapping("/register") public ResponseEntity<Users> save(@RequestBody
	 * Users user){ user.setAccountStatus(0); Users newUser =
	 * usersservice.save(user); return ResponseEntity.ok(newUser); }
	 */
	
	@PostMapping("/register") 
	public ResponseEntity<?> InsertUserDetail(@RequestBody Users user){ 
		Map<String, Object> map = Maps.getMap();
		if(usersservice.findByEmail(user.getEmail()) != null) {
			map.put("status","exist");
			map.put("messege","User already exists!!");
			return ResponseEntity.ok(map);
		}
		user.setAccountStatus(0);
		Users newUser =usersservice.save(user);
		map.put("status","success");
		map.put("data",newUser);
		return ResponseEntity.ok(map); 
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticate(@RequestBody Authenticate auth){
		Users loggedInUser = usersservice.authenticate(auth.email, auth.password);
		Map<String, Object> map = Maps.getMap();
		if(loggedInUser != null) {
			if(loggedInUser.getAccountStatus() == 0) {
				map.put("status", "inactive");
				map.put("error", "Your Account is is not activated yet. Please contact the authority");
				return ResponseEntity.ok(map);
			}else if(loggedInUser.getUserId() == -1) {
				map.put("status", "error");
				map.put("error", "Your Password dosen't match with records. Please check it again");
				return ResponseEntity.ok(map);
			}
			map.put("status", "success");
			map.put("data", loggedInUser.getTypeJob());
			map.put("user", loggedInUser.getUserId());
			return ResponseEntity.ok(map);
		}else {
			map.put("status", "error");
			map.put("error", "User not found, Please check entered email or password");
			return ResponseEntity.ok(map);
		}
	}
	
	@PostMapping("/changePassword")
	public ResponseEntity<?> authenticateId(@RequestBody AuthenticateId auth){
		Users user = usersservice.changePassword(auth.getDob(), auth.getEmail());
		if(user != null) {
			Map<String, Object> map = Maps.getMap();
			map.put("status", "success");
			map.put("data", user.getUserId());
			return ResponseEntity.ok(map);
		}else {
			Map<String, Object> map = Maps.getMap();
			map.put("status", "error");
			map.put("error", "User not found. Please check the entered data!");
			return ResponseEntity.ok(map);
		}
	}
	
	@PostMapping("/updatePassword")
	public ResponseEntity<?> setNewPassword(@RequestBody Authenticate auth){
		Users user = usersservice.findByuserId(auth.getUserId());
		user.setPassword(auth.password);
		user = usersservice.save(user);
		if(user != null) {
			Map<String, Object> map = Maps.getMap();
			map.put("status", "success");
			map.put("message", "Password updated successfully");
			return ResponseEntity.ok(map);
		}else {
			Map<String, Object> map = Maps.getMap();
			map.put("status", "error");
			map.put("error", "Improper password. Try using different one");
			return ResponseEntity.ok(map);
		}
		
	}
	
	/*
	 * @GetMapping("/activateAccount/{userId}") 
	    public ResponseEntity<?>
	 * activateAccount(@PathVariable int userId,HttpSession session){ String job =
	 * (String) session.getAttribute("typeJob"); Map<String, Object> map =
	 * Maps.getMap(); if(job == null) { map.put("status", "error"); map.put("error",
	 * "Please Login First!!"); return ResponseEntity.ok(map); }
	 * if(job.equals("admin")) { Users user = usersservice.findByuserId(userId);
	 * user.setAccountStatus(1); usersservice.save(user); map.put("status",
	 * "success"); map.put("message", "Account Activated Successfully"); }else {
	 * map.put("status", "error"); map.put("error",
	 * "You are unauthorized to activate the account"); } return
	 * ResponseEntity.ok(map); }
	 */
	
	@GetMapping("/inactiveUsers")
	public ResponseEntity<?> activateAccount(){
		List<AccountDetails> list = usersservice.findByAccountStatus(0);
		Map<String , Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data", list);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/activateUser")
	public ResponseEntity<?> activateUser(@RequestBody Authenticate auth){
		Users user = usersservice.findByEmail(auth.getEmail());
		user.setAccountStatus(1);
		user = usersservice.save(user);
		if(user != null) {
			Map<String, Object> map = Maps.getMap();
			map.put("status", "success");
			map.put("message", "User "+user.getFirstName()+" "+user.getLastName()+" is Activated");
			return ResponseEntity.ok(map);
		}else {
			Map<String, Object> map = Maps.getMap();
			map.put("status", "error");
			map.put("error", "User Dosen't Exist");
			return ResponseEntity.ok(map);
		}
	}
	
	@DeleteMapping("/{email}")
	public ResponseEntity<?> removeDeactivatedAccount(@PathVariable String email){
		usersservice.deleteByEmail(email);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("message", "User Deleted");
		return ResponseEntity.ok(map);
	}
	
	@GetMapping("/getAllUsersExceptAdmins")
	public ResponseEntity<?> getAllUsersExceptAdmins(){
		List<AccountDetails> list = usersservice.findAllExceptAdmin();
		System.out.println("List AllExceptAdmin : "+list);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data",list );
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/getProfile")
	public ResponseEntity<?> getProfile(@RequestBody AuthenticateId auth){
		Users user = usersservice.findByuserId(auth.getUserId());
		if(user.getTypeJob().equals("student")) {
			StudentProfile profile = studentDetailsService.getProfile(user);
			System.out.println(profile);
			Map<String, Object> map = Maps.getMap();
			map.put("status", "success");
			map.put("data", profile);
			return ResponseEntity.ok(map);
		}else if (user.getTypeJob().equals("teacher")) {
			TeacherProfile profile = teacherService.getProfile(user);
			System.out.println(profile);
			Map<String, Object> map = Maps.getMap();
			map.put("status", "success");
			map.put("data", profile);
			return ResponseEntity.ok(map);
		}else {
			user.setEmail(null);
			user.setPassword(null);
			Map<String, Object> map = Maps.getMap();
			map.put("status", "success");
			map.put("data",user);
			return ResponseEntity.ok(map);
		}
	}
	
	@PostMapping("/updateAdmin")
	public ResponseEntity<?> updateAdmin(@RequestBody Users updatedUser){
		Users user = usersservice.findByuserId(updatedUser.getUserId());
		user.setFirstName(updatedUser.getFirstName());
		user.setLastName(updatedUser.getLastName());
		user.setDob(updatedUser.getDob());
		user.setGender(updatedUser.getGender());
		user.setLocality(updatedUser.getLocality());
		user.setMobile(updatedUser.getMobile());
		user.setPincode(updatedUser.getPincode());
		user.setUsername(updatedUser.getUsername());
		usersservice.save(user);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		return ResponseEntity.ok(map);
	}
	@GetMapping("getTeachersStudents")
	public ResponseEntity<?> getTeachersStudents(){
		List<String> students = usersservice.findByTypeJob("student");
		List<String> teachers = usersservice.findByTypeJob("teacher");
		
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("students", students);
		map.put("teachers", teachers);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/getAllStudents")
	public ResponseEntity<?> getAllStudents(){
		 List<Users> list = usersservice.findUserByTypeJob("student");
		 List<StudentDetailsWithName> students = studentDetailsService.getStudentDetails(list);
		 Map<String, Object> map = Maps.getMap();
			map.put("status", "success");
			map.put("data", students);
			return ResponseEntity.ok(map);
	}
	
	@GetMapping("/getTeachersWithId")
	public ResponseEntity<?> getTeachersWithId(){
		List<String> teacherList = usersservice.findByTypeJob("teacher");
		 Map<String, Object> map = Maps.getMap();
			map.put("status", "success");
			map.put("data", teacherList);
			return ResponseEntity.ok(map);
	}
	
	@GetMapping("/getBalance")
	public ResponseEntity<?> getBalance(){
		List<StudentDetails> studentList = studentDetailsService.findAll();
		List<Teacher> teacherList = teacherService.findAll();
		int amount1 = 0;
		int amount2 = 0;
		for (Teacher teacher : teacherList) {
			amount2 = amount2 + teacher.getSalary();
		}
		for (StudentDetails student : studentList) {
			amount1 = amount1 + student.getFees();
		}
		int balance = amount1 - amount2;
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data", balance);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/adminLogin")
	public ResponseEntity<?> adminLogin(@RequestBody Authenticate auth){
		Users loggedInUser = usersservice.authenticate(auth.email, auth.password);
		Map<String, Object> map = Maps.getMap();
		if(loggedInUser != null) {
			if(loggedInUser.getTypeJob().equals("admin")) {
				map.put("status", "success");
			}else {
				map.put("status", "error");
				map.put("error", "You are unauthorized for this service");
			}
			return ResponseEntity.ok(map);
		}else {
			map.put("status", "error");
			map.put("error", "User not found, Please check entered email or password");
			return ResponseEntity.ok(map);
		}
	}
	
	@PostMapping("/payTeacher")
	public ResponseEntity<?> payTeacher(@RequestBody Teacher t){
		Teacher teacher = teacherService.findByTeacherId(t.getTeacherId());
		int amount = teacher.getSalary();
		int newAmount = amount + t.getSalary();
		teacher.setSalary(newAmount);
		Teacher tea = teacherService.save(teacher);
		Map<String, Object> map = Maps.getMap();
		if(tea != null) {
			map.put("status", "success");
			return ResponseEntity.ok(map);
		}else {
			map.put("status", "error");
			return ResponseEntity.ok(map);
		}
	}
	
	@PostMapping("/authenticateTeacher")
	public ResponseEntity<?> authenticateTeacher(@RequestBody Authenticate auth){
		Users loggedInUser = usersservice.authenticate(auth.email, auth.password);
		Map<String, Object> map = Maps.getMap();
		if(loggedInUser != null) {
			if(loggedInUser.getTypeJob().equals("teacher")) {
				Users user = usersservice.findByuserId(auth.getUserId());
				if(user.getEmail().equals(loggedInUser.getEmail())) {
					map.put("status", "success");
				}else {
					map.put("status", "error");
					map.put("error", "Entered credentials belongs to someone else!!");
				}
			}else {
				map.put("status", "error");
				map.put("error", "You are unauthorized for this service");
			}
			return ResponseEntity.ok(map);
		}else {
			map.put("status", "error");
			map.put("error", "User not found, Please check entered email or password");
			return ResponseEntity.ok(map);
		}
	}
	
	@PostMapping("/getStudentsForClass")
	public ResponseEntity<?> getStudentsForClass(@RequestBody Class cl ){
		List<StudentDetails> sDetails = studentDetailsService.findByStd(cl.getStd());
		List<Users> usersList = studentDetailsService.fetchUsers(sDetails);
		List<StudentIdentity> identityList = usersservice.fetchStudentIdentities(usersList);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data", identityList);
		return ResponseEntity.ok(map);
	}
	
}
