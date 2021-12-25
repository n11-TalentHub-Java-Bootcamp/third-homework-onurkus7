package com.onurkus.springboot.converter;

import com.onurkus.springboot.dto.ProductDetailDto;
import com.onurkus.springboot.dto.ProductDto;
import com.onurkus.springboot.entity.Product;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {

    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    @Mapping(source = "categoryId",target = "category.id")
    Product convertProductDtoToProduct(ProductDto productDto);

    @Mapping(source = "category.id",target = "categoryId")
    ProductDto convertProductToProductDto(Product product);

    @Mapping(source = "name", target = "productName")
    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "price", target = "productPrice")
    ProductDetailDto convertProductToProductDetailDto(Product product);

    @Mapping(source = "name", target = "productName")
    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "price", target = "productPrice")
    List<ProductDetailDto> convertAllProductListToProductDetailDtoList(List<Product> productList);

    @AfterMapping
    default void setNulls(@MappingTarget final Product product, ProductDto productDto){
        if (productDto.getCategoryId() == null){
            product.setCategory(null);
        }
    }


}
