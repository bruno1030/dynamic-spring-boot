package com.dynamic.controller;

import com.dynamic.dto.ProductDto;
import com.dynamic.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getProducts(){

        List<ProductDto> productDtoList = productService.GetProducts();

        return productDtoList;
    }

}
