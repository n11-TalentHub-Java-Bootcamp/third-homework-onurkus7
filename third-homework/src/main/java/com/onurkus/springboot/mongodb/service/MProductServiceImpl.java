package com.onurkus.springboot.mongodb.service;

import com.onurkus.springboot.mongodb.converter.MProductConverter;
import com.onurkus.springboot.mongodb.dto.MProductDetailDto;
import com.onurkus.springboot.mongodb.entity.MProduct;
import com.onurkus.springboot.mongodb.service.entityservice.MProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MProductServiceImpl implements MProductService {

    @Autowired
    private MProductEntityService productEntityService;

    @Override
    public List<MProduct> findAll() {
        return productEntityService.findAll();
    }

    @Override
    public MProduct findById(String id) {
        return productEntityService.findById(id);
    }

    @Override
    public MProductDetailDto findProductDetailDtoById(String id) {

        MProduct product = productEntityService.findById(id);

        MProductDetailDto productDetailDto = MProductConverter.INSTANCE.convertProductToProductDetailDto(product);

        return productDetailDto;
    }

    @Override
    public MProduct save(MProduct product) {
        return productEntityService.save(product);
    }

    @Override
    public void deleteById(String id) {
        productEntityService.delete(id);
    }

    @Override
    public List<MProductDetailDto> findAllProductByCategoryId(String categoryId) {

        List<MProduct> productList = productEntityService.findAllProductByCategoryId(categoryId);

        List<MProductDetailDto> productDetailDtoList = MProductConverter.INSTANCE.convertAllProductListToProductDetailDtoList(productList);

        return productDetailDtoList;
    }
}
