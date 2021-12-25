package com.onurkus.springboot.controller;

import com.onurkus.springboot.converter.ReviewConverter;
import com.onurkus.springboot.converter.UserConverter;
import com.onurkus.springboot.dto.ReviewDto;
import com.onurkus.springboot.dto.UserDto;
import com.onurkus.springboot.entity.ProductReview;
import com.onurkus.springboot.entity.User;
import com.onurkus.springboot.service.entityservice.CategoryEntityService;
import com.onurkus.springboot.service.entityservice.ReviewEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reviews")
public class ReviewController {

    @Autowired
    private ReviewEntityService reviewEntityService;

    @GetMapping("/get-user-reviews")
    public ResponseEntity<String> findByIdUserReview(@RequestParam("id") Long id){
        String message =reviewEntityService.findByIdUserReview(id);

        return ResponseEntity.ok(message);
    }

    @GetMapping("/get-product-reviews")
    public ResponseEntity<String> findByIdProductReview(@RequestParam("id") Long id){
        String message =reviewEntityService.findByIdProductReview(id);

        return ResponseEntity.ok(message);
    }

    @PostMapping("/add-review")
    public ResponseEntity<String> addReview(@RequestBody ReviewDto reviewDto){

        ProductReview productReview = ReviewConverter.INSTANCE.convertFromProductReviewDtoToProductReview(reviewDto);
        reviewEntityService.save(productReview);

        return ResponseEntity.ok("Successful");
    }

    @DeleteMapping("/delete-review")
    public void deleteReview(Long id){
        reviewEntityService.deleteById(id);
    }

}
