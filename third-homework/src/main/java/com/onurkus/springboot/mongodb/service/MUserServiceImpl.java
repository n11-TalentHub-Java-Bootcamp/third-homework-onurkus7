package com.onurkus.springboot.mongodb.service;

import com.onurkus.springboot.mongodb.entity.MUser;
import com.onurkus.springboot.mongodb.service.entityservice.MUserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MUserServiceImpl implements MUserService {

    @Autowired
    private MUserEntityService userEntityService;

    public List<MUser> findAll() {
        return userEntityService.findAll();
    }

    public MUser findById(String id) {
        return userEntityService.findById(id);
    }

    public MUser save(MUser user) {
        return userEntityService.save(user);
    }

    public void delete(String id) {
        userEntityService.deleteById(id);
    }
}
