package com.onurkus.springboot.converter;

import com.onurkus.springboot.dto.ReviewDto;
import com.onurkus.springboot.entity.ProductReview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewConverter {

    ReviewConverter INSTANCE = Mappers.getMapper(ReviewConverter.class);

    @Mapping(source = "id",target = "id")
    @Mapping(source = "review",target = "review")
    @Mapping(source = "reviewDate",target = "reviewDate")
    @Mapping(source = "productId",target = "productId")
    @Mapping(source = "userId",target = "userId")
    ProductReview convertFromProductReviewDtoToProductReview(ReviewDto reviewDto);

}
