package com.onurkus.springboot.dto;

public class CategoryDto {

    private Long id;
    private String name;
    private Long split;
    private Long topCategoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSplit() {
        return split;
    }

    public void setSplit(Long split) {
        this.split = split;
    }

    public Long getTopCategoryId() {
        return topCategoryId;
    }

    public void setTopCategoryId(Long topCategoryId) {
        this.topCategoryId = topCategoryId;
    }
}
