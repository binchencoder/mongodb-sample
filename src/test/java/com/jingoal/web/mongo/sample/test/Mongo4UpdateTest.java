package com.jingoal.web.mongo.sample.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jingoal.web.mongodb.sample.model.Person;

@ContextConfiguration(locations = "classpath:root-context.xml")
public class Mongo4UpdateTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private MongoTemplate mongoTemplate;

	@BeforeClass
	public void clearCollection() {
		mongoTemplate.dropCollection(Person.class);
	}

	@AfterClass
	public void destoryCollection() {
		mongoTemplate.dropCollection(Person.class);
	}

	/**
	 * @description: mongodb update test case
	 *
	 * @author: chenbin
	 * @time: 2016年4月4日 下午10:07:32
	 */
	@Test
	public void updateTest() {
		/*
		 * Person chen = new Person("chenbin", 26); mongoTemplate.insert(chen);
		 * 
		 * Person qp = mongoTemplate.findOne(query(where("name").is("chenbin")),
		 * Person.class); Assert.assertNotNull(qp);
		 * 
		 * Person zhang = new Person(chen.getId(), "zhangxia", 27);
		 * mongoTemplate.save(zhang);
		 * 
		 * Person qp1 =
		 * mongoTemplate.findOne(query(where("id").is(chen.getId())),
		 * Person.class); Assert.assertEquals(qp1.getName(), zhang.getName());
		 */

	}
}
