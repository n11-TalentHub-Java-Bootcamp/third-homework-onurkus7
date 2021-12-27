package com.onurkus.springboot.mongodb.service.entityservice;

import com.onurkus.springboot.mongodb.entity.MProductReview;
import com.onurkus.springboot.mongodb.repository.MReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MReviewEntityService {

    @Autowired
    private MReviewRepository reviewRepository;

    public List<MProductReview> findAll(){
        return reviewRepository.findAll();
    }

    public MProductReview findById(String id){

        Optional<MProductReview> optional = reviewRepository.findById(id);

        MProductReview productReview = null;
        if (optional.isPresent()){
            productReview = optional.get();
        }

        return productReview;
    }

    public MProductReview save(MProductReview productReview){
        return reviewRepository.save(productReview);
    }

    public void deleteById(String id){
        reviewRepository.deleteById(id);
    }
}
