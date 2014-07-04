package com.company.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="attendence")
public class Attendence {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="batch_id")
	private Batch batch;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="faculty_id")
	private Faculty faculty;
	
	@Column(name="a_date")
	private Date attendenceDate;

	public Attendence() {
		super();
	}

	public Attendence(Date attendenceDate) {
		super();
		this.attendenceDate = attendenceDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Date getAttendenceDate() {
		return attendenceDate;
	}

	public void setAttendenceDate(Date attendenceDate) {
		this.attendenceDate = attendenceDate;
	}
	
	
}
