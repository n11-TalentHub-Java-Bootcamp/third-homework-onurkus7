package com.onurkus.springboot.mongodb.repository;

import com.onurkus.springboot.mongodb.entity.MUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MUserRepository extends MongoRepository<MUser, String> {
}
