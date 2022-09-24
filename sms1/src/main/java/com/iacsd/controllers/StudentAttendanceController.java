package com.iacsd.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.dto.attendanceListReadable;
import com.iacsd.helperobjects.Maps;
import com.iacsd.pojos.StudentAttendance;
import com.iacsd.services.StudentAttendanceService;

@CrossOrigin
@RequestMapping("/studentAttendance")
@RestController
public class StudentAttendanceController {
	@Autowired
	StudentAttendanceService sAService;
	
	
	@PostMapping("/addAttendance")
	public ResponseEntity<?> addAttendance(@RequestBody StudentAttendance sA){
		sA.setDateOfAttendance(new Date());
		StudentAttendance s = sAService.save(sA);
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
	
	@PostMapping("/getStudentAttendance")
	public ResponseEntity<?> getStudentAttendance(@RequestBody StudentAttendance sAttendance){
		List<StudentAttendance> attendanceList = sAService.findByStudentId(sAttendance.getStudentId());
		Map<String, Object> map = Maps.getMap();
		if(attendanceList.isEmpty()) {
			map.put("status", "error");
			map.put("error", "Your attendance record dosen't exists");
			return ResponseEntity.ok(map);
		}
		List<attendanceListReadable> list = sAService.getReadableAttendance(attendanceList);
		float percentage = sAService.getAttendancePercentage(attendanceList);
		map.put("status", "success");
		map.put("data", list);
		map.put("percentage", percentage);
		return ResponseEntity.ok(map);
	}
}
