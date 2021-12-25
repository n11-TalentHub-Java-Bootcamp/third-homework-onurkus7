package com.onurkus.springboot.service.entityservice;

import com.onurkus.springboot.dao.UserDao;
import com.onurkus.springboot.entity.User;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserEntityService {

    @Autowired
    private UserDao userDao;
    public List<User> findAll(){
        return (List<User>) userDao.findAll();
    }

    public User findById(Long id){
        Optional<User> optionalUser = userDao.findById(id);

        User user = null;
        if (optionalUser.isPresent()){
            user = optionalUser.get();
        }

        return user;
    }

    public User save(User user){
        return userDao.save(user);
    }

    public void delete(User user){
        userDao.delete(user);
    }

    public void deleteById(Long id){
        userDao.deleteById(id);
    }

    public User findByUserName(String username){
        return userDao.findByUserName(username);
    }

    public User findByPhoneNumber(String phoneNumber){
        return userDao.findByPhoneNumber(phoneNumber);
    }
    public String deleteUserByUserNameAndPhoneNumber(String userName,String phoneNumber){

        User user= userDao.deleteUserByUserNameAndPhoneNumber(userName,phoneNumber);
        if(ObjectUtils.isEmpty(user)){
            return userName+"username and "+phoneNumber+" phone information do not match.";
        }
        return "user successfully deleted";
    }

}
