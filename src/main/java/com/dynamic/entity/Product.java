package com.dynamic.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("products")
@Getter
@Setter
public class Product {

    @Id
    private Integer id;

    private String description;

    private Double value;

    private Integer stockQuantity;

    private String title;

    private String brand;

    private String imageUrl;
}
