package com.onurkus.springboot.mongodb.service;

import com.onurkus.springboot.mongodb.dto.MProductDetailDto;
import com.onurkus.springboot.mongodb.entity.MProduct;

import java.util.List;

public interface MProductService {

    List<MProduct> findAll();

    MProduct findById(String id);

    MProductDetailDto findProductDetailDtoById(String id);

    MProduct save(MProduct product);

    void deleteById(String id);

    List<MProductDetailDto> findAllProductByCategoryId(String categoryId);
}
