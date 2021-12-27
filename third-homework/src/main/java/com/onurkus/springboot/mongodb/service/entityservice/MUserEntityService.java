package com.onurkus.springboot.mongodb.service.entityservice;

import com.onurkus.springboot.mongodb.entity.MUser;
import com.onurkus.springboot.mongodb.repository.MUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MUserEntityService {

    @Autowired
    private MUserRepository userRepository;

    public List<MUser> findAll(){
        return userRepository.findAll();
    }

    public MUser findById(String id){
        Optional<MUser> optional = userRepository.findById(id);

        MUser user=null;
        if(optional.isPresent()){
            user=optional.get();
        }

        return user;
    }

    public MUser save(MUser user){
        return userRepository.save(user);
    }

    public void deleteById(String id){
        userRepository.deleteById(id);
    }


}
