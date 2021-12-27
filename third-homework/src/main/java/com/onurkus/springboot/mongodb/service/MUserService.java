package com.onurkus.springboot.mongodb.service;

import com.onurkus.springboot.mongodb.entity.MUser;

import java.util.List;

public interface MUserService {

    List<MUser> findAll();

    MUser findById(String id) ;

    MUser save(MUser user);

    void delete(String id) ;
}
