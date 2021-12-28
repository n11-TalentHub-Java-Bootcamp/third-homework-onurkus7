package com.onurkus.springboot.mongodb.controller;

import com.onurkus.springboot.mongodb.entity.MProductReview;
import com.onurkus.springboot.mongodb.service.MReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongo/product-reviews")
public class MReviewController {

    @Autowired
    private MReviewService reviewService;

    @GetMapping("/")
    public List<MProductReview> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public MProductReview findById(@PathVariable String id) {
        return reviewService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody MProductReview productReview) {

        productReview = reviewService.save(productReview);

        return new ResponseEntity<>(productReview, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable String id){
        reviewService.delete(id);
    }

}
