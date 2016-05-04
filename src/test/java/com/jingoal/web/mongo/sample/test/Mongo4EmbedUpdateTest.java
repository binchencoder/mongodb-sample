package com.jingoal.web.mongo.sample.test;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.math.BigInteger;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jingoal.web.mongodb.sample.model.ReadMask;
import com.jingoal.web.mongodb.sample.model.ReadMaskNode;

@ContextConfiguration(locations = "classpath:root-context.xml")
public class Mongo4EmbedUpdateTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	private static final long id = 2L;
	
	@BeforeClass
	public void clearCollection(){
		//mongoTemplate.dropCollection(ReadMask.class);
	}
	
	@AfterClass
	public void destoryCollection(){
		//mongoTemplate.dropCollection(ReadMask.class);
	}
	
	@Test
	public void insertEmbedDocumentTest(){
		ReadMask mask = new ReadMask();
		mask.setId(BigInteger.valueOf(id));
		
		ReadMaskNode root = new ReadMaskNode();
		root.setItemKey("igoal." + 123L);
		root.setChildren(new HashSet<ReadMaskNode>(0));
		mask.setRoot(root);
		
		mongoTemplate.insert(mask);
	}
	
	/**
	 * @description: error testcase
	 * 
	 * @author: chenbin
	 * @time: 2016年5月4日 下午11:39:54
	 */
	@Test
	public void updateEmbedDocumentTest(){
		MongoOperations operations = (MongoOperations) mongoTemplate;
		
		ReadMaskNode node = new ReadMaskNode();
		node.setItemKey("frame." + 123L);
		node.setChildren(new HashSet<ReadMaskNode>(0));
		
		Update update = new Update();
		update.push("children", node);
		
		operations.updateFirst(query(where("itemKey").is("igoal." + 123L)), update, ReadMask.class);
		
	}
}
