package com.iacsd.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iacsd.daos.MarksDao;
import com.iacsd.daos.SubjectsDao;
import com.iacsd.dto.MarksRow;
import com.iacsd.dto.StudentIdentity;
import com.iacsd.pojos.Marks;
import com.iacsd.pojos.Subjects;

@Transactional
@Service
public class MarksServiceImpl implements MarksService {
	@Autowired
	MarksDao marksDao;
	
	@Autowired
	SubjectsDao sDao;

	@Override
	public List<Marks> findByStudentId(int id) {
		return marksDao.findByStudentId(id);
	}

	@Override
	public Marks save(Marks marks) {
		return marksDao.save(marks);
	}
	

	@Override
	public Marks marksForFileUpload(StudentIdentity sIdentity) {
		List<Marks> subjectsMarks = marksDao.findByStudentId(sIdentity.getStudentId());
		Marks mark = null;
		
		if(!subjectsMarks.isEmpty()) {
			System.out.println(subjectsMarks.toString());
			for (Marks m : subjectsMarks) {
				if(m.getSubjectCode().equals(sIdentity.getsName())) {
					mark = m;
					break;
				}
			}
			System.out.println(mark.toString());
		}
		return mark;
	}

	@Override
	public void deletePreviousRecord(int id, String sCode) {
		List<Marks> list = marksDao.findByStudentId(id);
		for (Marks mark : list) {
			if(mark.getSubjectCode().equals(sCode)) {
				marksDao.delete(mark);
			}
		}
	}

	@Override
	public List<MarksRow> fetchAssignments(int studentId) {
		List<Marks> studentMarks = marksDao.findByStudentId(studentId);
		List<MarksRow> list = new ArrayList<MarksRow>();
		for (Marks mark : studentMarks) {
			MarksRow row = new MarksRow();
			row.setAssignmentMarks(mark.getAssignmentMarks());
			row.setAssignmentSolution(mark.getAssignmentSolution());
			row.setSubjectCode(mark.getSubjectCode());
			Subjects sub = sDao.findBySubjectCode(mark.getSubjectCode());
			row.setSubjectName(sub.getSubjectName());
			row.setSubmissionTime(mark.getSubmissionTime().toLocaleString());
			row.setMaxAssignmentMarks(sub.getMaxAssignmentMarks());
			list.add(row);
		}
		return list;
	}
	
	
	
}
