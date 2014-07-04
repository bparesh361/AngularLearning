package com.company.vo;

public class DiscussionVO {

	private String id;
	private String question;	
	private String reply;
	
	public DiscussionVO() {
		super();
	}

	public DiscussionVO(String question) {
		super();
		this.question = question;
	}
	
	

	public DiscussionVO(String id, String question) {
		super();
		this.id = id;
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}
	
}
