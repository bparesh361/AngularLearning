package com.company.conf;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.core.convert.converter.Converter;

import com.mongodb.Mongo;


@Configuration
@ComponentScan(basePackages="com.company.mongo.converters")
@EnableMongoRepositories(basePackages="com.company.mongo.repositories")
public class MongoConfiguration extends AbstractMongoConfiguration {
	
	@Autowired
	private List<Converter<?,?>> converters;
	
	public @Bean MongoTemplate mongoTemplate(Mongo mongo) throws Exception {		
		return new MongoTemplate(mongo,"student");		
	}
	
	public @Bean Mongo mongo() throws UnknownHostException {
		return new Mongo("localhost");
	}

	@Override
	protected String getDatabaseName() {
		return "student";
	}

	@Override
	public CustomConversions customConversions() {
		return new CustomConversions(converters);
	}
		
	
	
}
