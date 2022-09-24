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
import com.iacsd.pojos.TeacherAttendance;
import com.iacsd.services.TeacherAttendanceService;
import com.iacsd.services.UsersService;

@CrossOrigin
@RequestMapping("/teacherAttendance")
@RestController
public class TeacherAttendanceController {
	
	@Autowired
	TeacherAttendanceService tAService;
	
	@Autowired
	UsersService usersService;
	
	@PostMapping("/addAttendance")
	public ResponseEntity<?> addAttendance(@RequestBody TeacherAttendance tA){
		tA.setDateOfAttendance(new Date());
		TeacherAttendance t = tAService.save(tA);
		if(t != null) {
			Map<String, Object> map = Maps.getMap();
			map.put("status", "success");
			return ResponseEntity.ok(map);
		}else {
			Map<String, Object> map = Maps.getMap();
			map.put("status", "error");
			return ResponseEntity.ok(map);
		}
	}
	@PostMapping("/getAttendance")
	public ResponseEntity<?> getAttendance(@RequestBody TeacherAttendance tAttendance){
		List<TeacherAttendance> attendanceList = tAService.findByTeacherId(tAttendance.getTeacherId());
		Map<String, Object> map = Maps.getMap();
		if( attendanceList.isEmpty()) {
			map.put("status", "error");
			map.put("error", "Your attendance record dosen't exists");
			return ResponseEntity.ok(map);
		}
		List<attendanceListReadable> list = tAService.getReadableAttendance(attendanceList);
		float percentage = tAService.getAttendancePercentage(attendanceList);
		map.put("status", "success");
		map.put("data", list);
		map.put("percentage", percentage);
		return ResponseEntity.ok(map);
	}
}
