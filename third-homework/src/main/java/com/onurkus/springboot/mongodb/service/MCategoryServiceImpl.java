package com.onurkus.springboot.mongodb.service;

import com.onurkus.springboot.mongodb.entity.MCategory;
import com.onurkus.springboot.mongodb.service.entityservice.MCategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MCategoryServiceImpl implements MCategoryService {

    @Autowired
    private MCategoryEntityService categoryEntityService;

    public List<MCategory> findAll() {
        return categoryEntityService.findAll();
    }

    public MCategory findById(String id) {
        return categoryEntityService.findById(id);
    }

    public MCategory save(MCategory category) {
        return categoryEntityService.save(category);
    }

    public void delete(String id) {
        categoryEntityService.deleteById(id);
    }
}
