package com.onurkus.springboot.mongodb.service;

import com.onurkus.springboot.mongodb.entity.MProductReview;
import com.onurkus.springboot.mongodb.service.entityservice.MReviewEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MReviewServiceImpl implements MReviewService{

    @Autowired
    private MReviewEntityService reviewEntityService;

    public List<MProductReview> findAll() {
        return reviewEntityService.findAll();
    }

    public MProductReview findById(String id) {
        return reviewEntityService.findById(id);
    }

    public MProductReview save(MProductReview productReview) {
        return reviewEntityService.save(productReview);
    }

    public void delete(String id) {
        reviewEntityService.deleteById(id);
    }
}
