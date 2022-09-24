package com.iacsd.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.dto.ClassDetails;
import com.iacsd.dto.ShowSubjects;
import com.iacsd.helperobjects.Maps;
import com.iacsd.pojos.Class;
import com.iacsd.pojos.Subjects;
import com.iacsd.pojos.Users;
import com.iacsd.services.ClassService;
import com.iacsd.services.UsersService;

@CrossOrigin
@RequestMapping("/class")
@RestController
public class ClassController {
	@Autowired
	ClassService classService;
	
	@Autowired
	UsersService usersService;
	
	
	  @PostMapping("/subjects") 
	  public ResponseEntity<?> findByStd(@RequestBody Subjects subject){
		  System.out.println("hello "+subject);
		  Class c = classService.findByStd(subject.getStd());
		  System.out.println("--------------------------------------------");
		  System.out.println("Class Object C : "+ c); 
		  Map<String, Object> map = Maps.getMap();
		  map.put("status", "success"); 
		  List <Subjects> list = c.getSubjectList();
		  List <ShowSubjects> showSubjectsList = new ArrayList<ShowSubjects>();
		  for (Subjects s : list) {
			System.out.println(s.toString());
			Users u = usersService.findByuserId(s.getTeacherId());
			// Here we r mapping all the Subject fields to ShowSubject fields
			ShowSubjects sS = new ShowSubjects();
			sS.setSubjectCode(s.getSubjectCode());
			sS.setMaxMarks(s.getMaxMarks());
			sS.setMaxAssignmentMarks(s.getMaxAssignmentMarks());
			sS.setSubjectName(s.getSubjectName());
			if(s.getTeacherId() != 0)
			if(u == null) {
				sS.setTeacherName("Not Assigned");
			}else {
				sS.setTeacherName(u.getFirstName() +" " + u.getLastName());
				sS.setTeacherId(u.getUserId());
			}
			showSubjectsList.add(sS);
		}
		  map.put("data", showSubjectsList);
		  return ResponseEntity.ok(map);
		  }
	 
	
	@PostMapping("/addClass")
	public ResponseEntity<?> addClass(@RequestBody ClassDetails c){
		System.out.println(c);
		if(c.getStd() == "") {
			Map<String, Object> map = Maps.getMap();
			map.put("status", "empty");
			map.put("message", "Please enter the Class");
			return ResponseEntity.ok(map);
		}
		System.out.println(c);
		Class flag = classService.findByStd(c.getStd());
		if(flag != null) {
			Map<String, Object> map = Maps.getMap();
			map.put("status", "exist");
			map.put("message", "The class you've entered already exists!!");
			return ResponseEntity.ok(map);
		}
		
		//For Splitting the String of format "Id: 19-Bhavesh Salve" into its its currosponding id
		
		int classRep = 0;
		int teacherRep = 0;
		
		System.out.println(c.getClassRep());
		
		if(!c.getClassRep().equals("0")) {
			String str = c.getClassRep();
			String split1[] = str.split(" ",0);
			System.out.println(split1[1]);
			String split2[] = split1[1].split("-",0);
			//System.out.println(split2[0]);
			classRep = Integer.parseInt(split2[0]);
		}
		
		if(!c.getTeacherRep().equals("0")) {
			String str = c.getTeacherRep();
			String split3[] = str.split(" ",0);
			//System.out.println(split1[1]);
			String split4[] = split3[1].split("-",0);
			//System.out.println(split2[0]);
			teacherRep = Integer.parseInt(split4[0]);
		}
		
		
          Class cl = new Class();
          cl.setStd(c.getStd());
          cl.setClassRep(classRep);
          cl.setTeacherRep(teacherRep);
          classService.save(cl);
		  Map<String, Object> map = Maps.getMap(); 
		  map.put("status", "success"); 
		  map.put("data", c); 
		  return ResponseEntity.ok(map);
		 
	}
	
	@GetMapping("/getDistinctClasses")
	public ResponseEntity<?> getDistinctClasses(){
		List<String> classes = classService.findAll();
		Map<String, Object> map = Maps.getMap();
		if(classes == null) {
			map.put("status", "zero");
			map.put("message", "No classes present in the record");
			return ResponseEntity.ok(map);
		}
		map.put("status", "success");
		map.put("data", classes);
		return ResponseEntity.ok(map);
	}
}
