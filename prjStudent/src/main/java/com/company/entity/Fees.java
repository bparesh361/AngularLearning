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

@Table(name="fees")
@Entity
public class Fees {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="fees_date")
	private Date feesDate;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name="batch_id")
	private Batch batch;	
	
	public Fees(double amount, Date feesDate) {
		super();
		this.amount = amount;
		this.feesDate = feesDate;
	}

	public Fees() {
		super();
	}

	public Fees(int id, double amount, Date feesDate) {
		super();
		this.id = id;
		this.amount = amount;
		this.feesDate = feesDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getFeesDate() {
		return feesDate;
	}

	public void setFeesDate(Date feesDate) {
		this.feesDate = feesDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
	
	
	
}
