package com.iacsd.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.daos.MarksDao;
import com.iacsd.daos.StudentDetailsDao;
import com.iacsd.daos.UsersDao;
import com.iacsd.dto.FeeRecordRow;
import com.iacsd.dto.MarksDetails;
import com.iacsd.dto.MarksRow;
import com.iacsd.dto.Marksheet;
import com.iacsd.dto.StudentDetailsWithName;
import com.iacsd.dto.StudentProfile;
import com.iacsd.pojos.Marks;
import com.iacsd.pojos.StudentDetails;
import com.iacsd.pojos.Subjects;
import com.iacsd.pojos.Users;

@Transactional
@Service
public class StudentDetailsServiceImpl implements StudentDetailsService {
	@Autowired
	UsersDao usersDao;

	@Autowired
	StudentDetailsDao studentDetailsDao;

	@Autowired
	MarksDao marksDao;

	@Override
	public StudentProfile getProfile(Users user) {
		StudentProfile profile = new StudentProfile();
		profile.setUserId(user.getUserId());
		profile.setFirstName(user.getFirstName());
		profile.setLastName(user.getLastName());
		profile.setGender(user.getGender());
		profile.setLocality(user.getLocality());
		profile.setMobile(user.getMobile());
		profile.setPincode(user.getPincode());
		profile.setUsername(user.getUsername());
		profile.setDob(user.getDob());
		profile.setTypeJob(user.getTypeJob());
		// System.out.println("User = "+user);
		// System.out.println("------------------------------------------------------------------------------------------");
		// System.out.println(user.getUserId());
		StudentDetails studentDetails = studentDetailsDao.findBystudentId(user.getUserId());
		// System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("StudentDetails = " + studentDetails);
		// System.out.println("------------------------------------------------------------------------------------------");
		if (studentDetails != null) {
			profile.setStd(studentDetails.getStd());
			profile.setSection(studentDetails.getSection());
		}
		System.out.println(profile);
		return profile;
	}

	@Override
	public void updateProfile(StudentProfile sProfile) {
		Optional<Users> opUser = usersDao.findById(sProfile.getUserId());
		if (!opUser.isEmpty()) {
			Users user = opUser.get();
			user.setFirstName(sProfile.getFirstName());
			user.setLastName(sProfile.getLastName());
			user.setGender(sProfile.getGender());
			user.setLocality(sProfile.getLocality());
			user.setDob(sProfile.getDob());
			user.setMobile(sProfile.getMobile());
			user.setPincode(sProfile.getPincode());
			user.setUsername(sProfile.getUsername());
		}
		StudentDetails sDetails = studentDetailsDao.findBystudentId(sProfile.getUserId());
		if (sDetails != null) {
			sDetails.setSection(sProfile.getSection());
			sDetails.setStd(sProfile.getStd());
			studentDetailsDao.save(sDetails);
		} else {
			StudentDetails studentDetails = new StudentDetails();
			studentDetails.setStudentId(sProfile.getUserId());
			studentDetails.setStd(sProfile.getStd());
			studentDetails.setSection(sProfile.getSection());
			studentDetailsDao.save(studentDetails);
		}
	}

	@Override
	public StudentDetails save(StudentDetails studentDetails) {
		return studentDetailsDao.save(studentDetails);
	}

	@Override
	public StudentDetails findBystudentId(int userId) {
		return studentDetailsDao.findBystudentId(userId);
	}

	@Override
	public List<StudentDetailsWithName> getStudentDetails(List<Users> list) {
		List<StudentDetailsWithName> detailsList = new ArrayList<StudentDetailsWithName>();
		for (Users u : list) {
			StudentDetailsWithName sD = new StudentDetailsWithName();
			int userId = u.getUserId();
			StudentDetails sDetails = studentDetailsDao.findBystudentId(userId);
			if (sDetails != null) {
				sD.setRollNo(sDetails.getRollNo());
				sD.setSection(sDetails.getSection());
				sD.setStd(sDetails.getStd());
				sD.setStudentId(userId);
				sD.setStudentName(u.getFirstName() + " " + u.getLastName());
			} else {
				sD.setStudentId(userId);
				sD.setStudentName(u.getFirstName() + " " + u.getLastName());
			}
			detailsList.add(sD);
		}
		return detailsList;
	}

	@Override
	public void deleteByStudentId(int Id) {
		studentDetailsDao.deleteByStudentId(Id);
	}

	@Override
	public void deleteByRollNo(int rollNo) {
		studentDetailsDao.deleteByRollNo(rollNo);
	}

	@Override
	public List<StudentDetails> findByStd(String std) {
		return studentDetailsDao.findByStd(std);
	}

