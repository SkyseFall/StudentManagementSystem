package com.iacsd.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.dto.AuthenticateId;
import com.iacsd.dto.ScheduleModel;
import com.iacsd.dto.ScheduleRow;
import com.iacsd.helperobjects.Maps;
import com.iacsd.pojos.Schedule;
import com.iacsd.pojos.Subjects;
import com.iacsd.services.ScheduleService;
import com.iacsd.services.SubjectsService;
import com.iacsd.services.UsersService;

@CrossOrigin
@RequestMapping("/schedule")
@RestController
public class ScheduleController {
	@Autowired
	ScheduleService scheduleService;
	
	@Autowired
	SubjectsService sService;
	
	@Autowired
	UsersService uService;
	
	@PostMapping("/addSchedule")
	public ResponseEntity<?> addSchedule(@RequestBody ScheduleModel scheduleM){
		System.out.println("scheduleM : "+scheduleM.toString());
		Map<String, Object> map = Maps.getMap();
		Schedule schedule = scheduleService.extractSchedule(scheduleM);
		System.out.println(schedule.toString());
		if(schedule.getStd().equals("-1")) {
			Subjects sub = sService.findBySubjectCode(schedule.getSubjectCode());
			System.out.println(sub.toString());
			map.put("status", "error");
			map.put("error", "Time Slot is already booked for teacher '"+uService.findByuserId(sub.getTeacherId()).getFirstName() +" "+uService.findByuserId(sub.getTeacherId()).getLastName() +"' who teach '"+sub.getSubjectName()+"' to class '"+sub.getStd() +"' from "+schedule.getStartTime() +" to " +schedule.getEndTime());
			return ResponseEntity.ok(map);
		}
		scheduleService.save(schedule);
		map.put("status", "success");
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/getByClass")
	public ResponseEntity<?> getByClass(@RequestBody Schedule schedule){
		List<Schedule> list = scheduleService.findByStd(schedule.getStd());
		List<ScheduleRow> sR = scheduleService.getScheduleRow(list);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data", sR);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/getByTeacherId")
	public ResponseEntity<?> getByTeacherId(@RequestBody AuthenticateId teacher){
		List<Schedule> list = scheduleService.findByTeacherId(teacher.getUserId());
		List<ScheduleRow> sR = scheduleService.getScheduleRow(list);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		map.put("data", sR);
		return ResponseEntity.ok(map);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSchedule(@PathVariable int id){
		//System.out.println(id);
		scheduleService.deleteBySessionId(id);
		Map<String, Object> map = Maps.getMap();
		map.put("status", "success");
		return ResponseEntity.ok(map);
	}
}
