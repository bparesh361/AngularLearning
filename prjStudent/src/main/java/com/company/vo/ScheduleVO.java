package com.company.vo;

public class ScheduleVO {
	
	private String id;
	private String batchName;
	private String date;
	private String description;
	private String startTime;
	private String endTime;
	
	public ScheduleVO(String id, String batchName, String date,
			String description, String startTime, String endTime) {
		super();
		this.id = id;
		this.batchName = batchName;
		this.date = date;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public ScheduleVO() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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

}
