package com.jingoal.web.mongodb.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

@Configuration
public class AppConfig {

	public @Bean Mongo mongo() throws Exception {
		return new Mongo("localhost");
	}

	public @Bean MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), "mydatabase");
	}
}