package com.company.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.company.mongo.entity.Discussion;

@Component
public class DiscussionDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Discussion> unansweredDiscussions(){
		Query query = new Query();
		query.addCriteria(Criteria.where("replies").size(0));
		return mongoTemplate.find(query, Discussion.class);		
	}
	
	public List<Discussion> searchQuestionByText(String qText){
		Query query = new Query();
		query.addCriteria(Criteria.where("discussionName").regex(qText,"i"));
		return mongoTemplate.find(query, Discussion.class);		
	}
	
}
