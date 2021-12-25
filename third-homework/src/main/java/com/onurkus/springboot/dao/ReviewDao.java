package com.onurkus.springboot.dao;

import com.onurkus.springboot.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDao extends JpaRepository<ProductReview, Long> {

    List<ProductReview> findReviewByUserId(Long id);

    List<ProductReview> findReviewByProductId(Long id);

}
