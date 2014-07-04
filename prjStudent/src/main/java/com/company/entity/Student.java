package com.company.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="student")
@NamedQuery(name="Student.findByBatchId", query="select s from Student s inner join s.batches b where b=?1")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="college_name")
	private String collegeName;
	
	
	@ManyToMany
	@JoinTable(
			name="batch_student",joinColumns=@JoinColumn(name="student_id"),
			inverseJoinColumns=@JoinColumn(name="batch_id")
			)
	private List<Batch> batches = new ArrayList<Batch>();
	
	public Student() {
		super();
	}
	
	public Student(String firstName, String lastName, String email,
			boolean isActive,String collegeName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isActive = isActive;	
		this.collegeName = collegeName;
	}

	public Student(int id, String firstName, String lastName,String email,
			boolean isActive,String collegeName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isActive = isActive;
		this.collegeName = collegeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Batch> getBatches() {
		return batches;
	}

	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}	

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	
}
