package com.iacsd.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iacsd.daos.SubjectsDao;
import com.iacsd.daos.TeacherAssignmentDao;
import com.iacsd.dto.TeacherAssignmentRow;
import com.iacsd.pojos.Subjects;
import com.iacsd.pojos.TeacherAssignment;
import com.iacsd.utils.DiskStorageServiceImpl;

@Transactional
@Service
public class TeacherAssignmentServiceImpl implements TeacherAssignmentService {
    @Autowired
	DiskStorageServiceImpl storageService ;
    @Autowired
    TeacherAssignmentDao dao;
    @Autowired
    SubjectsDao sDao;
    
	@Override
	public TeacherAssignment saveNewMenu(TeacherAssignment menu, MultipartFile added_assignment) {
		String filename = storageService.store(added_assignment);
		menu.setAddedAssignment(filename);
		System.out.println(menu);
		return dao.save(menu);
	}

	@Override
	public TeacherAssignment findByAssignmentId(int assignmentid) {
		return dao.findByAssignmentId(assignmentid);
	}

	@Override
	public TeacherAssignment save(TeacherAssignment teacherAssignment) {
		return dao.save(teacherAssignment);
	}

	@Override
	public List<TeacherAssignment> findByTeacherId(int id) {
		return dao.findByTeacherId(id);
	}

	@Override
	public List<TeacherAssignmentRow> getAssignmentList(List<TeacherAssignment> list) {
		List<TeacherAssignmentRow> finalList = new ArrayList<TeacherAssignmentRow>();
		for (TeacherAssignment tAssignment : list) {
			TeacherAssignmentRow row = new TeacherAssignmentRow();
			row.setSubjectCode(tAssignment.getSubjectCode());
			row.setAddedAssignment(tAssignment.getAddedAssignment());
			if(tAssignment.getAssignmentDue() != null) {
				String FullDate = tAssignment.getAssignmentDue().toString();
				String[] arrOfStr = FullDate.split(" ", 0);
				row.setAssignmentDue(arrOfStr[0]);
			}
			if(tAssignment.getSubmissionTime() != null) {
				String FullDate = tAssignment.getSubmissionTime().toString();
				String[] arrOfStr = FullDate.split(" ", 0);
				row.setSubmissionTime(arrOfStr[0]);
			}
			Subjects subject = sDao.findBySubjectCode(tAssignment.getSubjectCode());
			row.setStd(subject.getStd());
			row.setSubjectName(subject.getSubjectName());
			row.setAssignmentId(tAssignment.getAssignmentId());
			finalList.add(row);
		}
		
		return finalList;
	}

	@Override
	public List<TeacherAssignmentRow> fetchAssignmentListBySubjects(List<Subjects> subjects) {
		
		List<TeacherAssignmentRow> finalList = new ArrayList<TeacherAssignmentRow>();
		for (Subjects subject : subjects) {
			List<TeacherAssignment> assignment = dao.findBySubjectCode(subject.getSubjectCode());
			for (TeacherAssignment AssignmentRow : assignment) {
				TeacherAssignmentRow row = new TeacherAssignmentRow();
				row.setSubjectCode(subject.getSubjectCode());
				row.setSubjectName(subject.getSubjectName());
				row.setStd(subject.getStd());
				row.setAddedAssignment(AssignmentRow.getAddedAssignment());
				if(AssignmentRow.getAssignmentDue() != null) {
					String FullDate = AssignmentRow.getAssignmentDue().toString();
					String[] arrOfStr = FullDate.split(" ", 0);
					row.setAssignmentDue(arrOfStr[0]);
				}
				if(AssignmentRow.getSubmissionTime() != null) {
					String FullDate = AssignmentRow.getSubmissionTime().toString();
					String[] arrOfStr = FullDate.split(" ", 0);
					row.setSubmissionTime(arrOfStr[0]);
				}
				row.setAssignmentId(AssignmentRow.getAssignmentId());
				finalList.add(row);
			}
		}
		return finalList;
	}

	@Override
	public List<TeacherAssignment> findBySubjectCode(String subjectCode) {
		return dao.findBySubjectCode(subjectCode);
	}
	
	

}
