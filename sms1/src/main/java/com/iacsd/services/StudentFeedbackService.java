package com.iacsd.services;

import java.util.List;

import com.iacsd.dto.FeedbackRow;
import com.iacsd.dto.FeedbackViewRow;
import com.iacsd.pojos.StudentFeedback;
import com.iacsd.pojos.Subjects;

public interface StudentFeedbackService {

	List<FeedbackRow> getFeedbackRows(List<Subjects> subjectList,int studentId);
	List<StudentFeedback> findByStudentId(int studentId);
	StudentFeedback save(StudentFeedback studentFeedback);
	List<StudentFeedback> findByTeacherId(int teacherId);
	List<FeedbackViewRow> getFeedbackViewRows(List<StudentFeedback> feedBackList);
	void deleteByFeedbackId(int Id);

}
