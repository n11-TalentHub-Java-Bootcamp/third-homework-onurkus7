package com.onurkus.springboot.mongodb.service.entityservice;

import com.onurkus.springboot.mongodb.entity.MProduct;
import com.onurkus.springboot.mongodb.repository.MProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MProductEntityService {

    @Autowired
    private MProductRepository productRepository;

    public List<MProduct> findAll(){
        return productRepository.findAll();
    }

    public MProduct findById(String id){

        Optional<MProduct> optional = productRepository.findById(id);

        MProduct product = null;
        if (optional.isPresent()){
            product = optional.get();
        }

        return product;
    }

    public MProduct save(MProduct product){
        return productRepository.save(product);
    }

    public void delete(String id){
        productRepository.deleteById(id);
    }

    public List<MProduct> findAllProductByCategoryId(String categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }

}
