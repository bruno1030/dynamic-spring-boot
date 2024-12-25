package com.dynamic.mapper;

import com.dynamic.dto.ProductDto;
import com.dynamic.entity.Product;

public class ProductMapper {

    public static ProductDto toDto(Product product){
        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setBrand(product.getBrand());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setStockQuantity(product.getStockQuantity());
        productDto.setValue(product.getValue());
        productDto.setImageUrl(product.getImageUrl());

        return productDto;
    }

    public static Product toProduct(ProductDto productDto){
        Product product = new Product();

        product.setBrand(productDto.getBrand());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setStockQuantity(productDto.getStockQuantity());
        product.setValue(productDto.getValue());

        return product;
    }

}
