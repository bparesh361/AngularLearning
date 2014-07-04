package com.company.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="material")
public class Material {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="file1_name")
	private String file1Name;
	
	@Column(name="file1_content_type")
	private String file1ContentType;
	
	@Column(name="file1_content")
	private Blob file1Data;
	
	@Column(name="file2_name")
	private String file2Name;
	
	@Column(name="file2_content_type")
	private String file2ContentType;
	
	@Column(name="file2_content")
	private Blob file2Data;
	
	@ManyToOne
	@JoinColumn(name="schedule_id")
	private Schedule schedule;	

	public Material(String file1Name, String file1ContentType, Blob file1Data,
			String file2Name, String file2ContentType, Blob file2Data) {		
		this.file1Name = file1Name;
		this.file1ContentType = file1ContentType;
		this.file1Data = file1Data;
		this.file2Name = file2Name;
		this.file2ContentType = file2ContentType;
		this.file2Data = file2Data;
	}

	public Material() {		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFile1Name() {
		return file1Name;
	}

	public void setFile1Name(String file1Name) {
		this.file1Name = file1Name;
	}

	public String getFile1ContentType() {
		return file1ContentType;
	}

	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}

	public Blob getFile1Data() {
		return file1Data;
	}

	public void setFile1Data(Blob file1Data) {
		this.file1Data = file1Data;
	}

	public String getFile2Name() {
		return file2Name;
	}

	public void setFile2Name(String file2Name) {
		this.file2Name = file2Name;
	}

	public String getFile2ContentType() {
		return file2ContentType;
	}

	public void setFile2ContentType(String file2ContentType) {
		this.file2ContentType = file2ContentType;
	}

	public Blob getFile2Data() {
		return file2Data;
	}

	public void setFile2Data(Blob file2Data) {
		this.file2Data = file2Data;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
}
