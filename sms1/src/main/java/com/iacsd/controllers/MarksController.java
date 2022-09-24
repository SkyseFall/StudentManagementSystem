package com.iacsd.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.dto.MarksDetails;
import com.iacsd.dto.MarksRow;
import com.iacsd.dto.Marksheet;
import com.iacsd.dto.StudentIdentity;
import com.iacsd.helperobjects.Maps;
import com.iacsd.helperobjects.SortByPercentage;
import com.iacsd.pojos.Marks;
import com.iacsd.pojos.StudentDetails;
import com.iacsd.services.MarksService;
import com.iacsd.services.StudentDetailsService;

@CrossOrigin
@RequestMapping("/marks")
@RestController
public class MarksController {
	@Autowired
	MarksService marksService;
	
	@Autowired
	StudentDetailsService sdService;
	
	@PostMapping("/addMarks")
	public ResponseEntity<?> addMarks(@RequestBody MarksRow mRow){
		List<Marks> list = marksService.findByStudentId(mRow.getStudentId());
		boolean flag = true;
		Marks mark = null;
		if(!list.isEmpty()) {
			for (Marks m : list) {
				if(m.getSubjectCode().equals(mRow.getSubjectCode())) {
					mark = m;
					mark.setAssignmentMarks(mRow.getAssignmentMarks());
					mark.setMarks(mRow.getMarks());
					flag = false;
					break;
				}
			}
			if(flag) {
				mark = new Marks();
				mark.setStudentId(mRow.getStudentId());
				mark.setSubjectCode(mRow.getSubjectCode());
				mark.setMarks(mRow.getMarks());
				mark.setAssignmentMarks(mRow.getAssignmentMarks());
			}
		}else {
			mark = new Marks();
			mark.setStudentId(mRow.getStudentId());
			mark.setSubjectCode(mRow.getSubjectCode());
			mark.setMarks(mRow.getMarks());
			mark.setAssignmentMarks(mRow.getAssignmentMarks());
		}
		marksService.save(mark);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		return ResponseEntity.ok(map);
		
	}
	
	@PostMapping("/getResult")
	public ResponseEntity<?> getResult(@RequestBody StudentIdentity sIdentity){
		StudentDetails sDetail = sdService.findBystudentId(sIdentity.getStudentId());
		System.out.println("sDetail : "+sDetail);
		List<MarksDetails> mDetails = sdService.fetchMarkDetails(sDetail);
		System.out.println("mDetails : "+mDetails);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data",mDetails);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/getMarksheet")
	public ResponseEntity<?> getMarksheet(@RequestBody StudentIdentity sIdentity){
		StudentDetails sDetail = sdService.findBystudentId(sIdentity.getStudentId());
		System.out.println("sDetail : "+sDetail);
		Map<String, Object> map = Maps.getMap();
		if(sDetail != null) {
			List<MarksDetails> mDetails = sdService.fetchMarkDetails(sDetail);
			System.out.println("mDetails:  "+mDetails);
			Marksheet marksheet = sdService.fetchMarksheet(sDetail,mDetails);
			System.out.println("marksheet : "+marksheet);
			
			map.put("status", "success");
			map.put("marksheet", marksheet);
			map.put("marks", mDetails);
			return ResponseEntity.ok(map);
		}else {
			map.put("status", "error");
			map.put("message", "You are not yet assigned to any class. Please contact the authority");
			return ResponseEntity.ok(map);
		}
	}
	
	@PostMapping("/ranks")
	public ResponseEntity<?> ranks(@RequestBody StudentDetails sD){
		List<StudentDetails> studentDetailsList = sdService.findByStd(sD.getStd());
		List<Marksheet> marksheetList = new ArrayList<Marksheet>();
		Map<String, Object> map = Maps.getMap();
		for (StudentDetails studentDetail : studentDetailsList) {
			List<MarksDetails> mDetails = sdService.fetchMarkDetails(studentDetail);
			Marksheet marksheet = sdService.fetchMarksheet(studentDetail,mDetails);
			marksheetList.add(marksheet);
		}
		
		Comparator<Marksheet> comp = null;
		comp = new SortByPercentage();
		Collections.sort(marksheetList, comp);
		
		map.put("status", "success");
		map.put("marksheetList", marksheetList);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/marksForFileUpload")
	public ResponseEntity<?> marksForFileUpload(@RequestBody StudentIdentity sIdentity){
		Marks fetchedMarks = marksService.marksForFileUpload(sIdentity);
		Map<String, Object> map = Maps.getMap();
		if(fetchedMarks != null && fetchedMarks.getAssignmentSolution() == null) {
			fetchedMarks.setAssignmentSolution("");
			fetchedMarks.setSubmissionTime(null);
		}
		if(fetchedMarks == null) {
			fetchedMarks = new Marks();
			fetchedMarks.setStudentId(sIdentity.getStudentId());
			fetchedMarks.setSubjectCode(sIdentity.getsName());
			marksService.save(fetchedMarks);
			fetchedMarks.setAssignmentSolution("");
			fetchedMarks.setSubmissionTime(null);
		}
		String date = null;
		if(fetchedMarks.getSubmissionTime() != null) {
			date = fetchedMarks.getSubmissionTime().toLocaleString();
		}else {
			date = "";
		}
		map.put("status", "success");
		map.put("data", fetchedMarks);
		map.put("sDate", date);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/fetchAllById")
	public ResponseEntity<?> fetchAllById(@RequestBody Marks m){
		List<MarksRow> list = marksService.fetchAssignments(m.getStudentId());
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data", list);
		return ResponseEntity.ok(map);
	}
}
