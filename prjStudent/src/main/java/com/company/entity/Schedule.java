package com.company.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="schedule")
@NamedQuery(name="Schedule.findByBatchId", query="select s from Schedule s inner join s.batch b where b=?1")
public class Schedule {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="start_time")
	private String startTime;
	
	@Column(name="end_time")
	private String endTime;
	
	@Column(name="batch_date")
	private Date bDate;
	
	@Column(name="description")
	private String description;
		
	@ManyToOne
	@JoinColumn(name="batch_id")
	private Batch batch;
	
	
	public Schedule(String startTime, String endTime, Date bDate, String description) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.bDate = bDate;
		this.description = description;
	}
	
	public Schedule() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public Date getbDate() {
		return bDate;
	}
	
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	
	public Batch getBatch() {
		return batch;
	}
	
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}	
	
}
