package com.iacsd.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.dto.Authenticate;
import com.iacsd.dto.FeedbackRow;
import com.iacsd.dto.FeedbackViewRow;
import com.iacsd.helperobjects.Maps;
import com.iacsd.pojos.StudentDetails;
import com.iacsd.pojos.StudentFeedback;
import com.iacsd.pojos.Subjects;
import com.iacsd.services.StudentDetailsService;
import com.iacsd.services.StudentFeedbackService;

@CrossOrigin
@RequestMapping("/feedback")
@RestController
public class StudentFeedbackController {
	@Autowired
	StudentFeedbackService sfService;
	
	@Autowired
	StudentDetailsService sdService;
	
	@Autowired
	StudentFeedbackService sfSerfice;
	
	
	@PostMapping("/getTeachers")
	public ResponseEntity<?> getTeachers(@RequestBody Authenticate auth){
		StudentDetails student = sdService.findBystudentId(auth.getUserId());
		List<Subjects> subjectList = student.getSubjectList();
		List<FeedbackRow> feedbackList = sfService.getFeedbackRows(subjectList,auth.getUserId());
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data", feedbackList);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/saveRatings")
	public ResponseEntity<?> saveRatings(@RequestBody FeedbackRow fRow){
		StudentFeedback sf = new StudentFeedback();
		sf.setStudentId(fRow.getStudentId());
		sf.setTeacherId(fRow.getTeacherId());
		sf.setFeedbackRatings(fRow.getFeedBackRatings());
		sf.setFeedbackRemarks(fRow.getFeedbackRemarks());
		sfService.save(sf);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/getFeedbackForTeacher")
	public ResponseEntity<?> getFeedbackForTeacher(@RequestBody Authenticate auth){
		List<StudentFeedback> feedBackList = sfSerfice.findByTeacherId(auth.getUserId());
		List<FeedbackViewRow> presentList = sfService.getFeedbackViewRows(feedBackList);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data", presentList);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody StudentFeedback sf){
		sfSerfice.deleteByFeedbackId(sf.getFeedbackId());
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		return ResponseEntity.ok(map);
	}

}
