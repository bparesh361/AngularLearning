package com.company.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="batch")
public class Batch {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="batch_id")
	private int id;
	
	@Column(name="batch_name")
	private String batchName;
	
	@Column(name="start_date")
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date startDate;
	
	@ManyToMany
	@JoinTable(
			name="batch_faculty",joinColumns=@JoinColumn(name="batch_id"),
			inverseJoinColumns=@JoinColumn(name="faculty_id")
			)
	private List<Faculty> faculties = new ArrayList<Faculty>();
	
	@ManyToMany
	@JoinTable(
			name="batch_student",joinColumns=@JoinColumn(name="batch_id"),
			inverseJoinColumns=@JoinColumn(name="student_id")
			)
	private List<Student> students = new ArrayList<Student>();

	public Batch(int id, String batchName, Date startDate) {
		super();
		this.id = id;
		this.batchName = batchName;
		this.startDate = startDate;
	}	

	public Batch(String batchName, Date startDate) {
		super();
		this.batchName = batchName;
		this.startDate = startDate;
	}

	public Batch() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(List<Faculty> faculties) {
		this.faculties = faculties;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	
	

}
