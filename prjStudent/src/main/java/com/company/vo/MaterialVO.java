package com.company.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MaterialVO {
	
	private String id;
	private String batchId;
	private String scheduleId;
	private String batchName;
	private String batchDate;
	private List<MultipartFile> files;
	private int noFileUpload;
	
	

	public MaterialVO() {		
	}

	public MaterialVO(String id, String batchName, String batchDate) {		
		this.id = id;
		this.batchName = batchName;
		this.batchDate = batchDate;		
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getBatchDate() {
		return batchDate;
	}

	public void setBatchDate(String batchDate) {
		this.batchDate = batchDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNoFileUpload() {
		return noFileUpload;
	}

	public void setNoFileUpload(int noFileUpload) {
		this.noFileUpload = noFileUpload;
	}


	

	
	
	
}
