package com.onurkus.springboot.controller;

import com.onurkus.springboot.converter.CategoryConverter;
import com.onurkus.springboot.converter.ProductConverter;
import com.onurkus.springboot.dto.CategoryDto;
import com.onurkus.springboot.dto.ProductDetailDto;
import com.onurkus.springboot.entity.Category;
import com.onurkus.springboot.entity.Product;
import com.onurkus.springboot.service.entityservice.CategoryEntityService;
import com.onurkus.springboot.service.entityservice.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private ProductEntityService productEntityService;

    @GetMapping("")
    public List<CategoryDto> findAll(){
        List<Category> categoryList=categoryEntityService.findAll();

        List<CategoryDto> categoryDtoList = CategoryConverter.INSTANCE.convertAllCategoryListToCategoryDtoList(categoryList);

        return categoryDtoList;
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id){
        Category category = categoryEntityService.findById(id);
        return category;
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody CategoryDto categoryDto){ //TODO: Input değeri dto tipinde olmalı

        Category category = CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);

        category = categoryEntityService.save(category);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("")
    public CategoryDto update(@RequestBody CategoryDto categoryDto){//TODO: Input değeri dto tipinde olmalı

        Category category = CategoryConverter.INSTANCE.convertCategoryDtoToCategory(categoryDto);

        //TODO: Check it
        if (category.getTopCategory() != null && category.getTopCategory().getId() == null){
            category.setTopCategory(null);
        }

        category = categoryEntityService.save(category);

        CategoryDto categoryDtoResult = CategoryConverter.INSTANCE.convertCategoryToCategoryDto(category);

        return categoryDtoResult;
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        categoryEntityService.deleteById(id);
    }

    @GetMapping("/{id}/products")
    public List<ProductDetailDto> findAllProductByCategoryId(@PathVariable Long id){
        List<Product> productList = productEntityService.findAllByCategoryOrderByIdDesc(id);

        List<ProductDetailDto> productDetailDtoList = ProductConverter.INSTANCE.convertAllProductListToProductDetailDtoList(productList);

        return productDetailDtoList;
    }
}
