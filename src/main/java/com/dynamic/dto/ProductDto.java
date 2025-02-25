package com.dynamic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Integer id;

    private String description;

    private Double value;

    private Integer stockQuantity;

    private String title;

    private String brand;

    private String imageUrl;
}
