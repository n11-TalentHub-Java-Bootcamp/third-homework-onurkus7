package com.onurkus.springboot.controller;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.onurkus.springboot.converter.ProductConverter;
import com.onurkus.springboot.dto.ProductDetailDto;
import com.onurkus.springboot.dto.ProductDto;
import com.onurkus.springboot.entity.Product;
import com.onurkus.springboot.exeption.ProductNotFoundException;
import com.onurkus.springboot.service.entityservice.CategoryEntityService;
import com.onurkus.springboot.service.entityservice.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductEntityService productEntityService;

    @Autowired
    private CategoryEntityService categoryEntityService;

    @GetMapping("")
    public MappingJacksonValue findAllProductList(){

        List<Product> productList = productEntityService.findAll();

        String filterName = "ProductFilter";

        SimpleFilterProvider filters = getProductFilterProvider(filterName);

        MappingJacksonValue mapping = new MappingJacksonValue(productList);

        mapping.setFilters(filters);

        return mapping;
    }
    
    @GetMapping("/{id}")
    public MappingJacksonValue findProductById(@PathVariable Long id){

        Product product=productEntityService.findById(id);

        if(product==null){
            throw new ProductNotFoundException("Product not found. id: "+id);
        }

        WebMvcLinkBuilder linkToProduct = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass())
                        .findAllProductList()
        );

        ProductDto productDto = ProductConverter.INSTANCE.convertProductToProductDto(product);

        String filterName = "ProductDtoFilter";

        SimpleFilterProvider filters = getProductFilterProvider(filterName);

        EntityModel entityModel=EntityModel.of(productDto);

        entityModel.add(linkToProduct.withRel("all-products"));

        MappingJacksonValue mapping=new MappingJacksonValue(entityModel);

        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/detail/{id}")
    public ProductDetailDto findProductDtoById(@PathVariable Long id){

        Product product = productEntityService.findById(id);

        if (product == null){
            throw new ProductNotFoundException("Product not found. id: " + id);
        }

        ProductDetailDto productDetailDto = ProductConverter.INSTANCE.convertProductToProductDetailDto(product);

        return productDetailDto;
    }

    @PostMapping("")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDto productDto){

        Product product = ProductConverter.INSTANCE.convertProductDtoToProduct(productDto);

        product=productEntityService.save(product);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id){
        productEntityService.deleteById(id);
    }

    @GetMapping("categories/{categoryId}")
    public List<ProductDetailDto> findAllProductByCategoryId(@PathVariable Long categoryId){

        List<Product> productList = productEntityService.findAllByCategoryOrderByIdDesc(categoryId);

        List<ProductDetailDto> productDetailDtoList = ProductConverter.INSTANCE.convertAllProductListToProductDetailDtoList(productList);

        return productDetailDtoList;
    }

    private SimpleFilterProvider getProductFilterProvider(String filterName) {
        SimpleBeanPropertyFilter filter = getProductFilter();

        return new SimpleFilterProvider().addFilter(filterName, filter);
    }

    private SimpleBeanPropertyFilter getProductFilter() {
        return SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "price", "registerDate");
    }


}
