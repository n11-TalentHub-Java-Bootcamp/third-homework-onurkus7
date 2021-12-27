package com.onurkus.springboot.mongodb.controller;

import com.onurkus.springboot.mongodb.entity.MUser;
import com.onurkus.springboot.mongodb.service.MUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongodb/users")
public class MUserController {

    @Autowired
    private MUserService userService;

    @GetMapping("")
    public List<MUser> findAll() {
        return userService.findAll();
    }

    @GetMapping("/")
    public MUser findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody MUser user) {

        user = userService.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable String id){

    }

}
