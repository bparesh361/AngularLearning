package com.company.mongo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Id;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="discussion")
@TypeAlias("disc")
public class Discussion {

	@Id
	private String id;
	
	@Field("discussionName")
	@Indexed
	private String discussionName;
	
	private Set<Reply> replies = new HashSet<Reply>();

	public Discussion() {		
		
	}

	public Discussion(String discussionName) {		
		this.discussionName = discussionName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDiscussionName() {
		return discussionName;
	}

	public void setDiscussionName(String discussionName) {
		this.discussionName = discussionName;
	}
	
	public Set<Reply> getReplies() {
		return replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

	@Override
	public String toString() {
		return "Discussion [id=" + id + ", discussionName=" + discussionName
				+ "]";
	}
	
	
	
	
	
	
}
