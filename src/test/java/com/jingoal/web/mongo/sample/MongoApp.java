package com.jingoal.web.mongo.sample;

import java.util.List;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Update.update;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.jingoal.web.mongodb.sample.model.Person;
import com.mongodb.Mongo;

public class MongoApp {

	private static final Logger log = LoggerFactory.getLogger(MongoApp.class);

	public static void main(String[] args) throws Exception {

		MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new Mongo(), "mongodb-simple"));

		Person p = new Person("Joe", 34);

		// Insert is used to initially store the object into the database.
		mongoOps.insert(p);
		log.info("Insert: " + p);
		System.err.println(p);

		// Find
		p = mongoOps.findById(p.getId(), Person.class);
		log.info("Found: " + p);
		System.err.println(p);

		// Update
		mongoOps.updateFirst(query(where("name").is("Joe")), update("age", 35), Person.class);
		p = mongoOps.findOne(query(where("name").is("Joe")), Person.class);
		log.info("Updated: " + p);
		System.err.println(p);

		// Delete
		mongoOps.remove(p);

		// Check that deletion worked
		List<Person> people = mongoOps.findAll(Person.class);
		log.info("Number of people = : " + people.size());

		mongoOps.dropCollection(Person.class);
	}
}