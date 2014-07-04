package com.company.vo;

public class CollegeVO {

	private String id;
	private String collegeName;
	
	public CollegeVO() {
		super();
	}
	
	public CollegeVO(String id, String collegeName) {
		super();
		this.id = id;
		this.collegeName = collegeName;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	
	
}
