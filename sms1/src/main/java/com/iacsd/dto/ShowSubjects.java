package com.iacsd.dto;

public class ShowSubjects {

	
		private String subjectCode;
		private String subjectName;
		private int maxMarks;
		private int maxAssignmentMarks;
		private String teacherName;
		private int teacherId;
		
		
		public ShowSubjects() {
		}


		public ShowSubjects(String subjectCode, String subjectName, int maxMarks, int maxAssignmentMarks,
				String teacherName) {
			this.subjectCode = subjectCode;
			this.subjectName = subjectName;
			this.maxMarks = maxMarks;
			this.maxAssignmentMarks = maxAssignmentMarks;
			this.teacherName = teacherName;
		}
		


		public ShowSubjects(String subjectCode, String subjectName, int maxMarks, int maxAssignmentMarks,
				String teacherName, int teacherId) {
			this.subjectCode = subjectCode;
			this.subjectName = subjectName;
			this.maxMarks = maxMarks;
			this.maxAssignmentMarks = maxAssignmentMarks;
			this.teacherName = teacherName;
			this.teacherId = teacherId;
		}


		public String getSubjectCode() {
			return subjectCode;
		}


		public void setSubjectCode(String subjectCode) {
			this.subjectCode = subjectCode;
		}


		public String getSubjectName() {
			return subjectName;
		}


		public void setSubjectName(String subjectName) {
			this.subjectName = subjectName;
		}


		public int getMaxMarks() {
			return maxMarks;
		}


		public void setMaxMarks(int maxMarks) {
			this.maxMarks = maxMarks;
		}


		public int getMaxAssignmentMarks() {
			return maxAssignmentMarks;
		}


		public void setMaxAssignmentMarks(int maxAssignmentMarks) {
			this.maxAssignmentMarks = maxAssignmentMarks;
		}


		public String getTeacherName() {
			return teacherName;
		}


		public void setTeacherName(String teacherName) {
			this.teacherName = teacherName;
		}

		

		public int getTeacherId() {
			return teacherId;
		}


		public void setTeacherId(int teacherId) {
			this.teacherId = teacherId;
		}


		@Override
		public String toString() {
			return "ShowSubjects [subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", maxMarks="
					+ maxMarks + ", maxAssignmentMarks=" + maxAssignmentMarks + ", teacherName=" + teacherName + "]";
		}

}
