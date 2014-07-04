package com.company.vo;

import java.util.ArrayList;
import java.util.List;

public class BatchVO {

	private String id;
	private String batchName;
	private String startDate;
	
	private List<FacultyVO> faculties = new ArrayList<FacultyVO>();
	
	private List<StudentVO> students = new ArrayList<StudentVO>();

	public BatchVO() {
		super();
	}

	public BatchVO(String batchName, String startDate) {
		super();
		this.batchName = batchName;
		this.startDate = startDate;
	}	

	public BatchVO(String id, String batchName, String startDate) {
		super();
		this.id = id;
		this.batchName = batchName;
		this.startDate = startDate;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<FacultyVO> getFaculties() {
		if(faculties==null){
			faculties = new ArrayList<FacultyVO>();
		}
		return faculties;
	}

	public void setFaculties(List<FacultyVO> faculties) {
		this.faculties = faculties;
	}

	public List<StudentVO> getStudents() {
		return students;
	}

	public void setStudents(List<StudentVO> students) {
		this.students = students;
	}
	
	
	

}
