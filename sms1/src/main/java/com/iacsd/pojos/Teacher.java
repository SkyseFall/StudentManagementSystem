package com.iacsd.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {
	@Id
	@Column(name = "teacher_id")
	private int teacherId;
	
	private String designation;
	
	private int salary;
	
	public Teacher() {
	}

	

	public int getSalary() {
		return salary;
	}



	public void setSalary(int salary) {
		this.salary = salary;
	}



	public Teacher(int teacherId, String designation, int salary) {
		this.teacherId = teacherId;
		this.designation = designation;
		this.salary = salary;
	}



	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}



	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", designation=" + designation + ", salary=" + salary + "]";
	}

	

}
