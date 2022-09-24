package com.iacsd.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.daos.MarksDao;
import com.iacsd.daos.SubjectsDao;
import com.iacsd.daos.UsersDao;
import com.iacsd.dto.MarksRow;
import com.iacsd.dto.SubWithTeacher;
import com.iacsd.pojos.Marks;
import com.iacsd.pojos.StudentDetails;
import com.iacsd.pojos.Subjects;
import com.iacsd.pojos.Users;

@Transactional
@Service
public class SubjectsServiceImpl implements SubjectsService {
	@Autowired
	SubjectsDao subjectDao;
	
	@Autowired
	UsersDao usersDao;
	
	@Autowired
	MarksDao marksDao;

	@Override
	public Subjects save(Subjects subject) {
		return subjectDao.save(subject);
	}

	@Override
	public Subjects findBySubjectCode(String subjectcode) {
		return subjectDao.findBySubjectCode(subjectcode);
	}

	@Override
	public List<Subjects> findAll() {
		return subjectDao.findAll();
	}

	@Override
	public List<SubWithTeacher> fetchTeachers(List<Subjects> list) {
		List<SubWithTeacher> subT = new ArrayList<SubWithTeacher>();
		for (Subjects subject : list) {
			SubWithTeacher st = new SubWithTeacher();
			st.setSubjectCode(subject.getSubjectCode());
			st.setSubjectName(subject.getSubjectName());
			st.setStd(subject.getStd());
			Users teacher = usersDao.findByuserId(subject.getTeacherId());
			if(teacher != null) {
				String teacher_name = teacher.getFirstName() + " " + teacher.getLastName();
				st.settName(teacher_name);
			}else {
				st.settName("Not Assigned");
			}
			subT.add(st);
		}
		return subT;
	}

	@Override
	public List<Subjects> findByStd(String std) {
		return subjectDao.findByStd(std);
	}

	@Override
	public List<Subjects> findByTeacherId(int id) {
		 List<Subjects> findByTeacherId = subjectDao.findByTeacherId(id);
		 System.out.println("findByTeacherId  : "+findByTeacherId);
		return findByTeacherId;
	}

	@Override
	public List<MarksRow> fetchMarkRows(Subjects subject) {
		List<MarksRow> marksRow = new ArrayList<MarksRow>();
		 List<StudentDetails> stuList = subject.getStudentDetailsList();
		 for (StudentDetails sDetail : stuList) {
			 System.out.println("------------------------");
			 System.out.println(sDetail.toString());
			MarksRow row = new MarksRow();
			row.setStudentId(sDetail.getStudentId());
			Users user = usersDao.findByuserId(sDetail.getStudentId());
			row.setStudentName(user.getFirstName()+" "+user.getLastName());
			row.setRollNo(sDetail.getRollNo());
			row.setSubjectCode(subject.getSubjectCode());
			row.setMarks(-1);
			row.setAssignmentMarks(-1);
			row.setSubmissionTime("Not Submitted Yet");
			Marks mark = null;
			List<Marks> listMarks = marksDao.findByStudentId(sDetail.getStudentId());
			if(!listMarks.isEmpty()) {
				for (Marks m : listMarks) {
					if(m.getSubjectCode().equals(subject.getSubjectCode())) {
						mark = m;
						row.setMarks(m.getMarks());
						row.setAssignmentMarks(m.getAssignmentMarks());
						row.setAssignmentSolution(m.getAssignmentSolution());
						if(m.getAssignmentSolution() != null) {
							row.setSubmissionTime(m.getSubmissionTime().toLocaleString());
						}
						break;
					}
				}
			}
			row.setMaxMarks(subject.getMaxMarks());
			row.setMaxAssignmentMarks(subject.getMaxAssignmentMarks());
			marksRow.add(row);
		}
		return marksRow;
	}

}
