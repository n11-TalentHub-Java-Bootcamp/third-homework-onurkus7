package com.onurkus.springboot.mongodb.service.entityservice;

import com.onurkus.springboot.mongodb.entity.MCategory;
import com.onurkus.springboot.mongodb.repository.MCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MCategoryEntityService {

    @Autowired
    private MCategoryRepository categoryRepository;

    public List<MCategory> findAll(){
        return categoryRepository.findAll();
    }

    public MCategory findById(String id){

        Optional<MCategory> optional = categoryRepository.findById(id);

        MCategory category = null;
        if (optional.isPresent()){
            category = optional.get();
        }

        return category;
    }

    public void deleteById(String id){
        categoryRepository.deleteById(id);
    }

    public MCategory save(MCategory category){
        return categoryRepository.save(category);
    }
}
