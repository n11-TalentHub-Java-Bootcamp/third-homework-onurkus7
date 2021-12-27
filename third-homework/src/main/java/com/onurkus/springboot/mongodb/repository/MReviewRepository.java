package com.onurkus.springboot.mongodb.repository;

import com.onurkus.springboot.mongodb.entity.MProductReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MReviewRepository extends MongoRepository<MProductReview, String> {
}
