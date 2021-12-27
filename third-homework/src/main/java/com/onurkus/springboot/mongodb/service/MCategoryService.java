package com.onurkus.springboot.mongodb.service;

import com.onurkus.springboot.mongodb.entity.MCategory;

import java.util.List;

public interface MCategoryService {

    List<MCategory> findAll();

    MCategory findById(String id) ;

    MCategory save(MCategory category);

    void delete(String id) ;
}
