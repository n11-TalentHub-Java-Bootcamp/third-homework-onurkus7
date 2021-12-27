package com.onurkus.springboot.mongodb.controller;

import com.onurkus.springboot.mongodb.dto.MProductDetailDto;
import com.onurkus.springboot.mongodb.entity.MProduct;
import com.onurkus.springboot.mongodb.service.MProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongodb/products/")
public class MProductController {

    @Autowired
    private MProductService productService;

    @GetMapping("")
    public MappingJacksonValue findAllUrunList() {

        List<MProduct> productList = productService.findAll();

        MappingJacksonValue mapping = new MappingJacksonValue(productList);

        return mapping;

    }

    @GetMapping("/{id}")
    public MappingJacksonValue findUrunById(@PathVariable String id){

        MProduct product = productService.findById(id);

        WebMvcLinkBuilder linkToUrun = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass())
                        .findAllUrunList()
        );

        EntityModel entityModel = EntityModel.of(product);

        entityModel.add(linkToUrun.withRel("tum-urunler"));

        MappingJacksonValue mapping = new MappingJacksonValue(entityModel);

        return mapping;

//        return productService.findById(id);
    }

    @GetMapping("/detail/{id}")
    public MProductDetailDto findProductDetailDtoById(@PathVariable String id){
        return productService.findProductDetailDtoById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> saveUrun(/**@Valid*/ @RequestBody MProduct product){
        product = productService.save(product);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteUrun(@PathVariable String id){
        productService.deleteById(id);
    }

    @GetMapping("kategoriler/{categoryId}")
    public List<MProductDetailDto> findAllUrunByKategoriId(@PathVariable String categoryId){
        return productService.findAllProductByCategoryId(categoryId);
    }
}
