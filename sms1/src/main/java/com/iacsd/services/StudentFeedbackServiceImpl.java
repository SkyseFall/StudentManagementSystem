package com.iacsd.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.daos.StudentDetailsDao;
import com.iacsd.daos.StudentFeedbackDao;
import com.iacsd.daos.UsersDao;
import com.iacsd.dto.FeedbackRow;
import com.iacsd.dto.FeedbackViewRow;
import com.iacsd.pojos.StudentDetails;
import com.iacsd.pojos.StudentFeedback;
import com.iacsd.pojos.Subjects;
import com.iacsd.pojos.Users;

@Transactional
@Service
public class StudentFeedbackServiceImpl implements StudentFeedbackService {
	@Autowired
	UsersDao usersDao;
	
	@Autowired
	StudentFeedbackDao sfDao;
	
	@Autowired
	StudentDetailsDao sdDao;

	@Override
	public List<FeedbackRow> getFeedbackRows(List<Subjects> subjectList,int studentId) {
		List<FeedbackRow> feedbackList = new ArrayList<FeedbackRow>();
		List<StudentFeedback> presentFeedbackForStudent = sfDao.findByStudentId(studentId);
		boolean flag = true;
		for (Subjects subject : subjectList) {
			//System.out.println(subject.toString());
			FeedbackRow row = new FeedbackRow();
			row.setTeacherId(subject.getTeacherId());
			Users user = usersDao.findByuserId(subject.getTeacherId());
			row.setTeacherName(user.getFirstName() + " " + user.getLastName());
			row.setSubjectName(subject.getSubjectName());
			row.setStudentId(studentId);
			if(!presentFeedbackForStudent.isEmpty()) {
				flag = true;
				for (StudentFeedback presentStudentFeedback : presentFeedbackForStudent) {
					//System.out.println("-----------------------------");
					//System.out.println(presentFeedbackForStudent.toString());
					//System.out.println("-----------------------------");
					if(presentStudentFeedback.getTeacherId() == subject.getTeacherId()) {
						//row.setFeedBackRatings(presentStudentFeedback.getFeedbackRatings());
						//row.setFeedbackRemarks(presentStudentFeedback.getFeedbackRemarks());
						flag = false;
						break;
					}
				}
				if(flag) {
					//System.out.println("I am here");
					row.setFeedBackRatings(-1);
					row.setFeedbackRemarks("");
					feedbackList.add(row);
				}
			}else {
				row.setFeedBackRatings(-1);
				row.setFeedbackRemarks("");
				feedbackList.add(row);
			}
			
		}
		return feedbackList;
	}

	@Override
	public List<StudentFeedback> findByStudentId(int studentId) {
		return sfDao.findByStudentId(studentId);
	}

	@Override
	public StudentFeedback save(StudentFeedback studentFeedback) {
		return sfDao.save(studentFeedback);
	}

	@Override
	public List<StudentFeedback> findByTeacherId(int teacherId) {
		return sfDao.findByTeacherId(teacherId);
	}

	@Override
	public List<FeedbackViewRow> getFeedbackViewRows(List<StudentFeedback> feedBackList) {
		List<FeedbackViewRow> presentList = new ArrayList<FeedbackViewRow>();
		for (StudentFeedback feedback : feedBackList) {
			FeedbackViewRow row = new FeedbackViewRow();
			row.setFeedbackId(feedback.getFeedbackId());
			row.setStudentId(feedback.getStudentId());
			Users student = usersDao.findByuserId(feedback.getStudentId());
			row.setStudentName(student.getFirstName()+" "+student.getLastName());
			StudentDetails sDetails = sdDao.findBystudentId(feedback.getStudentId());
			row.setStd(sDetails.getStd());
			List<Subjects> subList = sDetails.getSubjectList();
			for (Subjects subject : subList) {
				if(subject.getTeacherId() == feedback.getTeacherId()) {
					row.setSubjectName(subject.getSubjectName());
				}
			}
			row.setFeedbackRemarks(feedback.getFeedbackRemarks());
			row.setFeedbackRatings(feedback.getFeedbackRatings());
			presentList.add(row);
		}
		return presentList;
	}

	@Override
	public void deleteByFeedbackId(int Id) {
		sfDao.deleteByFeedbackId(Id);
	}

}
