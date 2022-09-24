package com.iacsd.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.daos.StudentAttendanceDao;
import com.iacsd.daos.UsersDao;
import com.iacsd.dto.StudentAttendanceRow;
import com.iacsd.dto.attendanceListReadable;
import com.iacsd.pojos.StudentAttendance;
import com.iacsd.pojos.StudentDetails;
import com.iacsd.pojos.Users;

@Transactional
@Service
public class StudentAttendanceServiceImpl implements StudentAttendanceService {
	@Autowired
	StudentAttendanceDao studentAttendanceDao;
	
	@Autowired
	UsersDao usersDao;

	@Override
	public List<StudentAttendanceRow> getStudentList(List<StudentDetails> studentList) {
		Date date = new Date();
		boolean flag = true;
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		//String format = formatter.format();
		String today = formatter.format(date);
		
		List<StudentAttendanceRow> sAList = new ArrayList<StudentAttendanceRow>();
		for (StudentDetails student : studentList) {
			flag = true;
			List<StudentAttendance> sList = studentAttendanceDao.findByStudentId(student.getStudentId());
			  if(!sList.isEmpty()) {
				  for (StudentAttendance s : sList) {
					  //System.out.println("---------------------------");
					  //System.out.println(today);
					  //System.out.println(s.getDateOfAttendance().toString());
					  String studentFullDate = s.getDateOfAttendance().toString();
					  String[] arrOfStr = studentFullDate.split(" ", 0);
					  //System.out.println(arrOfStr[0]);
					  //System.out.println("---------------------------");
					  if(arrOfStr[0].equals(today)) {
						  flag = false;
						  break;
					  }
				  }
				  if(flag) {
					  	StudentAttendanceRow sRow = new StudentAttendanceRow();
						sRow.setStudentId(student.getStudentId());
						sRow.setSection(student.getSection());
						Users user = usersDao.findByuserId(student.getStudentId());
						sRow.setStudentName(user.getFirstName() + " " + user.getLastName());
						sAList.add(sRow);
				  }
			  }else {
				  StudentAttendanceRow sRow = new StudentAttendanceRow();
				  sRow.setStudentId(student.getStudentId());
				  sRow.setSection(student.getSection());
				  Users user = usersDao.findByuserId(student.getStudentId());
				  sRow.setStudentName(user.getFirstName() + " " + user.getLastName());
				  sAList.add(sRow);
			  }
		}
		return sAList;
	}

	@Override
	public List<StudentAttendance> findByStudentId(int id) {
		return studentAttendanceDao.findByStudentId(id);
	}

	@Override
	public StudentAttendance save(StudentAttendance studentAttendance) {
		return studentAttendanceDao.save(studentAttendance);
	}

	@Override
	public List<attendanceListReadable> getReadableAttendance(List<StudentAttendance> attendanceList) {
		List<attendanceListReadable> list = new ArrayList<attendanceListReadable>();
		for (StudentAttendance studentA : attendanceList) {
			String studentFullDate = studentA.getDateOfAttendance().toString();
			String[] arrOfStr = studentFullDate.split(" ", 0);
			attendanceListReadable readable = new attendanceListReadable();
			readable.setDate(arrOfStr[0]);
			if(studentA.getAttendanceStatus().equals("P")) {
				readable.setStatus("Present");
			}else {
				readable.setStatus("Absent");
			}
			list.add(readable);
		}
		return list;
	}

	@Override
	public float getAttendancePercentage(List<StudentAttendance> attendanceList) {
		int totalDays = 0;
		int presentDays = 0;
		for (StudentAttendance studentA : attendanceList) {
			totalDays ++;
			if(studentA.getAttendanceStatus().equals("P"))
				presentDays ++;
		}
		float percentage = ((float)presentDays / (float) totalDays) * 100;
		return percentage;
	}

}
