package com.dynamic.service;

import com.dynamic.dto.ProductDto;
import com.dynamic.entity.Product;
import com.dynamic.mapper.ProductMapper;
import com.dynamic.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getProducts(){

        List<Product> productsList = productRepository.findAll();

        List<ProductDto> productDtoList = new ArrayList<>();

        for (Product product : productsList) {
            if(product != null){
                productDtoList.add(ProductMapper.toDto(product));
            }
        }

        return productDtoList;
    }

    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    public Product updateProduct(Product product) {
        Product updatedProduct = productRepository.save(product);
        return updatedProduct;
    }

    public Product findProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        }
        return null;
    }
}
