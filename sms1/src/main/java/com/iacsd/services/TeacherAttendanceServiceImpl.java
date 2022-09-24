package com.iacsd.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.daos.TeacherAttendanceDao;
import com.iacsd.dto.attendanceListReadable;
import com.iacsd.pojos.TeacherAttendance;

@Transactional
@Service
public class TeacherAttendanceServiceImpl implements TeacherAttendanceService{

	@Autowired
	TeacherAttendanceDao tADao;
	
	@Override
	public List<TeacherAttendance> findByTeacherId(int Id) {
		return tADao.findByTeacherId(Id);
	}

	@Override
	public TeacherAttendance save(TeacherAttendance tAttendence) {
		return tADao.save(tAttendence);
	}

	@Override
	public float getAttendancePercentage(List<TeacherAttendance> attendanceList) {
		int totalDays = 0;
		int presentDays = 0;
		for (TeacherAttendance teacherA : attendanceList) {
			totalDays ++;
			if(teacherA.getAttendanceStatus().equals("P"))
				presentDays ++;
		}
		float percentage = ((float)presentDays / (float) totalDays) * 100;
		return percentage;
	}

	@Override
	public List<attendanceListReadable> getReadableAttendance(List<TeacherAttendance> attendanceList) {
		List<attendanceListReadable> list = new ArrayList<attendanceListReadable>();
		for (TeacherAttendance teacherA : attendanceList) {
			String studentFullDate = teacherA.getDateOfAttendance().toString();
			String[] arrOfStr = studentFullDate.split(" ", 0);
			attendanceListReadable readable = new attendanceListReadable();
			readable.setDate(arrOfStr[0]);
			if(teacherA.getAttendanceStatus().equals("P")) {
				readable.setStatus("Present");
			}
			else {
				readable.setStatus("Absent");
			}
			list.add(readable);
			
		}
		return list;
	}

}
