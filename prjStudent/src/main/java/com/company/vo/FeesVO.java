package com.company.vo;

public class FeesVO {
	
	private String id;
	private double amount;
	private String feesDate;
	private String studentId;
	private String batchId;
	private String studentFirstName;
	private String studentLastName;
	private String batchName;
	
	
	
	
	public FeesVO() {
		super();
	}
	public FeesVO(String id, double amount, String feesDate,
			String studentFirstName, String studentLastName, String batchName,String batchId, String studentId) {
		super();
		this.id = id;
		this.amount = amount;
		this.feesDate = feesDate;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.batchName = batchName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getFeesDate() {
		return feesDate;
	}
	public void setFeesDate(String feesDate) {
		this.feesDate = feesDate;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	
	
	
	
	

}
