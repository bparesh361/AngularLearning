package com.company.vo;

import java.util.List;

public class AtttendenceListVO {
	
	private int draw;
	private int recordsTotal;
	private int recordsFiltered;
	
	private List<AttendenceVO> data;

	public List<AttendenceVO> getData() {
		return data;
	}

	public void setData(List<AttendenceVO> data) {
		this.data = data;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	
	
	
	
	

}
