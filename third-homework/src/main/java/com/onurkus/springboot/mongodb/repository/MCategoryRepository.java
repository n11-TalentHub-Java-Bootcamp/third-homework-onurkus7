package com.onurkus.springboot.mongodb.repository;

import com.onurkus.springboot.mongodb.entity.MCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MCategoryRepository extends MongoRepository<MCategory, String> {
}
