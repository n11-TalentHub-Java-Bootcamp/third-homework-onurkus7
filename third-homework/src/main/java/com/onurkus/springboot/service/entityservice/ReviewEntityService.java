package com.onurkus.springboot.service.entityservice;

import com.onurkus.springboot.dao.CategoryDao;
import com.onurkus.springboot.dao.ReviewDao;
import com.onurkus.springboot.dto.ReviewDto;
import com.onurkus.springboot.entity.ProductReview;
import com.onurkus.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewEntityService {

    @Autowired
    private ReviewDao reviewDao;

    public String findByIdUserReview(Long id){
        List<ProductReview> productReviewList=reviewDao.findReviewByUserId(id);
        if(productReviewList.size()==0)
            return id+" users have not written any comments yet";
        return "Successful";
    }

    public String findByIdProductReview(Long id){
        List<ProductReview> productReviewList=reviewDao.findReviewByProductId(id);
        if(productReviewList.size()==0)
            return id+" users have not written any comments yet";
        return "Successful";
    }

    public ProductReview save(ProductReview productReview){
        return reviewDao.save(productReview);
    }

    public void deleteById(Long id){
        reviewDao.deleteById(id);
    }

}
