package com.iacsd.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.daos.TeacherAttendanceDao;
import com.iacsd.daos.TeacherDao;
import com.iacsd.daos.UsersDao;
import com.iacsd.dto.TeacherAttendanceRow;
import com.iacsd.dto.TeacherDesignation;
import com.iacsd.dto.TeacherProfile;
import com.iacsd.pojos.Teacher;
import com.iacsd.pojos.TeacherAttendance;
import com.iacsd.pojos.Users;

@Transactional
@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	UsersDao usersDao;

	@Autowired
	TeacherDao teacherDao;
	
	@Autowired
	TeacherAttendanceDao teacherAttendanceDao;
	
	@Override
	public TeacherProfile getProfile(Users user) {
		TeacherProfile teacherProfile = new TeacherProfile();
		teacherProfile.setDob(user.getDob());
		teacherProfile.setFirstName(user.getFirstName());
		teacherProfile.setGender(user.getGender());
		teacherProfile.setLastName(user.getLastName());
		teacherProfile.setLocality(user.getLocality());
		teacherProfile.setMobile(user.getMobile());
		teacherProfile.setPincode(user.getPincode());
		teacherProfile.setUserId(user.getUserId());
		teacherProfile.setUsername(user.getUsername());
		teacherProfile.setTypeJob(user.getTypeJob());
		Optional<Teacher> teacherDetails = teacherDao.findById(user.getUserId());
		if(!teacherDetails.isEmpty()) {
			teacherProfile.setDesignation(teacherDetails.get().getDesignation());
		}
		return teacherProfile;
	}

	@Override
	public void updateProfile(TeacherProfile tProfile) {
		Optional<Users> user = usersDao.findById(tProfile.getUserId());
		if(!user.isEmpty()) {
			Users u = user.get();
			u.setDob(tProfile.getDob());
			u.setFirstName(tProfile.getFirstName());
			u.setLastName(tProfile.getLastName());
			u.setMobile(tProfile.getMobile());
			u.setGender(tProfile.getGender());
			u.setLocality(tProfile.getLocality());
			u.setPincode(tProfile.getPincode());
			u.setUsername(tProfile.getUsername());
			System.out.println(u.toString());
			usersDao.save(u);
		}
		Teacher teacher = teacherDao.findByTeacherId(tProfile.getUserId());
		System.out.println(teacher);
		if(teacher != null) {
			teacher.setDesignation(tProfile.getDesignation());
		}else {
			Teacher t = new Teacher();
			t.setTeacherId(tProfile.getUserId());
			t.setDesignation(tProfile.getDesignation());
			teacherDao.save(t);
		}
	}

	@Override
	public Teacher findByTeacherId(int id) {
		return teacherDao.findByTeacherId(id);
	}

	@Override
	public List<TeacherDesignation> getTeachersForDesignation(List<Users> teacherList) {
		List<TeacherDesignation> designationList = new ArrayList<TeacherDesignation>();
		for (Users user : teacherList) {
			TeacherDesignation teacher = new TeacherDesignation();
			Teacher tProfile = teacherDao.findByTeacherId(user.getUserId());
			if(tProfile == null) {
				Teacher t = new Teacher();
				t.setTeacherId(user.getUserId());
				teacherDao.save(t);
				teacher.setDesignation(null);
			}else {
				teacher.setDesignation(tProfile.getDesignation());
			}
			teacher.setEmail(user.getEmail());
			teacher.setMobile(user.getMobile());
			teacher.setTeacherId(user.getUserId());
			teacher.setTeacherName(user.getFirstName() + " " + user.getLastName());
			designationList.add(teacher);
		}
		return designationList;
	}

	@Override
	public Teacher save(Teacher teacher) {
		return teacherDao.save(teacher);
	}

	@Override
	public List<TeacherDesignation> getWithIdAndDesig() {
		List<Teacher> teachers = teacherDao.findAll();
		List<TeacherDesignation> td = new ArrayList<TeacherDesignation>();
		for (Teacher teacher : teachers) {
			TeacherDesignation tDes = new TeacherDesignation();
			tDes.setTeacherId(teacher.getTeacherId());
			if(teacher.getDesignation() == null) {
				tDes.setDesignation("");
			}else {
				tDes.setDesignation(teacher.getDesignation());
			}
			
			Optional<Users> user = usersDao.findById(teacher.getTeacherId());
			if (user.isPresent()) {
				Users u = user.get();
				tDes.setTeacherName(u.getFirstName() + " " + u.getLastName());
			}
			td.add(tDes);
		}
		return td;
	}

	@Override
	public List<Teacher> findAll() {
		return teacherDao.findAll();
	}

	@Override
	public List<TeacherAttendanceRow> getTeachersForAttendance() {
		List<Teacher> teacherList = teacherDao.findAll();
		Date date = new Date();
		boolean flag = true;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String today = formatter.format(date);
		List<TeacherAttendanceRow> tAList = new ArrayList<TeacherAttendanceRow>();
		for (Teacher teacher : teacherList) {
			flag = true;
			List<TeacherAttendance> tList = teacherAttendanceDao.findByTeacherId(teacher.getTeacherId());
			if(!tList.isEmpty()) {
				//System.out.println("--------------------------------------");
				for (TeacherAttendance t : tList) {
					//System.out.println(t.toString());
					String studentFullDate = t.getDateOfAttendance().toString();
					String[] arrOfStr = studentFullDate.split(" ", 0);
					//System.out.println("Date of attendance "+arrOfStr[0]);
					//System.out.println("Today"+today);
					if(arrOfStr[0].equals(today)) {
						  flag = false;
						  //break;
					}
				}
				//System.out.println("--------------------------------------");
				//System.out.println("*******************************");
				if(flag) {
					TeacherAttendanceRow tRow = new TeacherAttendanceRow();
					tRow.setTeacherId(teacher.getTeacherId());
					tRow.setDesignation(teacher.getDesignation());
					Users user = usersDao.findByuserId(teacher.getTeacherId());
					tRow.setTeacherName(user.getFirstName() + " " + user.getLastName());
					System.out.println("Teacher got added");
					tAList.add(tRow);
				}
				//System.out.println("*******************************");
				
			}else {
				TeacherAttendanceRow tRow = new TeacherAttendanceRow();
				tRow.setTeacherId(teacher.getTeacherId());
				tRow.setDesignation(teacher.getDesignation());
				Users user = usersDao.findByuserId(teacher.getTeacherId());
				tRow.setTeacherName(user.getFirstName() + " " + user.getLastName());
				tAList.add(tRow);
			}
		}
		return tAList;
	}
}
