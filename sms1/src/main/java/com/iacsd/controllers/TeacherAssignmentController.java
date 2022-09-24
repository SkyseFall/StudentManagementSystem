package com.iacsd.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iacsd.dto.TeacherAssignmentRow;
import com.iacsd.dto.TeacherAssignmentdto;
import com.iacsd.helperobjects.Maps;
import com.iacsd.pojos.StudentDetails;
import com.iacsd.pojos.Subjects;
import com.iacsd.pojos.TeacherAssignment;
import com.iacsd.services.StudentDetailsService;
import com.iacsd.services.SubjectsService;
import com.iacsd.services.TeacherAssignmentService;
import com.iacsd.utils.StorageService;

import java.io.InputStream;

import javax.servlet.ServletOutputStream;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import org.springframework.util.FileCopyUtils;


@CrossOrigin
@RequestMapping("/teacherAssignment")
@RestController
public class TeacherAssignmentController {
	@Autowired
	private TeacherAssignmentService teacherAssignmentService;
	
	@Autowired
	private StorageService storageService;
	
	@Autowired
	private TeacherAssignmentService tAssignment;
	
	@Autowired
	private StudentDetailsService sdService;
	
	@Autowired
	private SubjectsService sService;
	
	@PostMapping("/addAssignment")
	public ResponseEntity<?> saveAssignment(TeacherAssignmentdto teacherAssignment){
		TeacherAssignment menu = TeacherAssignmentdto.toEntity(teacherAssignment);	
	   TeacherAssignment m = teacherAssignmentService.saveNewMenu(menu, teacherAssignment.getAdded_assignment());
	   System.out.println(m.toString());
	   
	   Map<String, Object> map = Maps.getMap();
	   map.put("status","success");
	   map.put("data", m.getAssignmentId());
	   return ResponseEntity.ok(map); 
	}
	
	@PostMapping("/addAssignmentDetails")
	public ResponseEntity<?> addAssignmentDetails(@RequestBody TeacherAssignment tA){
		System.out.println("----------------------------------");
		System.out.println(tA.toString());
		System.out.println("----------------------------------");
		TeacherAssignment tAssignment = teacherAssignmentService.findByAssignmentId(tA.getAssignmentId());
		System.out.println("********************");
		System.out.println(tAssignment.toString());
		System.out.println("********************");
		tAssignment.setAssignmentDue(tA.getAssignmentDue());
		tAssignment.setSubjectCode(tA.getSubjectCode());
		tAssignment.setTeacherId(tA.getTeacherId());
		
		teacherAssignmentService.save(tAssignment);
		 Map<String, Object> map = Maps.getMap();
		 map.put("status","success");
		 return ResponseEntity.ok(map);
	}
	
	@RequestMapping(value="/{fileName}",produces = {"application/pdf"})
	public void download(@PathVariable("fileName") String fileName, HttpServletResponse resp) {
		System.out.println("Loading file: " + fileName);
		Resource resource = storageService.load(fileName);
		if(resource != null) {
			try(InputStream in = resource.getInputStream()) {
				ServletOutputStream out = resp.getOutputStream();
				FileCopyUtils.copy(in, out);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@PostMapping("/all/fetchList")
	public ResponseEntity<?> fetchList(@RequestBody TeacherAssignment tA){
		List<TeacherAssignment> list = tAssignment.findByTeacherId(tA.getTeacherId());
		List<TeacherAssignmentRow> AssignmentList = teacherAssignmentService.getAssignmentList(list);
		Map<String, Object> map = Maps.getMap();
		map.put("status","success");
		map.put("data", AssignmentList);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/studentId/fetchList")
	public ResponseEntity<?> fetchListByStudent(@RequestBody StudentDetails sDetails){
		StudentDetails student = sdService.findBystudentId(sDetails.getStudentId());
		System.out.println("-----------------------------------------");
		System.out.println(student.toString());
		List<Subjects> subjects = sService.findByStd(student.getStd());
		List<TeacherAssignmentRow> AssignmentList = teacherAssignmentService.fetchAssignmentListBySubjects(subjects);
		for (TeacherAssignmentRow teacherAssignmentRow : AssignmentList) {
			teacherAssignmentRow.setStudentId(student.getStudentId());
		}
		Map<String, Object> map = Maps.getMap();
		map.put("status","success");
		map.put("data", AssignmentList);
		return ResponseEntity.ok(map);
	}

}
