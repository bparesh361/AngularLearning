package com.company.mongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.company.mongo.entity.Discussion;

public interface DiscussionForumRepository extends MongoRepository<Discussion, String>{

	public List<Discussion> findDiscussionByDiscussionName(String question);
	
}
