package com.onurkus.springboot.mongodb.repository;

import com.onurkus.springboot.mongodb.dto.MProductDetailDto;
import com.onurkus.springboot.mongodb.entity.MProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MProductRepository extends MongoRepository<MProduct, String> {

    List<MProduct> findAllByCategoryId(String categoryId);

    MProductDetailDto findProductDetailDtoById(String id);
}
