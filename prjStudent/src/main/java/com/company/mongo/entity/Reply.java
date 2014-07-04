package com.company.mongo.entity;


public class Reply {	
		
	public Reply(String text) {
		super();
		this.text = text;
	}
	private String text;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	

}
