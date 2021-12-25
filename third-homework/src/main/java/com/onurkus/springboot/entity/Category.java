package com.onurkus.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable {

    public Category() {
    }

    public Category(Long id, String name, Long split, Category topCategory) {
        this.id = id;
        this.name = name;
        this.split = split;
        this.topCategory = topCategory;
    }

    @SequenceGenerator(name = "generator", sequenceName = "CATEGORY_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "SPLIT")
    private Long split;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TOP_CATEGORY")
    private Category topCategory;

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

    public Category getTopCategory() {
        return topCategory;
    }

    public void setTopCategory(Category topCategory) {
        this.topCategory = topCategory;
    }

    @Override
    public String toString(){
        return id == null ? "" :id.toString();
    }
}
