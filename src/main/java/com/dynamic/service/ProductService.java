package com.dynamic.service;

import com.dynamic.dto.ProductDto;
import com.dynamic.entity.Product;
import com.dynamic.mapper.ProductMapper;
import com.dynamic.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> GetProducts(){

        List<Product> productsList = productRepository.findAll();

        List<ProductDto> productDtoList = new ArrayList<>();

        for (Product product : productsList) {
            if(product != null){
                productDtoList.add(ProductMapper.toDto(product));
            }
        }

        return productDtoList;
    }

    public void CreateProduct(Product product) {
        productRepository.save(product);
    }
}