	@Override
	public List<StudentDetails> findAll() {
		return studentDetailsDao.findAll();
	}

	@Override
	public List<FeeRecordRow> getFeeRecords(List<StudentDetails> studentList) {
		List<FeeRecordRow> feeRecords = new ArrayList<FeeRecordRow>();
		for (StudentDetails sDetails : studentList) {
			FeeRecordRow row = new FeeRecordRow();
			row.setStudentId(sDetails.getStudentId());
			Users user = usersDao.findByuserId(sDetails.getStudentId());
			row.setStudentName(user.getFirstName() + " " + user.getLastName());
			row.setStd(sDetails.getStd());
			row.setMobile(user.getMobile());
			row.setEmail(user.getEmail());
			row.setGender(user.getGender());
			row.setFees(sDetails.getFees());
			feeRecords.add(row);
		}
		return feeRecords;
	}

	@Override
	public List<Users> fetchUsers(List<StudentDetails> sDetails) {
		List<Users> usersList = new ArrayList<Users>();
		for (StudentDetails studentDetail : sDetails) {
			Users user = new Users();
			user = usersDao.findByuserId(studentDetail.getStudentId());
			usersList.add(user);
		}
		return usersList;
	}

	@Override
	public List<MarksDetails> fetchMarkDetails(StudentDetails sDetail) {
		List<Subjects> subjectList = sDetail.getSubjectList();
		System.out.println("subjectList : "+subjectList);
		List<MarksDetails> marksDetailsList = new ArrayList<MarksDetails>();
		for (Subjects subject : subjectList) {
			MarksDetails marksDetails = new MarksDetails();
			marksDetails.setSubjectCode(subject.getSubjectCode());
			marksDetails.setMaxMarks(subject.getMaxMarks());
			marksDetails.setMaxAssignmentMarks(subject.getMaxAssignmentMarks());
			marksDetails.setSubjectName(subject.getSubjectName());
			List<Marks> marksList = marksDao.findByStudentId(sDetail.getStudentId());
			for (Marks marks : marksList) {
				if (marks.getSubjectCode().equals(subject.getSubjectCode())) {
					marksDetails.setMarks(marks.getMarks());
					marksDetails.setAssignmentMarks(marks.getAssignmentMarks());
					marksDetails.setMarksheetId(marks.getMarksheetId());
					if ((marks.getMarks() + marks.getAssignmentMarks()) < (0.4
							* (subject.getMaxMarks() + subject.getMaxAssignmentMarks()))) {
						marksDetails.setStatus("FAIL");
					} else {
						marksDetails.setStatus("PASS");
					}
				}
			}
			// System.out.println("---------------------------------");
			System.out.println(marksDetails.toString());
			marksDetailsList.add(marksDetails);
		}
		return marksDetailsList;
	}

	@Override
	public Marksheet fetchMarksheet(StudentDetails sDetail, List<MarksDetails> mDetails) {
		Marksheet marksheet = new Marksheet();
		marksheet.setUserId(sDetail.getStudentId());
		marksheet.setRollNo(sDetail.getRollNo());
		marksheet.setStd(sDetail.getStd());
		marksheet.setSection(sDetail.getSection());
		Users user = usersDao.findByuserId(sDetail.getStudentId());
		marksheet.setStudentName(user.getFirstName() + " " + user.getLastName());
		marksheet.setDob(user.getDob());
		marksheet.setGender(user.getGender());
		System.out.println("-------------------------------");
		System.out.println("marksheet : "+marksheet.toString());
		int maxTotal = 0;
		int total = 0;
		boolean flagPogress = false;
		boolean flagStatus = true;
		String status = "PASS";

		for (MarksDetails marksDetail : mDetails) {
			maxTotal = maxTotal + marksDetail.getMaxMarks() + marksDetail.getMaxAssignmentMarks();
			total = total + marksDetail.getMarks() + marksDetail.getAssignmentMarks();
			if (marksDetail.getStatus() == null) {
				flagPogress = true;
			} else if (!marksDetail.getStatus().equals("PASS")) {
				flagStatus = false;
			}
		}
		if (flagStatus) {
			if (flagPogress) {
				status = "IN PROGRESS";
			} else {
				status = "PASS";
			}
		} else {
			status = "FAIL";
		}
		marksheet.setMaxTotal(maxTotal);
		marksheet.setTotal(total);
		marksheet.setOverallStatus(status);
		float percentage = ((float) total / (float) maxTotal) * 100;
		marksheet.setPercentage(percentage);
		System.out.println("-------------------------------");
		System.out.println(marksheet.toString());
		return marksheet;
	}

}
