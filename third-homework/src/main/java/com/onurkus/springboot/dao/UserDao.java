package com.onurkus.springboot.dao;

import com.onurkus.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long>  {

    User findByUserName(String userName);

    User findByPhoneNumber(String phoneNumber);

    User deleteUserByUserNameAndPhoneNumber(String userName,String phoneNumber);

}

