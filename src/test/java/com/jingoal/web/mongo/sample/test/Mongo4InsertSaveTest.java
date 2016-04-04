package com.jingoal.web.mongo.sample.test;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jingoal.web.mongodb.sample.model.Person;

@ContextConfiguration(locations = "classpath:root-context.xml")
public class Mongo4InsertSaveTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@BeforeClass
	public void clearCollection(){
		mongoTemplate.dropCollection(Person.class);
	}
	
	@AfterClass
	public void destoryCollection(){
		mongoTemplate.dropCollection(Person.class);
	}

	/**
	 * @description: mongodb insert test case
	 * 
	 * @author: chenbin
	 * @time: 2016年4月4日 下午9:28:26
	 */
	@Test
	public void insertTest() {
		Person p = new Person("Bob", 33);
		mongoTemplate.insert(p);
		
		BasicQuery query = new BasicQuery("{ age : { $eq : 33 } }");
		Person qp = mongoTemplate.findOne(query, Person.class);
		Assert.assertNotNull(qp);
	}
	
	@Test
	public void saveTest(){
		Person chen = new Person("chenbin", 26);
		mongoTemplate.insert(chen);
		
		Person qp = mongoTemplate.findOne(query(where("name").is("chenbin")), Person.class);
		Assert.assertNotNull(qp);
		
		Person zhang = new Person(chen.getId(), "zhangxia", 27);
		mongoTemplate.save(zhang);
		
		Person qp1 = mongoTemplate.findOne(query(where("id").is(chen.getId())), Person.class);
		Assert.assertEquals(qp1.getName(), zhang.getName());
	}
}
