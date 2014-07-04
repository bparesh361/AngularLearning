package com.company.vo;

import java.io.Serializable;
import java.util.List;

public class DataTablesTO<T> implements Serializable {

	 private static final long serialVersionUID = -8220588043068200705L;

	private List<T> aaData;
	 private int sEcho;
	 private int iTotalRecords;
	 private int iTotalDisplayRecords;
	 
	public List<T> getAaData() {
		return aaData;
	}
	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}
	public int getsEcho() {
		return sEcho;
	}
	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	
	 
	
}
