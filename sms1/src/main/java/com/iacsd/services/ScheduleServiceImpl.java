package com.iacsd.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.daos.ScheduleDao;
import com.iacsd.daos.SubjectsDao;
import com.iacsd.daos.UsersDao;
import com.iacsd.dto.ScheduleModel;
import com.iacsd.dto.ScheduleRow;
import com.iacsd.pojos.Schedule;
import com.iacsd.pojos.Subjects;
import com.iacsd.pojos.Users;

@Transactional
@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	ScheduleDao scheduleDao;
	
	@Autowired
	UsersDao usersDao;
	
	@Autowired
	SubjectsDao subjectsDao;
	

	@Override
	public Schedule extractSchedule(ScheduleModel scheduleM) {
		String subjectTeacher = scheduleM.getSubjectTeacher();
		System.out.println(subjectTeacher);
        String[] strArr = subjectTeacher.split(" ", 0);
        String subjectCode = strArr[0];
        String tId = strArr[1];
        int teacherId = Integer.parseInt(tId);
        
        String[] startInput = scheduleM.getStartTime().split(":",0);
        String[] endInput = scheduleM.getEndTime().split(":",0);
        
        List<Schedule> classSchedule = scheduleDao.findByStd(scheduleM.getStd());
        for (Schedule schedule : classSchedule) {
        	String[] startTime = schedule.getStartTime().toString().split(":",0);
			String[] endTime = schedule.getEndTime().toString().split(":",0);
			
			
			if(Integer.parseInt(startTime[0]) <= Integer.parseInt(startInput[0]) && Integer.parseInt(startInput[0]) < Integer.parseInt(endTime[0])) {
				Schedule s = new Schedule();
				s.setStd("-1");
				s.setSubjectCode(schedule.getSubjectCode());
				s.setTeacherId(teacherId);
				s.setStartTime(schedule.getStartTime());
				s.setEndTime(schedule.getEndTime());
				return s;
			}
			if(Integer.parseInt(startInput[0]) == Integer.parseInt(endTime[0])) {
				if(Integer.parseInt(startInput[1]) <= Integer.parseInt(endTime[1])) {
					Schedule s = new Schedule();
					s.setStd("-1");
					s.setSubjectCode(schedule.getSubjectCode());
					s.setTeacherId(teacherId);
					s.setStartTime(schedule.getStartTime());
					s.setEndTime(schedule.getEndTime());
					return s;
				}
			}
			
			if(Integer.parseInt(startTime[0]) < Integer.parseInt(endInput[0]) && Integer.parseInt(endInput[0]) <= Integer.parseInt(endTime[0])) {
				Schedule s = new Schedule();
				s.setStd("-1");
				s.setSubjectCode(schedule.getSubjectCode());
				s.setTeacherId(teacherId);
				s.setStartTime(schedule.getStartTime());
				s.setEndTime(schedule.getEndTime());
				return s;
			}
			if(Integer.parseInt(endInput[0]) == Integer.parseInt(startTime[0])) {
				if(Integer.parseInt(endInput[1]) > Integer.parseInt(startTime[1])) {
					Schedule s = new Schedule();
					s.setStd("-1");
					s.setSubjectCode(schedule.getSubjectCode());
					s.setTeacherId(teacherId);
					s.setStartTime(schedule.getStartTime());
					s.setEndTime(schedule.getEndTime());
					return s;
				}
			}
			
			if(Integer.parseInt(startTime[0]) >= Integer.parseInt(startInput[0]) && Integer.parseInt(endInput[0]) >= Integer.parseInt(endTime[0])) {
				Schedule s = new Schedule();
				s.setStd("-1");
				s.setSubjectCode(schedule.getSubjectCode());
				s.setTeacherId(teacherId);
				s.setStartTime(schedule.getStartTime());
				s.setEndTime(schedule.getEndTime());
				return s;
			}
		}
         
        List<Schedule> techerSchedules = scheduleDao.findByTeacherId(teacherId);
        for (Schedule schedule : techerSchedules) {
        	System.out.println("Subject : " + schedule.getSubjectCode());
        	System.out.println("----------------------------");
			System.out.println("Start : " +schedule.getStartTime());
			System.out.println("End : " + schedule.getEndTime());
			System.out.println(schedule.getStartTime().toString());
			String[] startTime = schedule.getStartTime().toString().split(":",0);
			String[] endTime = schedule.getEndTime().toString().split(":",0);
			
			
			if(Integer.parseInt(startTime[0]) <= Integer.parseInt(startInput[0]) && Integer.parseInt(startInput[0]) < Integer.parseInt(endTime[0])) {
				Schedule s = new Schedule();
				s.setStd("-1");
				s.setSubjectCode(schedule.getSubjectCode());
				s.setTeacherId(teacherId);
				s.setStartTime(schedule.getStartTime());
				s.setEndTime(schedule.getEndTime());
				return s;
			}
			if(Integer.parseInt(startInput[0]) == Integer.parseInt(endTime[0])) {
				if(Integer.parseInt(startInput[1]) <= Integer.parseInt(endTime[1])) {
					Schedule s = new Schedule();
					s.setStd("-1");
					s.setSubjectCode(schedule.getSubjectCode());
					s.setTeacherId(teacherId);
					s.setStartTime(schedule.getStartTime());
					s.setEndTime(schedule.getEndTime());
					return s;
				}
			}
			
			if(Integer.parseInt(startTime[0]) < Integer.parseInt(endInput[0]) && Integer.parseInt(endInput[0]) <= Integer.parseInt(endTime[0])) {
				Schedule s = new Schedule();
				s.setStd("-1");
				s.setSubjectCode(schedule.getSubjectCode());
				s.setTeacherId(teacherId);
				s.setStartTime(schedule.getStartTime());
				s.setEndTime(schedule.getEndTime());
				return s;
			}
			if(Integer.parseInt(endInput[0]) == Integer.parseInt(startTime[0])) {
				if(Integer.parseInt(endInput[1]) > Integer.parseInt(startTime[1])) {
					Schedule s = new Schedule();
					s.setStd("-1");
					s.setSubjectCode(schedule.getSubjectCode());
					s.setTeacherId(teacherId);
					s.setStartTime(schedule.getStartTime());
					s.setEndTime(schedule.getEndTime());
					return s;
				}
			}
			
			if(Integer.parseInt(startTime[0]) >= Integer.parseInt(startInput[0]) && Integer.parseInt(endInput[0]) >= Integer.parseInt(endTime[0])) {
				Schedule s = new Schedule();
				s.setStd("-1");
				s.setSubjectCode(schedule.getSubjectCode());
				s.setTeacherId(teacherId);
				s.setStartTime(schedule.getStartTime());
				s.setEndTime(schedule.getEndTime());
				return s;
			}
			
			/*
			
			if(Integer.parseInt(startTime[0]) < Integer.parseInt(startInput[0])) {
				if(Integer.parseInt(startInput[0]) < Integer.parseInt(endTime[0])) {
					Schedule s = new Schedule();
					s.setStd("-1");
					s.setSubjectCode(subjectCode);
					s.setTeacherId(teacherId);
					return s;
				}
			} if(Integer.parseInt(startTime[0]) < Integer.parseInt(endInput[0])) {
				if(Integer.parseInt(endInput[0]) < Integer.parseInt(endTime[0])) {
					Schedule s = new Schedule();
					s.setStd("-1");
					s.setSubjectCode(subjectCode);
					s.setTeacherId(teacherId);
					return s;
				}
			}
			
			if(Integer.parseInt(startTime[0]) == Integer.parseInt(startInput[0])) {
				if(Integer.parseInt(startTime[1]) <= Integer.parseInt(startInput[1])) {
					if(Integer.parseInt(startInput[1]) <= Integer.parseInt(endTime[1])) {
						Schedule s = new Schedule();
						s.setStd("-1");
						s.setSubjectCode(subjectCode);
						s.setTeacherId(teacherId);
						return s;
					}
				} if(Integer.parseInt(startTime[1]) <= Integer.parseInt(endInput[1])) {
					if(Integer.parseInt(endInput[1]) <= Integer.parseInt(endTime[1])) {
						Schedule s = new Schedule();
						s.setStd("-1");
						s.setSubjectCode(subjectCode);
						s.setTeacherId(teacherId);
						return s;
					}
				}
			}
			
			
			
			*/
			
			System.out.println("----------------------------");
			
		}
        
        
		
		
		String timeS = scheduleM.getStartTime();
		Date startTime = new Date();
		strArr = timeS.split(":", 0);
		
		startTime.setHours(Integer.parseInt(strArr[0]));
		startTime.setMinutes(Integer.parseInt(strArr[1]));
		startTime.setSeconds(Integer.parseInt(strArr[2]));
		
		Date endTime = new Date();
		String timeE = scheduleM.getEndTime();
		strArr = timeE.split(":", 0);
		
		endTime.setHours(Integer.parseInt(strArr[0]));
		endTime.setMinutes(Integer.parseInt(strArr[1]));
		endTime.setSeconds(Integer.parseInt(strArr[2]));
		
		Schedule s = new Schedule();
		s.setSubjectCode(subjectCode);
		s.setTeacherId(teacherId);
		s.setEndTime(endTime);
		s.setStartTime(startTime);
		s.setStd(scheduleM.getStd());
		
		return s;
	}

	@Override
	public Schedule save(Schedule schedule) {
		return scheduleDao.save(schedule);
	}

	@Override
	public List<Schedule> findByStd(String std) {
		return scheduleDao.findByStd(std);
	}

	@Override
	public List<ScheduleRow> getScheduleRow(List<Schedule> list) {
		List<ScheduleRow> rowList = new ArrayList<ScheduleRow>();
		for (Schedule schedule : list) {
			ScheduleRow row = new ScheduleRow();
			Users user = usersDao.findByuserId(schedule.getTeacherId());
			if(user != null)
				row.settName(user.getFirstName()+" "+user.getLastName());
			Subjects subject = subjectsDao.findBySubjectCode(schedule.getSubjectCode());
			if(subject != null)
				row.setSubjectName(subject.getSubjectName());
			row.setStartTime(schedule.getStartTime());
			row.setEndTime(schedule.getEndTime());
			row.setStd(schedule.getStd());
			row.setSessionId(schedule.getSessionId());
			rowList.add(row);
		}
		return rowList;
	}

	@Override
	public List<Schedule> findByTeacherId(int teacherid) {
		return scheduleDao.findByTeacherId(teacherid);
	}

	@Override
	public void deleteBySessionId(int id) {
		scheduleDao.deleteBySessionId(id);
	}

}
