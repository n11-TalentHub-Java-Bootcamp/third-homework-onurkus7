package com.onurkus.springboot.mongodb.controller;

import com.onurkus.springboot.mongodb.entity.MCategory;
import com.onurkus.springboot.mongodb.service.MCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongodb/categories/")
public class MCategoryController {

    @Autowired
    private MCategoryService categoryService;

    @GetMapping("")
    public List<MCategory> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public MCategory findById(@PathVariable String id) {
        return categoryService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody MCategory category) {

        category = categoryService.save(category);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        categoryService.delete(id);
    }

}
