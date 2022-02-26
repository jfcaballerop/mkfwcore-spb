package com.mrknight.core.services.usersvc.repository;

import com.mrknight.core.services.usersvc.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
