package com.jingoal.web.mongodb.sample.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jingoal.web.mongodb.sample.model.User;

public interface UserRepository extends CrudRepository<User, Long>, UserRepositoryCustom {

	// Declare query methods here

}