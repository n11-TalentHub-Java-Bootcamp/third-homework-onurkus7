package com.onurkus.springboot.converter;

import com.onurkus.springboot.dto.CategoryDto;
import com.onurkus.springboot.entity.Category;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryConverter {

    CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);

    @Mapping(source ="topCategory.id",target ="topCategoryId")
    CategoryDto convertCategoryToCategoryDto(Category category);

    @Mapping(source ="topCategory.id",target ="topCategoryId")
    List<CategoryDto> convertAllCategoryListToCategoryDtoList(List<Category> categoryList);

    @Mapping(source ="topCategoryId",target ="topCategory.id")
    Category convertCategoryDtoToCategory(CategoryDto categoryDto);

    @AfterMapping
    default void setNulls(@MappingTarget Category category, CategoryDto categoryDto){
        if (categoryDto.getTopCategoryId() == null){
            category.setTopCategory(null);
        }
    }
}
