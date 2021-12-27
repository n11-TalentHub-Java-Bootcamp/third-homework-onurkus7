package com.onurkus.springboot.mongodb.service;

import com.onurkus.springboot.mongodb.entity.MProductReview;

import java.util.List;

public interface MReviewService {

    List<MProductReview> findAll();

    MProductReview findById(String id) ;

    MProductReview save(MProductReview productReview);

    void delete(String id) ;
}
