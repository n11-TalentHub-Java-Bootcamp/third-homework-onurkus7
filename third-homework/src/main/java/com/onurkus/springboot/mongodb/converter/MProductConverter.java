package com.onurkus.springboot.mongodb.converter;

import com.onurkus.springboot.mongodb.dto.MProductDetailDto;
import com.onurkus.springboot.mongodb.entity.MProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MProductConverter {

    MProductConverter INSTANCE = Mappers.getMapper(MProductConverter.class);

    @Mapping(target = "productName", source = "name")
    @Mapping(target = "productPrice", source = "price")
    MProductDetailDto convertProductToProductDetailDto(MProduct product);

    @Mapping(target = "productName", source = "name")
    @Mapping(target = "productPrice", source = "price")
    List<MProductDetailDto> convertAllProductListToProductDetailDtoList(List<MProduct> product);

//    @AfterMapping
//    default void setCategoryName(@MappingTarget final ProductDetailDto productDetailDto,
//                                 Product product){
//        if (product.getCategoryId() == null){
//            urun.setKategori(null);
//        }
//    }
}
